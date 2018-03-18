package br.com.carvsoft.model.valueObject;

import java.util.Date;

/**
 * @author Carlos Rafael
 */
public class PessoaFisica {
    
    private int cd_pessoa_fisica;
    private String nm_pessoa_fisica;
    private Date dt_nascimento;
    private String ds_telefone,ds_celular;
    private Date dt_atualizacao, dt_atualizacao_nrec;
    private int nr_compra_fidelidade;
    private String ds_endereco,nr_endereco,ds_complemento,ds_bairro,ds_observacao,ds_rg,ds_cpf;

    public PessoaFisica() {
    }
    
    public PessoaFisica(int cd_pessoa_fisica) {
        this.cd_pessoa_fisica = cd_pessoa_fisica;
    }
    
    public int getCd_pessoa_fisica() {
        return cd_pessoa_fisica;
    }

    public void setCd_pessoa_fisica(int cd_pessoa_fisica) {
        this.cd_pessoa_fisica = cd_pessoa_fisica;
    }

    public String getNm_pessoa_fisica() {
        return nm_pessoa_fisica;
    }

    public void setNm_pessoa_fisica(String nm_pessoa_fisica) {
        this.nm_pessoa_fisica = nm_pessoa_fisica;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDs_telefone() {
        return ds_telefone;
    }

    public void setDs_telefone(String ds_telefone) {
        this.ds_telefone = ds_telefone;
    }

    public String getDs_celular() {
        return ds_celular;
    }

    public void setDs_celular(String ds_celular) {
        this.ds_celular = ds_celular;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    public Date getDt_atualizacao_nrec() {
        return dt_atualizacao_nrec;
    }

    public void setDt_atualizacao_nrec(Date dt_atualizacao_nrec) {
        this.dt_atualizacao_nrec = dt_atualizacao_nrec;
    }

    public int getNr_compra_fidelidade() {
        return nr_compra_fidelidade;
    }

    public void setNr_compra_fidelidade(int nr_compra_fidelidade) {
        this.nr_compra_fidelidade = nr_compra_fidelidade;
    }

    public String getDs_endereco() {
        return ds_endereco;
    }

    public void setDs_endereco(String ds_endereco) {
        this.ds_endereco = ds_endereco;
    }

    public String getNr_endereco() {
        return nr_endereco;
    }

    public void setNr_endereco(String nr_endereco) {
        this.nr_endereco = nr_endereco;
    }

    public String getDs_complemento() {
        return ds_complemento;
    }

    public void setDs_complemento(String ds_complemento) {
        this.ds_complemento = ds_complemento;
    }

    public String getDs_bairro() {
        return ds_bairro;
    }

    public void setDs_bairro(String ds_bairro) {
        this.ds_bairro = ds_bairro;
    }

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }

    public String getDs_rg() {
        return ds_rg;
    }

    public void setDs_rg(String ds_rg) {
        this.ds_rg = ds_rg;
    }

    public String getDs_cpf() {
        return ds_cpf;
    }

    public void setDs_cpf(String ds_cpf) {
        this.ds_cpf = ds_cpf;
    }
    
}