package br.com.carvsoft.model.valueObject;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Carlos Rafael
 */
public class Empresa {

    private int cd_empresa;
    private String nm_razao_social;
    private String nm_curto;
    private int cd_base_cgc;
    private Date dt_atualizaacao;
    private Usuario usuario_atualizador;
    private Date dt_criacao;
    private Usuario usuario_criador;
    private boolean ativo;
    private List<Estabelecimento> estabelecimentos;

    public int getCd_empresa() {
        return cd_empresa;
    }

    public void setCd_empresa(int cd_empresa) {
        this.cd_empresa = cd_empresa;
    }

    public String getNm_razao_social() {
        return nm_razao_social;
    }

    public void setNm_razao_social(String nm_razao_social) {
        this.nm_razao_social = nm_razao_social;
    }

    public String getNm_curto() {
        return nm_curto;
    }

    public void setNm_curto(String nm_fantasia) {
        this.nm_curto = nm_fantasia;
    }

    public int getCd_base_cgc() {
        return cd_base_cgc;
    }

    public void setCd_base_cgc(int cd_base_cgc) {
        this.cd_base_cgc = cd_base_cgc;
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
    
    public List<Estabelecimento> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }
    
}
