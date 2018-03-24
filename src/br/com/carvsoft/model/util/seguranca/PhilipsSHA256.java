/*    */ package br.com.carvsoft.model.util.seguranca;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PhilipsSHA256
/*    */ {
/*    */   public static String gerarHash(String frase)
/*    */   {
/*    */     try
/*    */     {
/* 19 */       MessageDigest md = MessageDigest.getInstance("SHA-256");
/* 20 */       md.update(frase.getBytes());
/*    */       
/* 22 */       return stringHexa(md.digest());
/*    */     } catch (NoSuchAlgorithmException e) {}
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   private static String stringHexa(byte[] byteData)
/*    */   {
/* 29 */     StringBuilder sb = new StringBuilder();
/* 30 */     for (int i = 0; i < byteData.length; i++) {
/* 31 */       sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
/*    */     }
/* 33 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/PhilipsSHA256.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */