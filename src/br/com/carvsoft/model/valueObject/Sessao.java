package br.com.carvsoft.model.valueObject;

/**
 *
 * @author Carlos Rafael
 */
public class Sessao {

    private Usuario usuarioAutenticado;
    private Perfil perfil;
    private Funcao funcao;
    private String nm_maquina;
    private String nm_usuario_os;
    private String ds_versao_sistema;

    public Sessao() {
    }

    public Sessao(Usuario usuarioAutenticado, String nm_maquina, String nm_usuario_os, String ds_versao_sistema) {
        this.usuarioAutenticado = usuarioAutenticado;
        this.nm_maquina = nm_maquina;
        this.nm_usuario_os = nm_usuario_os;
        this.ds_versao_sistema = ds_versao_sistema;
    }
    
    public Sessao(Usuario usuarioAutenticado, Perfil perfil, Funcao funcao,
            String nm_maquina, String nm_usuario_os, String ds_versao_sistema) {
        this.usuarioAutenticado = usuarioAutenticado;
        this.perfil = perfil;
        this.funcao = funcao;
        this.nm_maquina = nm_maquina;
        this.nm_usuario_os = nm_usuario_os;
        this.ds_versao_sistema = ds_versao_sistema;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getNm_maquina() {
        return nm_maquina;
    }

    public void setNm_maquina(String nm_maquina) {
        this.nm_maquina = nm_maquina;
    }

    public String getNm_usuario_os() {
        return nm_usuario_os;
    }

    public void setNm_usuario_os(String nm_usuario_os) {
        this.nm_usuario_os = nm_usuario_os;
    }

    public String getDs_versao_sistema() {
        return ds_versao_sistema;
    }

    public void setDs_versao_sistema(String ds_versao_sistema) {
        this.ds_versao_sistema = ds_versao_sistema;
    }
    
}
