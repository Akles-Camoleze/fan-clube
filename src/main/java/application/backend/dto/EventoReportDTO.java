package application.backend.dto;

import application.database.DbException;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventoReportDTO implements DataTransferObject {
    private Integer year;
    private Integer month;
    private Integer qtdEvento;
    private BigDecimal total;

    public EventoReportDTO() {

    }

    public EventoReportDTO(ResultSet resultSet) {
        toDTO(resultSet);
    }

    @Override
    public void toDTO(ResultSet resultSet) {
        try {
            year = resultSet.getInt("year");
            month = resultSet.getInt("month");
            qtdEvento = resultSet.getInt("qtdEvento");
            total = resultSet.getBigDecimal("total");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQtdEvento() {
        return qtdEvento;
    }

    public void setQtdEvento(Integer qtdEvento) {
        this.qtdEvento = qtdEvento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
