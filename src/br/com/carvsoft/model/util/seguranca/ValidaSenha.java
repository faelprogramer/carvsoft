package br.com.carvsoft.model.util.seguranca;

import java.nio.CharBuffer;

public class ValidaSenha {

    public static String converteSenha(String senha) {
        if (senha == null) {
            return "";
        }
        senha = senha.toUpperCase();
        CharBuffer cb = CharBuffer.allocate(senha.length());
        for (int i = 0; i < senha.length(); i++) {
            char caracter;
            if (i % 2 == 0) {
                caracter = (char) (senha.charAt(i) - '\003');
            } else {
                caracter = (senha.charAt(i) + '\003' + "").charAt(1);
            }
            cb.append(caracter);
        }
        return new String(cb.array());
    }

    public static String converteSenhaHash(String senha) {
        return MyMD5.gerarHash(senha.toUpperCase()).toUpperCase();
    }

    public static String converteSenhaHashCaseSensetive(String senha) {
        return MyMD5.gerarHash(senha);
    }

    public static String converteSenhaHashSHA1(String senha) {
        return MySHA1.gerarHash(senha.toUpperCase()).toUpperCase();
    }

    public static String converteSenhaHashSHA1CaseSensetive(String senha) {
        return MySHA1.gerarHash(senha);
    }

    public static String converteSenhaHashSHA256(String senha, String dsTec) {
        senha = senha.toUpperCase();

        if (dsTec != null) {
            senha = senha + dsTec;
        }
        return MySHA256.gerarHash(senha).toUpperCase();
    }

    public static boolean verificaSenha(String senhaOrigem, String senhaCriptografada) {
        return verificaSenha(senhaOrigem, senhaCriptografada, null);
    }

    public static boolean verificaSenha(String senhaOrigem, String senhaCriptografada, String dsTec) {
        if ((senhaCriptografada == null) || (senhaOrigem == null)) {
            return false;
        }
        senhaOrigem = senhaOrigem.toUpperCase();

        if (dsTec != null) {
            senhaOrigem = senhaOrigem + dsTec;
        }

        switch (senhaCriptografada.length()) {
            case 32:
                return senhaCriptografada.equalsIgnoreCase(MyMD5.gerarHash(senhaOrigem));
            case 40:
                return senhaCriptografada.equalsIgnoreCase(MySHA1.gerarHash(senhaOrigem));
            case 64:
                return senhaCriptografada.equalsIgnoreCase(MySHA256.gerarHash(senhaOrigem));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ValidaSenha.verificaSenha("hprimavera2017",
                "10A4CC8105FFBC1DE6244FAA0D418F6B26AF431EA3F325CBFA9797BD58EB4E9E", "d6]24`DM!y9@N__"));
    }

}
