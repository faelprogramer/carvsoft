package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.Perfil;
import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carlos Rafael
 */
public class PerfilDAO extends DAO<Perfil> {

    @Override
    protected void configurarSqlDAO() {
        sql_next_sequence = "SELECT nextval('perfil_seq')";
        sql_select = "SELECT * FROM perfil WHERE cd_perfil=?;";
        sql_insert = "INSERT INTO perfil(cd_perfil,ds_perfil,ds_observacao,"
                + "dt_criacao,dt_atualizacao,nm_usuario_criador,"
                + "nm_usuario_atualizacao,vf_ativo) VALUES (?,?,?,?,?,?,?,?);";
        sql_update = "UPDATE perfil SET ds_perfil=?,ds_observacao=?,"
                + "dt_atualizacao=?,nm_usuario_criador=?,nm_usuario_atualizacao=?,"
                + "vf_ativo=? WHERE cd_perfil=?;";
        sql_delete = "DELETE FROM perfil WHERE cd_perfil=?;";
    }

    @Override
    protected void prepararStmtInsert(Connection connection, Perfil p) throws SQLException {
        Date dt_atual = DateToSqlDate(getDataServer(connection));
        int i = 0;
        pstmt.setInt(++i, p.getCd_perfil());
        pstmt.setString(++i, p.getDs_perfil());
        pstmt.setString(++i, p.getDs_observacao());
        pstmt.setDate(++i, dt_atual);
        pstmt.setDate(++i, dt_atual);
        pstmt.setString(++i, p.getUsuario_criador().getNm_usuario());
        pstmt.setString(++i, p.getUsuario_atualizacao().getNm_usuario());
        pstmt.setBoolean(++i, p.isVf_ativo());
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, Perfil p) throws SQLException {
        int i = 0;
        pstmt.setString(++i, p.getDs_perfil());
        pstmt.setString(++i, p.getDs_observacao());
        pstmt.setDate(++i, DateToSqlDate(getDataServer(connection)));
        pstmt.setString(++i, p.getUsuario_criador().getNm_usuario());
        pstmt.setString(++i, p.getUsuario_atualizacao().getNm_usuario());
        pstmt.setBoolean(++i, p.isVf_ativo());
        pstmt.setInt(++i, p.getCd_perfil());
    }

    @Override
    protected void prepararStmtDelete(Perfil p) throws SQLException {
        pstmt.setInt(1, p.getCd_perfil());
    }

    @Override
    protected void prepararStmtSelectElement(Perfil p) throws SQLException {
        pstmt.setInt(1, p.getCd_perfil());
    }

    @Override
    protected Perfil InstantElementFromResultSet(Connection connection) throws SQLException {
        Perfil p = new Perfil();
        
        UsuarioDAO u_dao = new UsuarioDAO();
        
        p.setCd_perfil(rs.getInt("cd_perfil"));
        p.setDs_observacao(rs.getString("ds_observacao"));
        p.setDs_perfil(rs.getString("ds_perfil"));
        p.setDt_atualizacao(rs.getDate("dt_atualizacao"));
        p.setDt_criacao(rs.getDate("dt_criacao"));
        Usuario u = new Usuario(rs.getString("nm_usuario_atualizacao"));
        p.setUsuario_atualizacao(u_dao.getElement(connection, u));
        u.setNm_usuario("nm_usuario_criador");
        p.setUsuario_criador(u_dao.getElement(connection, u));
        p.setVf_ativo(rs.getBoolean("vf_ativo"));
        List funcoes = new FuncaoDAO().getElements(connection,
                "﻿select b.* from perfil_funcao a join funcao b on a.cd_funcao = b.cd_funcao where a.cd_perfil = "
                + p.getCd_perfil());
        p.setFuncoes(funcoes);
        return p;
    }

}
