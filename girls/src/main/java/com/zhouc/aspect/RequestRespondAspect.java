package com.zhouc.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/8.
 */
@Component
@Aspect
public class RequestRespondAspect {

    private static final Logger log = LoggerFactory.getLogger(RequestRespondAspect.class);

    private Long enterTimes = 0L;

    @Pointcut("execution(* com.zhouc.controller.GirlController.*(..) ) ")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint point) {
       enterTimes = System.currentTimeMillis();
       RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = (HttpServletRequest) attributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
       String ip = request.getRemoteAddr();
       String method = request.getMethod();
       Signature signature = point.getSignature();
       String className = signature.getDeclaringTypeName();
       String classMethodName = signature.getName();
       Map<String, String[]> pa = request.getParameterMap();
       String parameter = "";
       if (null != pa) {
           Gson gson = new Gson();
           parameter = gson.toJson(pa);
       }
       log.info("{} {} {}.{} {}", ip, method, className, classMethodName, parameter);

    }

    @After("pointCut()")
    public void after() {
        log.info("end run times {}", System.currentTimeMillis() - enterTimes);
    }

    @AfterReturning(pointcut = "pointCut()", returning = "obj")
    public void afterRunning(Object obj) {
        String objJson = "";
        if (null != obj) {
            objJson = new Gson().toJson(obj);
        }
        log.info("return {}", objJson);
    }
}
