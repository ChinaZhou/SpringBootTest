package com.example.demo.util;

/**
 * Created by Administrator on 2017/12/13.
 */
public class Filename {
    /*    */   private String fullPath;
    /*    */
/*    */
/*    */   private char pathSeparator;
    /*    */
/*    */
/*    */   private char extensionSeparator;
    /*    */
/*    */
/*    */
/*    */   public Filename(String str)
/*    */   {
/* 20 */     this.fullPath = str;
/* 21 */     this.pathSeparator = '/';
/* 22 */     this.extensionSeparator = '.';
/*    */   }
    /*    */
/*    */
/*    */
/*    */
/*    */
/*    */   public String extension()
/*    */   {
/* 31 */     int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
/* 32 */     return this.fullPath.substring(dot + 1);
/*    */   }
    /*    */
/*    */
/*    */
/*    */
/*    */
/*    */   public String filename()
/*    */   {
/* 41 */     int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
/* 42 */     int sep = this.fullPath.lastIndexOf(this.pathSeparator);
/* 43 */     return this.fullPath.substring(sep + 1, dot);
/*    */   }
    /*    */
/*    */
/*    */
/*    */
/*    */
/*    */   public String path()
/*    */   {
/* 52 */     int sep = this.fullPath.lastIndexOf(this.pathSeparator);
/* 53 */     return this.fullPath.substring(0, sep);
/*    */   }
/*    */
}
