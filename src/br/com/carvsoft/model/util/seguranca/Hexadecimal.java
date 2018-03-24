/*    */ package br.com.carvsoft.model.util.seguranca;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Hexadecimal
/*    */ {
/* 17 */   private static final char[] hex = "0123456789abcdef".toCharArray();
/*    */   
/*    */   public static byte[] hexToBytes(String s) {
/* 20 */     byte[] ret = new byte[s.length() / 2];
/* 21 */     for (int i = 0; i < ret.length; i++) {
/* 22 */       ret[i] = ((byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
/*    */     }
/* 24 */     return ret;
/*    */   }
/*    */   
/*    */   public static String bytesToHex(byte[] b) {
/* 28 */     char[] ret = new char[b.length * 2];
/* 29 */     int i = 0; for (int j = 0; i < b.length; i++) {
/* 30 */       ret[(j++)] = hex[((b[i] & 0xF0) >> 4)];
/* 31 */       ret[(j++)] = hex[(b[i] & 0xF)];
/*    */     }
/* 33 */     return new String(ret);
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/Hexadecimal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */