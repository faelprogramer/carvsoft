package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public class UsuarioDAO extends DAO<Usuario> {
    
    @Override
    protected void configurarSqlDAO() {
        sql_insert = "﻿INSERT INTO usuario(nm_usuario, ds_senha, cd_pessoa_fisica, "
                + "dt_atualizacao_nrec, dt_atualizacao, vf_ativo, ds_salt) "
                + "VALUES (?,?,?,?,?,?,?);";
        sql_update = "﻿UPDATE usuario SET nm_usuario=?, ds_senha=?, cd_pessoa_fisica=?, "
                + "dt_atualizacao_nrec=?, dt_atualizacao=?, vf_ativo=?, ds_salt=? "
                + "WHERE nm_usuario=?;";
        sql_delete = "DELETE usuario WHERE nm_usuario = ?";
        sql_select = "SELECT * from usuario WHERE nm_usuario = ?";
    }
    
    @Override
    protected void prepararStmtInsert(Connection connection, Usuario u) throws SQLException {
        u.setDt_atualizacao(getDataServer(connection));
        u.setDt_atualizacao_nrec(u.getDt_atualizacao());
        int i = 0;
        pstmt.setString(++i, u.getNm_usuario());
        pstmt.setString(++i, u.getDs_senha());
        pstmt.setInt(++i, u.getPessoaFisica().getCd_pessoa_fisica());
        pstmt.setDate(++i, DateToSqlDate(u.getDt_atualizacao()));
        pstmt.setDate(++i, DateToSqlDate(u.getDt_atualizacao_nrec()));
        pstmt.setBoolean(++i, u.getVf_ativo());
        pstmt.setString(++i, u.getDs_salt());
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, Usuario u) throws SQLException {

    }

    @Override
    protected void prepararStmtDelete(Usuario u) throws SQLException {

    }

    @Override
    protected void prepararStmtSelectElement(Usuario u) throws SQLException {
        pstmt.setString(1, u.getNm_usuario());
    }

    @Override
    protected Usuario InstantElementFromResultSet() throws SQLException {
        Usuario u = new Usuario();
        u.setNm_usuario(rs.getString("nm_usuario"));
        u.setDs_senha(rs.getString("ds_senha"));
        //u.setPessoaFisica(pessoaFisica);
        u.setDt_atualizacao(rs.getDate("dt_atualizacao"));
        u.setDt_atualizacao_nrec(rs.getDate("dt_atualizacao_nrec"));
        u.setVf_ativo(rs.getBoolean("vf_ativo"));
        u.setDs_salt(rs.getString("ds_salt"));
        return u;
    }

}
