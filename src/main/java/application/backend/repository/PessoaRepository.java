package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Pessoa;
import java.lang.reflect.Constructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements BaseRepository<Pessoa> {
    public PessoaRepository() {
    }

    @Override
    public Pessoa find(Integer id)  {
        return null;
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT
                        `ps`.*,
                        `end`.`rua`,
                        `end`.`bairro`,
                        `end`.`numero`,
                        `end`.`idCidade`,
                        `cd`.`nome` as `nomeCidade`,
                        `cd`.`uf` as `uf`
                    FROM `fan_club`.`pessoa` as `ps`
                    JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                    JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                    WHERE `ps`.`id` = ?;"""
            );
            st.setInt(1, id);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                try {
                    Constructor<K> constructor = clazz.getDeclaredConstructor(ResultSet.class);
                    return constructor.newInstance(result);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            return null;
        });
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(Pessoa entity) {

    }
}
