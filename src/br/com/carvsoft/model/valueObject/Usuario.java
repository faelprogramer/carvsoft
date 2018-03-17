package br.com.carvsoft.model.valueObject;

import java.util.Date;

public class Usuario {
    
    private String nm_usuario;
    private String ds_senha;
    private PessoaFisica pessoaFisica;
    private Date dt_atualizacao_nrec;
    private Date dt_atualizacao;
    private Boolean vf_ativo;

    public Usuario() {
    }
    
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

    public Date getDt_atualizacao_nrec() {
        return dt_atualizacao_nrec;
    }

    public void setDt_atualizacao_nrec(Date dt_atualizacao_nrec) {
        this.dt_atualizacao_nrec = dt_atualizacao_nrec;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    public Boolean getVf_ativo() {
        return vf_ativo;
    }

    public void setVf_ativo(Boolean vf_ativo) {
        this.vf_ativo = vf_ativo;
    }
    
    
    
}
