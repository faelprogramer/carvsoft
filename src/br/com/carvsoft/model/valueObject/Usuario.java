package br.com.carvsoft.model.valueObject;

import br.com.carvsoft.model.util.seguranca.Password;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Usuario implements Comparable<Usuario> {

    private String nm_usuario;
    private String ds_senha;
    private PessoaFisica pessoaFisica;
    private Date dt_atualizacao_nrec;
    private Date dt_atualizacao;
    private boolean vf_ativo;
    private String ds_salt;
    private List<Perfil> perfis;
    private final int QT_SALT = 15;

    public Usuario() {
        ds_salt = Password.gerarStringRandomica(QT_SALT);
    }

    public Usuario(String nm_usuario) {
        super();
        this.nm_usuario = nm_usuario;
    }
    
    public Usuario(String nm_usuario, String ds_senha) {
        super();
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

    public String getDs_salt() {
        return ds_salt;
    }

    public void setDs_salt(String ds_salt) {
        this.ds_salt = ds_salt;
    }

    public boolean isVf_ativo() {
        return vf_ativo;
    }

    public void setVf_ativo(boolean vf_ativo) {
        this.vf_ativo = vf_ativo;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public boolean validarSenha(String senhaDigitada) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String senhaCriptografada;
        senhaCriptografada = Password.criptografarSenha(senhaDigitada,
                this.getDs_salt());
        return senhaCriptografada.equals(this.getDs_senha());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nm_usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) { //válido quando mesmo nome e mesma senha
        if (this == obj) {
            return true;
        }
        if (obj != null && obj instanceof Usuario) {
            final Usuario u = (Usuario) obj;
            return (this.nm_usuario.equals(u.nm_usuario));
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String ls = System.lineSeparator();
        sb.append("Usuário: ").append(nm_usuario).append(ls);
        sb.append("Pessoa: ").append(pessoaFisica.getNm_pessoa_fisica()).append(ls);
        sb.append("Ativo: ").append(vf_ativo);
        return sb.toString();
    }

    @Override
    public int compareTo(Usuario u) {
        return this.getNm_usuario().compareTo(u.getNm_usuario());
    }

}
