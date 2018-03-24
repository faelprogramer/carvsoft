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
/*    */ 
/*    */ public class WhebCriptografiaAES
/*    */ {
/*    */   private static Cipher cipher;
/*    */   
/*    */   private static void inicializa()
/*    */     throws Exception
/*    */   {
/* 21 */     cipher = Cipher.getInstance("AES");
/*    */   }
/*    */   
/*    */   public static String gerarChave(int tamanho)
/*    */   {
/*    */     try
/*    */     {
/* 28 */       inicializa();
/* 29 */       KeyGenerator kgen = KeyGenerator.getInstance("AES");
/* 30 */       kgen.init(tamanho);
/* 31 */       SecretKey skey = kgen.generateKey();
/* 32 */       Key key = new SecretKeySpec(skey.getEncoded(), "AES");
/* 33 */       return Hexadecimal.bytesToHex(skey.getEncoded());
/*    */     } catch (Exception e) {
/* 35 */       e.printStackTrace(); }
/* 36 */     return null;
/*    */   }
/*    */   
/*    */   public static String criptografa(String chaveHex, String texto)
/*    */   {
/*    */     try {
/* 42 */       inicializa();
/* 43 */       SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), "AES");
/*    */       
/* 45 */       cipher.init(1, skeySpec);
/* 46 */       byte[] b = cipher.doFinal(texto.getBytes());
/* 47 */       return Hexadecimal.bytesToHex(b);
/*    */     } catch (Exception ex) {
/* 49 */       ex.printStackTrace(); }
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public static String descriptografa(String chaveHex, String textoHex)
/*    */   {
/*    */     try {
/* 56 */       inicializa();
/* 57 */       SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), "AES");
/* 58 */       cipher.init(2, skeySpec);
/* 59 */       return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
/*    */     } catch (Exception e) {
/* 61 */       e.printStackTrace(); }
/* 62 */     return null;
/*    */   }
/*    */   
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 68 */     WhebCriptografiaAES a = new WhebCriptografiaAES();
/* 69 */     System.out.println(gerarChave(128));
/* 70 */     System.out.println(criptografa("2ab6ddbacd6cbd04d73747ba27881c4d", "Luis Fernando Coelho"));
/* 71 */     System.out.println(descriptografa("2ab6ddbacd6cbd04d73747ba27881c4d", "4205120ec13138dc7ef0e016a701012e7f46a393ebaf7a7fcda58ba0ebde8341"));
/*    */   }
/*    */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/WhebCriptografiaAES.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */