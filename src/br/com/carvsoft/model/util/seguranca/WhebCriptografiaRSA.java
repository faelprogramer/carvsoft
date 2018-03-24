/*     */ package br.com.carvsoft.model.util.seguranca;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.KeyPair;
/*     */ import java.security.KeyPairGenerator;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.PublicKey;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import java.security.spec.X509EncodedKeySpec;
/*     */ import javax.crypto.Cipher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WhebCriptografiaRSA
/*     */ {
/*     */   private static Cipher cipher;
/*  24 */   private static String algoritmo = "RSA";
/*  25 */   private static KeyPair parChaves = null;
/*     */   
/*     */ 
/*     */   private static void inicializa()
/*     */     throws Exception
/*     */   {
/*  31 */     cipher = Cipher.getInstance(algoritmo);
/*     */   }
/*     */   
/*     */   public static void gerarChave(int tamanho)
/*     */   {
/*     */     try
/*     */     {
/*  38 */       inicializa();
/*  39 */       KeyPairGenerator kgen = KeyPairGenerator.getInstance(algoritmo);
/*  40 */       kgen.initialize(tamanho);
/*  41 */       parChaves = kgen.generateKeyPair();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getChavePrivada() {
/*  58 */     if (parChaves == null)
/*  59 */       gerarChave(512);
/*  60 */     return Hexadecimal.bytesToHex(parChaves.getPrivate().getEncoded());
/*     */   }
/*     */   
/*  63 */   public static String getChavePublica() { if (parChaves == null)
/*  64 */       gerarChave(512);
/*  65 */     return Hexadecimal.bytesToHex(parChaves.getPublic().getEncoded());
/*     */   }
/*     */   
/*     */   public static String criptografa(String chavePublicaHex, String texto) {
/*     */     try {
/*  70 */       inicializa();
/*  71 */       KeyFactory keyFac = KeyFactory.getInstance(algoritmo);
/*  72 */       X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Hexadecimal.hexToBytes(chavePublicaHex));
/*  73 */       PublicKey key = keyFac.generatePublic(keySpec);
/*  74 */       cipher.init(1, key);
/*  75 */       byte[] b = cipher.doFinal(texto.getBytes());
/*  76 */       return Hexadecimal.bytesToHex(b);
/*     */     } catch (Exception ex) {
/*  78 */       ex.printStackTrace(); }
/*  79 */     return null;
/*     */   }
/*     */   
/*     */   public static String descriptografa(String chavePrivadaHex, String textoHex)
/*     */   {
/*     */     try {
/*  85 */       inicializa();
/*  86 */       KeyFactory keyFac = KeyFactory.getInstance(algoritmo);
/*  87 */       PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Hexadecimal.hexToBytes(chavePrivadaHex));
/*  88 */       PrivateKey key = keyFac.generatePrivate(keySpec);
/*  89 */       cipher.init(2, key);
/*  90 */       return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
/*     */     } catch (Exception e) {
/*  92 */       e.printStackTrace(); }
/*  93 */     return null;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  99 */     gerarChave(1620);
/* 100 */     String pri = getChavePrivada();
/* 101 */     String pu = getChavePublica();
/* 102 */     String tex = "Luis Coelho";
/* 103 */     String textCrip = criptografa(pu, tex);
/* 104 */     String textDescrip = descriptografa(pri, textCrip);
/*     */     
/* 106 */     System.out.println("Privada - > " + pri);
/* 107 */     System.out.println("Publica - > " + pu);
/* 108 */     System.out.println("Texto - > " + tex);
/* 109 */     System.out.println("Text Crip -> " + textCrip);
/* 110 */     System.out.println("Text Descri -> " + textDescrip);
/*     */   }
/*     */ }


/* Location:              /Users/rafael/Desktop/PalmWeb.war!/WEB-INF/lib/Wheb_Seguranca-3.01.1713.12.jar!/br/com/wheb/seguranca/WhebCriptografiaRSA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */