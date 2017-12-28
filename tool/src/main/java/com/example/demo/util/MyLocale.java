package com.example.demo.util;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MyLocale {
    private String propertyName = "package";
    private String country;
    private String launage;
    private Locale locale;
    private ResourceBundle resourceBundle;

    public MyLocale() {
        setLocale(DefaultLocale.getDefaultLocale());

        setResourceBundle(ResourceBundle.getBundle(propertyName, locale));
    }

    public MyLocale(String country) {
        setCountry(country);
        setLocale(new Locale(country));

        setResourceBundle(ResourceBundle.getBundle(propertyName, locale));
    }

    public String getText(String key, String userName, String ip) {
        key = convert(key);
        String text = key;
        try {
            text = resourceBundle.getString(key);
        } catch(Exception e) {}

        MyDate mydate = new MyDate();
        text = text.replaceAll("\\{time\\}", mydate.getCurrentTime());

        try {
            if (!StringUtils.isEmpty(userName)) {
                text = text.replaceAll("\\{name\\}", userName);
            }
            if (!StringUtils.isEmpty(ip)) {
                text = text.replaceAll("\\{ip\\}", ip);
            }
        } catch (Exception e) {}

        return text;
    }


    public String getText(String key) {
        key = convert(key);
        String text = key;
        try {
            text = resourceBundle.getString(key);
        } catch(Exception e) {}

        MyDate mydate = new MyDate();
        text = text.replaceAll("\\{time\\}", mydate.getCurrentTime());
        return text;
    }

    public String getText(String key, String arg, String userName, String ip) {
        key = convert(key);
        String text = key;
        try {
            text = resourceBundle.getString(key);
        } catch(Exception e) {}

        MyDate mydate = new MyDate();
        text = text.replaceAll("\\{time\\}", mydate.getCurrentTime());

        if (null != text) {
            text = text.replaceAll("\\{" + 0 + "\\}", arg);
            if (!StringUtils.isEmpty(userName)) {
                text = text.replaceAll("\\{name\\}", userName);
            }
            if (!StringUtils.isEmpty(ip)) {
                text = text.replaceAll("\\{ip\\}", ip);
            }
        }

        return text;
    }

    public String getText(String key, List args, String userName, String ip) {
        key = convert(key);
        String text = key;
        try {
            text = resourceBundle.getString(key);
        } catch(Exception e) {}

        MyDate mydate = new MyDate();
        text = text.replaceAll("\\{time\\}", mydate.getCurrentTime());

        if (null != text) {
            for (int i = 0; i < args.size(); i++) {
                String arg = "";
                if (null != arg) {
                    arg = "";
                    if (null != args.get(i)) {
                        arg = args.get(i).toString();
                    }
                }
                text = text.replaceAll("\\{" + i + "\\}", arg);
            }
            if (!StringUtils.isEmpty(userName)) {
                text = text.replaceAll("\\{name\\}", userName);
            }
            if (!StringUtils.isEmpty(ip)) {
                text = text.replaceAll("\\{ip\\}", ip);
            }
        }

        return text;
    }

    public String getText(String key, String userName, String ip, String... args) {
        key = convert(key);
        String text = key;
        try {
            text = resourceBundle.getString(key);
        } catch(Exception e) {}

        MyDate mydate = new MyDate();
        text = text.replaceAll("\\{time\\}", mydate.getCurrentTime());

        if (null != text) {
            for (int i = 0; i < args.length; i++) {
                String arg = "";
                if (null != arg) {
                    arg = args[i].toString();
                }
                text = text.replaceAll("\\{" + i + "\\}", arg);
            }
            if (!StringUtils.isEmpty(userName)) {
                text = text.replaceAll("\\{name\\}", userName);
            }
            if (!StringUtils.isEmpty(ip)) {
                text = text.replaceAll("\\{ip\\}", ip);
            }
        }

        return text;
    }

    public String convert(String key) {
        return key.replaceAll("_", ".").toLowerCase();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLaunage() {
        return launage;
    }

    public void setLaunage(String launage) {
        this.launage = launage;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

}
