package br.com.carvsoft.model.util.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WhebAssinaturaDigital {

    public static String geraHash(String texto) {
        String sign = texto;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sign.getBytes());
            byte[] hash = md.digest();
            sign = Hexadecimal.bytesToHex(hash);
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                if ((0xFF & hash[i]) < 16) {
                    hexString.append("0").append(Integer.toHexString(0xFF & hash[i]));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            sign = hexString.toString();
        } catch (NoSuchAlgorithmException nsae) {
        }
        return sign;
    }

    public static String digest(String pBase) {
        String wdgs = null;
        try {
            MessageDigest wmd = MessageDigest.getInstance("MD5");
            wmd.reset();
            wmd.update(pBase.getBytes());
            byte[] wdg = wmd.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < wdg.length; i++) {
                String w_dup = Integer.toHexString(0xFF & wdg[i]);

                if (w_dup.length() < 2) {
                    w_dup = "0" + w_dup;
                }

                hexString.append(w_dup);
            }
            wdgs = hexString.toString();
            return wdgs;
        } catch (NoSuchAlgorithmException ex) {
            return wdgs;
        } 

    }

}
