package br.com.carvsoft.model.util.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WhebMD5 {

    public static String gerarHash(String conteudo, String charset) {
        String wdgs = null;
        try {
            if (conteudo != null) {
                conteudo = conteudo.replace("\n", "");
            }
            MessageDigest wmd = MessageDigest.getInstance("MD5");
            wmd.reset();
            if (charset == null) {
                wmd.update(conteudo.getBytes());
            } else {
                wmd.update(conteudo.getBytes(charset));
            }
            byte[] wdg = wmd.digest();

            String hexString = "";
            for (int i = 0; i < wdg.length; i++) {
                String w_dup = Integer.toHexString(0xFF & wdg[i]);
                if (w_dup.length() < 2) {
                    w_dup = "0" + w_dup;
                }

                hexString = hexString + w_dup;
            }
            wdgs = hexString;
            return wdgs;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            return wdgs;
        }
    }

    public static String gerarHash(String conteudo) {
        return gerarHash(conteudo, null);
    }
}
