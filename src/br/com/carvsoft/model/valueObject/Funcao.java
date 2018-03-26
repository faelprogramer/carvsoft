package br.com.carvsoft.model.valueObject;

import java.util.Date;

/**
 * @author Carlos Rafael
 */
public class Funcao implements Comparable<Funcao> {

    private int cd_funcao;
    private String ds_funcao;
    private String ds_observacao;
    private Date dt_criacao;
    private Date dt_atualizacao;
    private Usuario usuario_criador;
    private Usuario usuario_atualizacao;
    private boolean vf_ativo;

    public Funcao() {
    }

    public Funcao(int cd_funcao, String ds_funcao, boolean vf_ativo) {
        this.cd_funcao = cd_funcao;
        this.ds_funcao = ds_funcao;
        this.vf_ativo = vf_ativo;
    }
    
    public int getCd_funcao() {
        return cd_funcao;
    }

    public void setCd_funcao(int cd_funcao) {
        this.cd_funcao = cd_funcao;
    }

    public String getDs_funcao() {
        return ds_funcao;
    }

    public void setDs_funcao(String ds_funcao) {
        this.ds_funcao = ds_funcao;
    }

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    public Usuario getUsuario_criador() {
        return usuario_criador;
    }

    public void setUsuario_criador(Usuario usuario_criador) {
        this.usuario_criador = usuario_criador;
    }

    public Usuario getUsuario_atualizacao() {
        return usuario_atualizacao;
    }

    public void setUsuario_atualizacao(Usuario usuario_atualizacao) {
        this.usuario_atualizacao = usuario_atualizacao;
    }

    public boolean isVf_ativo() {
        return vf_ativo;
    }

    public void setVf_ativo(boolean vf_ativo) {
        this.vf_ativo = vf_ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.cd_funcao;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Funcao) {
            Funcao other = (Funcao) obj;
            return this.cd_funcao == other.cd_funcao;
        }
        return false;
    }

    @Override
    public String toString() {
        String ls = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("CD Função: ").append(cd_funcao).append(ls);
        sb.append("Função: ").append(ds_funcao).append(ls);
        sb.append("Ativo: ").append(vf_ativo);
        return sb.toString();
    }
    
    @Override
    public int compareTo(Funcao f) {
        if (this.cd_funcao > f.getCd_funcao()) {
            return -1;
        }
        if (this.cd_funcao < f.getCd_funcao()) {
            return 1;
        }
        return 0;
    }
    
}
