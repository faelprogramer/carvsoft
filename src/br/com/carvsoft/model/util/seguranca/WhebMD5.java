/*    */ package br.com.carvsoft.model.util.seguranca;
/*    */ 
/*    */ import java.security.MessageDigest;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WhebMD5
/*    */ {
/*    */   public static String gerarHash(String conteudo, String charset)
/*    */   {
/* 24 */     String wdgs = null;
/*    */     try {
/* 26 */       if (conteudo != null) {
/* 27 */         conteudo = conteudo.replace("\n", "");
/*    */       }
/* 29 */       MessageDigest wmd = MessageDigest.getInstance("MD5");
/* 30 */       wmd.reset();
/* 31 */       if (charset == null) {
/* 32 */         wmd.update(conteudo.getBytes());
/*    */       } else {
/* 34 */         wmd.update(conteudo.getBytes(charset));
/*    */       }
/* 36 */       byte[] wdg = wmd.digest();
/*    */       
/* 38 */       String hexString = "";
/* 39 */       for (int i = 0; i < wdg.length; i++) {
/* 40 */         String w_dup = Integer.toHexString(0xFF & wdg[i]);
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 45 */         if (w_dup.length() < 2) {
/* 46 */           w_dup = "0" + w_dup;
/*    */         }
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 52 */         hexString = hexString + w_dup;
/*    */       }
/*    */       
/* 55 */       wdgs = hexString;
/*    */       
/*    */ 
/*    */ 
/* 59 */       return wdgs;
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 56 */       ex = 
/*    */       
/*    */ 
/* 59 */         ex;ex.printStackTrace();return wdgs; } finally {} //return wdgs;
/*    */   }
/*    */   
/*    */   public static String gerarHash(String conteudo)
/*    */   {
/* 64 */     return gerarHash(conteudo, null);
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/WhebMD5.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */