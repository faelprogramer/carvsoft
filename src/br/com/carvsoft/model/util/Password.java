package br.com.carvsoft.model.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 *
 * @author Carlos Rafael
 */
public abstract class Password {

    public static String criptografarSenha(String password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
        StringBuilder hexPassword = new StringBuilder();
        for (byte aByte : digestMessage) {
            hexPassword.append(String.format("%02X", 0xFF & aByte));
        }
        return hexPassword.toString();
    }
    
    public static String criptografarSenha(String password, String salt) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        String s = misturarPasswordComSalt(password.toCharArray(), salt.toCharArray());
        return criptografarSenha(s);
    }
    
    public static String criptografarSenha(char[] password, String salt) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        String s = misturarPasswordComSalt(password, salt.toCharArray());
        return criptografarSenha(s);
    }

    public static String criptografarSenha(char[] password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        return Password.criptografarSenha(new String(password));
    }

    public static String gerarStringRandomica(int qt_caracteres) {
        char[] letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%ˆ*();:,<.>/?~_-=+}{][|'".toCharArray();
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qt_caracteres; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }
    
    private static String misturarPasswordComSalt(char[] password, char[] salt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length; i++) {
            sb.append(password[i]);
            if (salt.length > i) {
                sb.append(salt[i]);
            }
        }
        return sb.toString();
    }
    
}
