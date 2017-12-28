package com.example.demo.util;

/**
 * Created by Administrator on 2017/12/13.
 */
public class ExceptionMessage {
    /*    */   public ExceptionMessage() {}
    /*    */
/*    */
/*    */
/*    */
/*    */
/*    */   public static void save(Exception e)
/*    */   {
/* 17 */     save(e, null);
/*    */   }
    /*    */
/*    */   public static void save(Exception e, String text) {
/* 21 */     e.printStackTrace();
/*    */   }
/*    */
}
