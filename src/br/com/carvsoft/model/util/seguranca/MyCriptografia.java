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

public class MyCriptografia {

    private static Cipher cipher;

    private static void inicializa(String algoritmo) throws NoSuchAlgorithmException, NoSuchPaddingException {
        cipher = Cipher.getInstance(algoritmo);
    }

    public static String gerarChave(Integer tamanho, String algoritmo) {
        try {
            inicializa(algoritmo);
            KeyGenerator kgen = KeyGenerator.getInstance(algoritmo);
            kgen.init(128);
            SecretKey skey = kgen.generateKey();
            Key key = new SecretKeySpec(skey.getEncoded(), algoritmo);
            return Hexadecimal.bytesToHex(skey.getEncoded());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            return e.getMessage();
        }
    }

    public static String criptografa(String chaveHex, String texto, String algoritmo) {
        try {
            inicializa(algoritmo);
            SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), algoritmo);
            cipher.init(1, skeySpec);
            byte[] b = cipher.doFinal(texto.getBytes());
            return Hexadecimal.bytesToHex(b);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            
        }
        return null;
    }

    public static String descriptografa(String chaveHex, String textoHex, String algoritmo) {
        try {
            inicializa(algoritmo);
            SecretKeySpec skeySpec = new SecretKeySpec(Hexadecimal.hexToBytes(chaveHex), algoritmo);
            cipher.init(2, skeySpec);
            return new String(cipher.doFinal(Hexadecimal.hexToBytes(textoHex)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {

        }
        return null;
    }
}
