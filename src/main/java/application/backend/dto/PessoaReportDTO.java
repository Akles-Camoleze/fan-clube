package application.backend.dto;

import application.database.DbException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaReportDTO implements DataTransferObject {
    private PessoaResponseDTO pessoa;
    private Integer qtdInscricao;

    public PessoaReportDTO() {

    }

    public PessoaReportDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            pessoa = new PessoaResponseDTO(resultSet);
            qtdInscricao = resultSet.getInt("qtdInscricao");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public PessoaResponseDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaResponseDTO pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getQtdInscricao() {
        return qtdInscricao;
    }

    public void setQtdInscricao(Integer qtdInscricao) {
        this.qtdInscricao = qtdInscricao;
    }
}
