package br.com.carvsoft.model.valueObject;

public class Usuario {
    
    private String nm_usuario;
    private String ds_senha;
    private PessoaFisica pessoaFisica;

    public Usuario(String nm_usuario, String ds_senha) {
        this.nm_usuario = nm_usuario;
        this.ds_senha = ds_senha;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
    
}
