/*    */ package br.com.carvsoft.model.util.seguranca;
/*    */ 
/*    */ import java.security.Key;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.KeyGenerator;
/*    */ import javax.crypto.SecretKey;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WhebCriptografia
/*    */ {
/*    */   private static Cipher cipher;
/*    */   
/*    */   private static void inicializa(String algoritmo)
/*    */     throws Exception
/*    */   {
/* 19 */     cipher = Cipher.getInstance(algoritmo);
/*    */   }
/*    */   
/*    */   public static String gerarChave(Integer tamanho, String algoritmo)
/*    */   {
/*    */     try
/*    */     {
/* 26 */       inicializa(algoritmo);
/* 27 */       KeyGenerator kgen = KeyGenerator.getInstance(algoritmo);
/* 28 */       kgen.init(128);
/* 29 */       SecretKey skey = kgen.generateKey();
/* 30 */       Key key = new SecretKeySpec(skey.getEncoded(), algoritmo);
/* 31 */       return Hexadecimal.bytesToHex(skey.getEncoded());
/*    */     } catch (Exception e) {
/* 33 */       return e.getMessage();
/*    */     }
/*    */   }
/*    */   
/*    */   public static String criptografa(String chaveHex, String texto, String algoritmo)
/*    */   {
/*    */     try
/*    */     {
/* 41 */       inicializa(algoritmo);
/* 42 */       SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), algoritmo);
/* 43 */       cipher.init(1, skeySpec);
/* 44 */       byte[] b = cipher.doFinal(texto.getBytes());
/* 45 */       return Hexadecimal.bytesToHex(b);
/*    */     } catch (Exception ex) {
/* 47 */       ex.printStackTrace(); }
/* 48 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public static String descriptografa(String chaveHex, String textoHex, String algoritmo)
/*    */   {
/*    */     try
/*    */     {
/* 56 */       inicializa(algoritmo);
/* 57 */       SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), algoritmo);
/* 58 */       cipher.init(2, skeySpec);
/* 59 */       return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
/*    */     } catch (Exception e) {
/* 61 */       e.printStackTrace(); }
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/WhebCriptografia.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */