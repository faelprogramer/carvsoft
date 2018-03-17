package br.com.carvsoft.model.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Carlos Rafael
 */
public abstract class Password {

    public static String criptografar(String password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
        StringBuilder hexPassword = new StringBuilder();
        for (byte aByte : digestMessage) {
            hexPassword.append(String.format("%02X", 0xFF & aByte));
        }
        return hexPassword.toString();
    }

    public static String criptografar(char[] password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        return criptografar(new String(password));
    }

    public static String gerarStringRandomica(int tamanho) {
        Random r = new Random();
        //return String.valueOf(Long.toHexString(r.nextLong()));
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0, tamanho);
    }

    private static Random rand = new Random();
    private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();

    public static String nomeAleatorio(int nCaracteres) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < nCaracteres; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String senha = "Java1408@12";

        System.err.println(criptografar(senha));
    }

}
