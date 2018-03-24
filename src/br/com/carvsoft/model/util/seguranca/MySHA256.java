package br.com.carvsoft.model.util.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MySHA256 {

    public static String gerarHash(String frase) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(frase.getBytes());
            return stringHexa(md.digest());
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    private static String stringHexa(byte[] byteData) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
        }
        return sb.toString();
    }
}
