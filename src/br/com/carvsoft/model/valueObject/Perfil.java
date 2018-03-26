package br.com.carvsoft.model.valueObject;

import java.util.Date;
import java.util.List;

public class Perfil implements Comparable<Perfil> {

    private int cd_perfil;
    private String ds_perfil;
    private String ds_observacao;
    private Date dt_criacao;
    private Date dt_atualizacao;
    private Usuario usuario_criador;
    private Usuario usuario_atualizacao;
    private boolean vf_ativo;
    private List<Funcao> funcoes;

    public Perfil() {
    }

    public Perfil(int cd_perfil, String ds_perfil, boolean vf_ativo) {
        this.cd_perfil = cd_perfil;
        this.ds_perfil = ds_perfil;
        this.vf_ativo = vf_ativo;
    }
    
    public int getCd_perfil() {
        return cd_perfil;
    }

    public void setCd_perfil(int cd_perfil) {
        this.cd_perfil = cd_perfil;
    }

    public String getDs_perfil() {
        return ds_perfil;
    }

    public void setDs_perfil(String ds_perfil) {
        this.ds_perfil = ds_perfil;
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

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.cd_perfil;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Perfil) {
            final Perfil other = (Perfil) obj;
            return this.cd_perfil == other.cd_perfil;
        }
        return false;
    }

    @Override
    public String toString() {
        String ls = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("CD Perfil: ").append(cd_perfil).append(ls);
        sb.append("Perfil: ").append(ds_perfil).append(ls);
        sb.append("Ativo: ").append(vf_ativo);
        return sb.toString();
    }

    @Override
    public int compareTo(Perfil p) {
        if (this.cd_perfil > p.getCd_perfil()) {
             return -1;
         }
         if (this.cd_perfil < p.getCd_perfil()) {
             return 1;
         }
         return 0;
    }

}
