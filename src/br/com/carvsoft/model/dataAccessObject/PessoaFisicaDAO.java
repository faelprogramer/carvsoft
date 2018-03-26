package br.com.carvsoft.model.dataAccessObject;

import br.com.carvsoft.model.valueObject.PessoaFisica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Carlos Rafael
 */
public class PessoaFisicaDAO extends DAO<PessoaFisica> {

    @Override
    protected void configurarSqlDAO() {
        sql_next_sequence = "select nextval('pessoa_fisica_seq')";
        sql_select = "select * from pessoa_fisica where cd_pessoa_fisica=?";
        sql_insert = "INSERT INTO pessoa_fisica(cd_pessoa_fisica,nm_pessoa_fisica,dt_nascimento,ds_telefone,"
                + "ds_celular,dt_atualizacao_nrec,dt_atualizacao,nr_compra_fidelidade,ds_endereco,nr_endereco,"
                + "ds_complemento,ds_bairro,ds_observacao,ds_rg,ds_cpf) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        sql_update = "UPDATE pessoa_fisica SET nm_pessoa_fisica=?,dt_nascimento=?,ds_telefone=?,ds_celular=?,"
                + "dt_atualizacao=?,nr_compra_fidelidade=?,ds_endereco=?,nr_endereco=?,ds_complemento=?,"
                + "ds_bairro=?,ds_observacao=?,ds_rg=?,ds_cpf=? WHERE cd_pessoa_fisica=?;";
        sql_delete = "DELETE FROM pessoa_fisica WHERE cd_pessoa_fisica=?;";
    }
    
    @Override
    protected void prepararStmtInsert(Connection connection, PessoaFisica p) throws SQLException {
        int i = 0;
        Date dt_atual = DateToSqlDate(getDataServer(connection));
        pstmt.setInt(++i, p.getCd_pessoa_fisica());
        pstmt.setString(++i, p.getNm_pessoa_fisica());
        pstmt.setDate(++i, DateToSqlDate(p.getDt_nascimento()));
        pstmt.setString(++i, p.getDs_telefone());
        pstmt.setString(++i, p.getDs_celular());
        pstmt.setDate(++i, dt_atual);
        pstmt.setDate(++i, dt_atual);
        pstmt.setInt(++i, p.getNr_compra_fidelidade());
        pstmt.setString(++i, p.getDs_endereco());
        pstmt.setString(++i, p.getNr_endereco());
        pstmt.setString(++i, p.getDs_complemento());
        pstmt.setString(++i, p.getDs_bairro());
        pstmt.setString(++i, p.getDs_observacao());
        pstmt.setString(++i, p.getDs_rg());
        pstmt.setString(++i, p.getDs_cpf());
    }

    @Override
    protected void prepararStmtUpdate(Connection connection, PessoaFisica p) throws SQLException {
        int i = 0;
        pstmt.setString(++i, p.getNm_pessoa_fisica());
        pstmt.setDate(++i, DateToSqlDate(p.getDt_nascimento()));
        pstmt.setString(++i, p.getDs_telefone());
        pstmt.setString(++i, p.getDs_celular());
        pstmt.setDate(++i, DateToSqlDate(getDataServer(connection)));
        pstmt.setInt(++i, p.getNr_compra_fidelidade());
        pstmt.setString(++i, p.getDs_endereco());
        pstmt.setString(++i, p.getNr_endereco());
        pstmt.setString(++i, p.getDs_complemento());
        pstmt.setString(++i, p.getDs_bairro());
        pstmt.setString(++i, p.getDs_observacao());
        pstmt.setString(++i, p.getDs_rg());
        pstmt.setString(++i, p.getDs_cpf());
        pstmt.setInt(++i, p.getCd_pessoa_fisica());
    }

    @Override
    protected void prepararStmtDelete(PessoaFisica p) throws SQLException {
        pstmt.setInt(1, p.getCd_pessoa_fisica());
    }

    @Override
    protected void prepararStmtSelectElement(PessoaFisica p) throws SQLException {
        pstmt.setInt(1, p.getCd_pessoa_fisica());
    }

    @Override
    protected PessoaFisica InstantElementFromResultSet(Connection connection) throws SQLException {
        PessoaFisica p = new PessoaFisica();
        p.setCd_pessoa_fisica(rs.getInt("cd_pessoa_fisica"));
        p.setDs_bairro(rs.getString("ds_bairro"));
        p.setDs_celular(rs.getString("ds_celular"));
        p.setDs_complemento(rs.getString("ds_complemento"));
        p.setDs_cpf(rs.getString("ds_cpf"));
        p.setDs_endereco(rs.getString("ds_endereco"));
        p.setDs_observacao(rs.getString("ds_observacao"));
        p.setDs_rg(rs.getString("ds_rg"));
        p.setDs_telefone(rs.getString("ds_telefone"));
        p.setDt_atualizacao(rs.getDate("dt_atualizacao"));
        p.setDt_atualizacao_nrec(rs.getDate("dt_atualizacao_nrec"));
        p.setDt_nascimento(rs.getDate("dt_nascimento"));
        p.setNm_pessoa_fisica(rs.getString("nm_pessoa_fisica"));
        p.setNr_compra_fidelidade(rs.getInt("nr_compra_fidelidade"));
        p.setNr_endereco(rs.getString("nr_endereco"));
        return p;
    }
    
}
