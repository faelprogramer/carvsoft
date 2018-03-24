/*    */ package br.com.carvsoft.model.util.seguranca;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WhebSHA1
/*    */ {
/*    */   public static String gerarHash(String frase)
/*    */   {
/*    */     try
/*    */     {
/* 14 */       MessageDigest md = MessageDigest.getInstance("SHA-1");
/* 15 */       md.update(frase.getBytes());
/*    */       
/* 17 */       return stringHexa(md.digest());
/*    */     } catch (NoSuchAlgorithmException e) {}
/* 19 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   private static String stringHexa(byte[] bytes)
/*    */   {
/* 25 */     StringBuilder s = new StringBuilder();
/* 26 */     for (int i = 0; i < bytes.length; i++) {
/* 27 */       int parteAlta = (bytes[i] >> 4 & 0xF) << 4;
/* 28 */       int parteBaixa = bytes[i] & 0xF;
/* 29 */       if (parteAlta == 0) s.append('0');
/* 30 */       s.append(Integer.toHexString(parteAlta | parteBaixa));
/*    */     }
/* 32 */     return s.toString();
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/WhebSHA1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */