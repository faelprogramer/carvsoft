package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() {
        sql_insert = "insert into usuario (nm_usuario,ds_senha,cd_pessoa_fisica,"
                + "dt_atualizacao,dt_atualizacao_nrec,vf_ativo) values (?,?,?,?,?,?)";
        sql_update = "update usuario set ds_senha=?,cd_pessoa_fisica=?,dt_atualizacao=?,vf_ativo=? where nm_usuario=?";
        sql_delete = "delete usuario where nm_usuario = ?";
        sql_select = "select * from usuario where nm_usuario = ?";
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

        //u.setPessoaFisica();
        return u;
    }

}
