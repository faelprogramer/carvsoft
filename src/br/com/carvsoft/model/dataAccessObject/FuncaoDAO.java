package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.Funcao;
import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public class FuncaoDAO extends DAO<Funcao> {

    @Override
    protected void configurarSqlDAO() {
        sql_next_sequence = "SELECT nextval('funcao_seq')";
        sql_select = "SELECT * FROM funcao WHERE cd_funcao=?;";
        sql_insert = "INSERT INTO funcao(cd_funcao,ds_funcao,ds_observacao,dt_criacao,"
                + "dt_atualizacao,nm_usuario_criador,nm_usuario_atualizacao,"
                + "vf_ativo) VALUES (?,?,?,?,?,?,?,?);";
        sql_update = "UPDATE funcao SET ds_funcao=?,ds_observacao=?,"
                + "dt_atualizacao=?,nm_usuario_criador=?,nm_usuario_atualizacao=?,"
                + "vf_ativo=? WHERE cd_funcao=?;";
        sql_delete = "DELETE FROM funcao WHERE cd_funcao=?;";
    }

    @Override
    protected void prepararStmtInsert(Connection connection, Funcao f) throws SQLException {
        Date dt_atual = DateToSqlDate(getDataServer(connection));
        int i = 0;
        pstmt.setInt(++i, f.getCd_funcao());
        pstmt.setString(++i, f.getDs_funcao());
        pstmt.setString(++i, f.getDs_observacao());
        pstmt.setDate(++i, dt_atual);
        pstmt.setDate(++i, dt_atual);
        pstmt.setString(++i, f.getUsuario_criador().getNm_usuario());
        pstmt.setString(++i, f.getUsuario_atualizacao().getNm_usuario());
        pstmt.setBoolean(++i, f.isVf_ativo());
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, Funcao f) throws SQLException {
        int i = 0;
        pstmt.setString(++i, f.getDs_funcao());
        pstmt.setString(++i, f.getDs_observacao());
        pstmt.setDate(++i, DateToSqlDate(getDataServer(connection)));
        pstmt.setString(++i, f.getUsuario_criador().getNm_usuario());
        pstmt.setString(++i, f.getUsuario_atualizacao().getNm_usuario());
        pstmt.setBoolean(++i, f.isVf_ativo());
        pstmt.setInt(++i, f.getCd_funcao());
    }

    @Override
    protected void prepararStmtDelete(Funcao f) throws SQLException {
        pstmt.setInt(1, f.getCd_funcao());
    }

    @Override
    protected void prepararStmtSelectElement(Funcao f) throws SQLException {
        pstmt.setInt(1, f.getCd_funcao());
    }

    @Override
    protected Funcao InstantElementFromResultSet(Connection connection) throws SQLException {
        Funcao f = new Funcao();
        UsuarioDAO dao = new UsuarioDAO();
        f.setCd_funcao(rs.getInt("cd_funcao"));
        f.setDs_funcao(rs.getString("ds_funcao"));
        f.setDs_observacao(rs.getString("ds_observacao"));
        f.setDt_atualizacao(rs.getDate("dt_atualizacao"));
        f.setDt_criacao(rs.getDate("dt_criacao"));
        Usuario usuarioBusca = new Usuario(rs.getString("nm_usuario_atualizacao"));
        f.setUsuario_atualizacao(dao.getElement(connection, usuarioBusca));
        usuarioBusca.setNm_usuario("nm_usuario_criador");
        f.setUsuario_criador(dao.getElement(connection, usuarioBusca));
        f.setVf_ativo(rs.getBoolean("vf_ativo"));
        return f;
    }
    
}
