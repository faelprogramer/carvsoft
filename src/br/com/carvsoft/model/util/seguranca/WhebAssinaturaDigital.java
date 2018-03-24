/*    */ package br.com.carvsoft.model.util.seguranca;

/*    */
import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.security.MessageDigest;

/*    */
 /*    */
 /*    */ public class WhebAssinaturaDigital /*    */ {

    /*    */ public static String geraHash(String texto) /*    */ {
        /* 12 */ String sign = texto;
        /*    */
 /*    */ try /*    */ {
            /* 16 */ MessageDigest md = MessageDigest.getInstance("MD5");
            /* 17 */ md.update(sign.getBytes());
            /* 18 */ byte[] hash = md.digest();
            /* 19 */ sign = Hexadecimal.bytesToHex(hash);
            /* 20 */ StringBuffer hexString = new StringBuffer();
            /* 21 */ for (int i = 0; i < hash.length; i++) {
                /* 22 */ if ((0xFF & hash[i]) < 16) {
                    /* 23 */ hexString.append("0"
                            + /* 24 */ Integer.toHexString(0xFF & hash[i]));
                    /*    */                } else /* 26 */ {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
                /*    */            }
            /* 28 */ sign = hexString.toString();
            /*    */        } /*    */ catch (Exception nsae) {
            /* 31 */ nsae.printStackTrace();
            /*    */        }
        /* 33 */ return sign;
        /*    */    }

    /*    */
 /*    */ public static String digest(String pBase) /*    */ {
        /* 38 */ String wdgs = null;
        /*    */ try {
            /* 40 */ MessageDigest wmd = MessageDigest.getInstance("MD5");
            /* 41 */ wmd.reset();
            /* 42 */ wmd.update(pBase.getBytes());
            /* 43 */ byte[] wdg = wmd.digest();
            /* 44 */ StringBuffer hexString = new StringBuffer();
            /* 45 */ for (int i = 0; i < wdg.length; i++) {
                /* 46 */ String w_dup = Integer.toHexString(0xFF & wdg[i]);
                /*    */
 /*    */
 /*    */
 /*    */
 /* 51 */ if (w_dup.length() < 2) {
                    /* 52 */ w_dup = "0" + w_dup;
                    /*    */                }
                /*    */
 /*    */
 /* 56 */ hexString.append(w_dup);
                /*    */            }
            /* 58 */ wdgs = hexString.toString();
            /*    */
 /*    */
 /*    */
 /*    */
 /* 63 */ return wdgs;
            /*    */        } /*    */ catch (Exception ex) /*    */ {
            /* 59 */ ex
                    = /*    */ /*    */ /*    */ /* 63 */ ex;
            ex.printStackTrace();
            return wdgs;
        } finally {
        }

        //return wdgs;
        /*    */    }

    /*    */
}
