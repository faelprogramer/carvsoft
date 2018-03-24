package br.com.carvsoft.model.util.seguranca;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class WhebCriptografiaRSA {

    private static Cipher cipher;
    private static final String ALGORITMO = "RSA";
    private static KeyPair parChaves = null;

    private static void inicializa() throws NoSuchAlgorithmException, NoSuchPaddingException {
        cipher = Cipher.getInstance(ALGORITMO);
    }

    public static void gerarChave(int tamanho) {
        try {
            inicializa();
            KeyPairGenerator kgen = KeyPairGenerator.getInstance(ALGORITMO);
            kgen.initialize(tamanho);
            parChaves = kgen.generateKeyPair();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
        }
    }

    public static String getChavePrivada() {
        if (parChaves == null) {
            gerarChave(512);
        }
        return Hexadecimal.bytesToHex(parChaves.getPrivate().getEncoded());
    }

    public static String getChavePublica() {
        if (parChaves == null) {
            gerarChave(512);
        }
        return Hexadecimal.bytesToHex(parChaves.getPublic().getEncoded());
    }

    public static String criptografa(String chavePublicaHex, String texto) {

        try {
            inicializa();
            KeyFactory keyFac = KeyFactory.getInstance(ALGORITMO);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Hexadecimal.hexToBytes(chavePublicaHex));
            PublicKey key = keyFac.generatePublic(keySpec);
            cipher.init(1, key);
            byte[] b = cipher.doFinal(texto.getBytes());
            return Hexadecimal.bytesToHex(b);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {

        }
        return null;
    }

    public static String descriptografa(String chavePrivadaHex, String textoHex) {
        try {
            inicializa();
            KeyFactory keyFac = KeyFactory.getInstance(ALGORITMO);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Hexadecimal.hexToBytes(chavePrivadaHex));
            PrivateKey key = keyFac.generatePrivate(keySpec);
            cipher.init(2, key);
            return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        gerarChave(1620);
        String pri = getChavePrivada();
        String pu = getChavePublica();
        String tex = "Luis Coelho";
        String textCrip = criptografa(pu, tex);
        String textDescrip = descriptografa(pri, textCrip);
        System.out.println("Privada - > " + pri);
        System.out.println("Publica - > " + pu);
        System.out.println("Texto - > " + tex);
        System.out.println("Text Crip -> " + textCrip);
        System.out.println("Text Descri -> " + textDescrip);
    }
}
