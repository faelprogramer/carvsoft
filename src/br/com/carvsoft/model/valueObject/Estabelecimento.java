package br.com.carvsoft.model.valueObject;

import java.util.Date;

/**
 *
 * @author Carlos Rafael
 */
public class Estabelecimento {
    
    private int cd_estabelecimento;
    private String cd_cgc;
    private String nm_fantasia;
    private String cd_inscricao_estadual;
    private String cd_inscricao_municipal;
    private Date dt_atualizaacao;
    private Usuario usuario_atualizador;
    private Date dt_criacao;
    private Usuario usuario_criador;
    private boolean ativo;

    public int getCd_estabelecimento() {
        return cd_estabelecimento;
    }

    public void setCd_estabelecimento(int cd_estabelecimento) {
        this.cd_estabelecimento = cd_estabelecimento;
    }

    public String getCd_cgc() {
        return cd_cgc;
    }

    public void setCd_cgc(String cd_cgc) {
        this.cd_cgc = cd_cgc;
    }

    public String getNm_fantasia() {
        return nm_fantasia;
    }

    public void setNm_fantasia(String nm_fantasia) {
        this.nm_fantasia = nm_fantasia;
    }

    public String getCd_inscricao_estadual() {
        return cd_inscricao_estadual;
    }

    public void setCd_inscricao_estadual(String cd_inscricao_estadual) {
        this.cd_inscricao_estadual = cd_inscricao_estadual;
    }

    public String getCd_inscricao_municipal() {
        return cd_inscricao_municipal;
    }

    public void setCd_inscricao_municipal(String cd_inscricao_municipal) {
        this.cd_inscricao_municipal = cd_inscricao_municipal;
    }

    public Date getDt_atualizaacao() {
        return dt_atualizaacao;
    }

    public void setDt_atualizaacao(Date dt_atualizaacao) {
        this.dt_atualizaacao = dt_atualizaacao;
    }

    public Usuario getUsuario_atualizador() {
        return usuario_atualizador;
    }

    public void setUsuario_atualizador(Usuario usuario_atualizador) {
        this.usuario_atualizador = usuario_atualizador;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Usuario getUsuario_criador() {
        return usuario_criador;
    }

    public void setUsuario_criador(Usuario usuario_criador) {
        this.usuario_criador = usuario_criador;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
