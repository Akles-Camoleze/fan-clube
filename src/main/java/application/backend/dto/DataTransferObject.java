package application.backend.dto;

import java.sql.ResultSet;

public interface DataTransferObject {
    void toDTO(ResultSet resultSet);
}
