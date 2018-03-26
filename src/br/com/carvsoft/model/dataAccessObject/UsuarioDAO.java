package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.Perfil;
import br.com.carvsoft.model.valueObject.PessoaFisica;
import br.com.carvsoft.model.valueObject.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carlos Rafael
 */
public class UsuarioDAO extends DAO<Usuario> {

    private final PessoaFisicaDAO PF_DAO = new PessoaFisicaDAO();
    private final PerfilDAO PERFIL_DAO = new PerfilDAO();
    
    @Override
    protected void configurarSqlDAO() {
        sql_insert = "INSERT INTO usuario(nm_usuario,ds_senha,cd_pessoa_fisica,"
                + "dt_atualizacao_nrec,dt_atualizacao,vf_ativo,ds_salt) VALUES (?,?,?,?,?,?,?)";
        sql_update = "UPDATE usuario SET ds_senha=?,cd_pessoa_fisica=?,dt_atualizacao=?,"
                + "vf_ativo=?,ds_salt=? WHERE nm_usuario=?";
        sql_delete = "DELETE usuario WHERE nm_usuario=?";
        sql_select = "SELECT * from usuario WHERE nm_usuario=?";
    }

    @Override
    protected void prepararStmtInsert(Connection connection, Usuario u) throws SQLException {
        Date dt_atual = DateToSqlDate(getDataServer(connection));
        int i = 0;
        pstmt.setString(++i, u.getNm_usuario());
        pstmt.setString(++i, u.getDs_senha());
        pstmt.setInt(++i, u.getPessoaFisica().getCd_pessoa_fisica());
        pstmt.setDate(++i, dt_atual);
        pstmt.setDate(++i, dt_atual);
        pstmt.setBoolean(++i, u.getVf_ativo());
        pstmt.setString(++i, u.getDs_salt());
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, Usuario u) throws SQLException {
        int i = 0;
        pstmt.setString(++i, u.getDs_senha());
        pstmt.setInt(++i, u.getPessoaFisica().getCd_pessoa_fisica());
        pstmt.setDate(++i, DateToSqlDate(getDataServer(connection)));
        pstmt.setBoolean(++i, u.getVf_ativo());
        pstmt.setString(++i, u.getDs_salt());
        pstmt.setString(++i, u.getNm_usuario());
    }

    @Override
    protected void prepararStmtDelete(Usuario u) throws SQLException {
        pstmt.setString(1, u.getNm_usuario());

    }

    @Override
    protected void prepararStmtSelectElement(Usuario u) throws SQLException {
        pstmt.setString(1, u.getNm_usuario());
    }

    @Override
    protected Usuario InstantElementFromResultSet(Connection connection) throws SQLException {
        Usuario u = new Usuario();
        
        u.setNm_usuario(rs.getString("nm_usuario"));
        u.setDs_senha(rs.getString("ds_senha"));
        PessoaFisica p = PF_DAO.getElement(connection, new PessoaFisica(rs.getInt("cd_pessoa_fisica")));
        u.setPessoaFisica(p);
        u.setDt_atualizacao(rs.getDate("dt_atualizacao"));
        u.setDt_atualizacao_nrec(rs.getDate("dt_atualizacao_nrec"));
        u.setVf_ativo(rs.getBoolean("vf_ativo"));
        u.setDs_salt(rs.getString("ds_salt"));
        List<Perfil> perfis = PERFIL_DAO.getElements(connection,
                "select b.* from usuario_perfil a join perfil b on a.cd_perfil = b.cd_perfil where a.nm_usuario = "
                        + u.getNm_usuario());
        u.setPerfis(perfis);
        return u;
    }

}
