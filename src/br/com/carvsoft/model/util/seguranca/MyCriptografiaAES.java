package br.com.carvsoft.model.util.seguranca;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MyCriptografiaAES {

    private static Cipher cipher;

    private static void inicializa() throws NoSuchAlgorithmException, NoSuchPaddingException {
        cipher = Cipher.getInstance("AES");
    }

    public static String gerarChave(int tamanho) {
        try {
            inicializa();
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(tamanho);
            SecretKey skey = kgen.generateKey();
            Key key = new SecretKeySpec(skey.getEncoded(), "AES");
            return Hexadecimal.bytesToHex(skey.getEncoded());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
        }
        return null;
    }

    public static String criptografa(String chaveHex, String texto) {
        try {
            inicializa();
            SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), "AES");
            cipher.init(1, skeySpec);
            byte[] b = cipher.doFinal(texto.getBytes());
            return Hexadecimal.bytesToHex(b);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return null;
    }

    public static String descriptografa(String chaveHex, String textoHex) {
        try {
            inicializa();
            SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), "AES");
            cipher.init(2, skeySpec);
            return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        return null;
    }

    public static void main(String[] args)
            throws Exception {
        MyCriptografiaAES a = new MyCriptografiaAES();
        System.out.println(gerarChave(128));
        System.out.println(criptografa("2ab6ddbacd6cbd04d73747ba27881c4d", "Luis Fernando Coelho"));
        System.out.println(descriptografa("2ab6ddbacd6cbd04d73747ba27881c4d", "4205120ec13138dc7ef0e016a701012e7f46a393ebaf7a7fcda58ba0ebde8341"));
    }
}
