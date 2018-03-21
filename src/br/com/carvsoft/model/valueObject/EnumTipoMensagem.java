package br.com.carvsoft.model.valueObject;

/**
 *
 * @author Carlos Rafael
 */
public enum EnumTipoMensagem {

    INFORMACAO(1), ALERTA(2), ERRO(3);

    private int ie_tipo_mensagem;

    private EnumTipoMensagem(int ie_tipo_mensagem) {
        this.ie_tipo_mensagem = ie_tipo_mensagem;
    }

    public int getIe_tipo_mensagem() {
        return ie_tipo_mensagem;
    }

}
