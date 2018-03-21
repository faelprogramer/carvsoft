package br.com.carvsoft.model.valueObject;

/**
 *
 * @author Carlos Rafael
 */
public class Mensagem {
    
    private String ds_titulo;
    private String ds_mensagem;
    private EnumTipoMensagem ie_tipo_mensagem;

    public Mensagem() {
    }

    public Mensagem(String ds_titulo, String ds_mensagem, EnumTipoMensagem ie_tipo_mensagem) {
        this.ds_titulo = ds_titulo;
        this.ds_mensagem = ds_mensagem;
        this.ie_tipo_mensagem = ie_tipo_mensagem;
    }

    public String getDs_titulo() {
        return ds_titulo;
    }

    public void setDs_titulo(String ds_titulo) {
        this.ds_titulo = ds_titulo;
    }

    public String getDs_mensagem() {
        return ds_mensagem;
    }

    public void setDs_mensagem(String ds_mensagem) {
        this.ds_mensagem = ds_mensagem;
    }

    public EnumTipoMensagem getIe_tipo_mensagem() {
        return ie_tipo_mensagem;
    }

    public void setIe_tipo_mensagem(EnumTipoMensagem ie_tipo_mensagem) {
        this.ie_tipo_mensagem = ie_tipo_mensagem;
    }
    
}
