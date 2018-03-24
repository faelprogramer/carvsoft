package br.com.carvsoft.model.util.seguranca;

public class Hexadecimal {

    private static final char[] hex = "0123456789abcdef".toCharArray();

    public static byte[] hexToBytes(String s) {
        byte[] ret = new byte[s.length() / 2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ((byte) Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
        }
        return ret;
    }

    public static String bytesToHex(byte[] b) {
        char[] ret = new char[b.length * 2];
        int i = 0;
        for (int j = 0; i < b.length; i++) {
            ret[(j++)] = hex[((b[i] & 0xF0) >> 4)];
            ret[(j++)] = hex[(b[i] & 0xF)];
        }
        return new String(ret);
    }
}