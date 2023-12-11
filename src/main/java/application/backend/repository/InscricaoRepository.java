package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.Inscricao;
import application.database.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InscricaoRepository extends BaseRepository<Inscricao> {
    public InscricaoRepository() {
        super("inscricao");
    }

    @Override
    public Inscricao find(Integer id) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> K find(Integer id, Class<K> clazz) {
        return null;
    }

    @Override
    public <K extends DataTransferObject> List<K> findAll(Class<K> clazz) {
        return null;
    }

    @Override
    public List<Inscricao> findAll() {
        return new ArrayList<>();
    }

    public List<Inscricao> findAllByUsuario(Integer idUsuario) {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                   
                    SELECT `ins`.*, `usr`.*, `env`.*, `ps`.*, `end`.*, `cd`.*, `tp`.*
                       FROM `fan_club`.`inscricao` as `ins`
                       JOIN `fan_club`.`usuario` as `usr` ON `usr`.`id` = `ins`.`idUsuario`
                       JOIN `fan_club`.`tipoUsuario` as `tp` ON `tp`.`id` = `usr`.`idTipoUsuario`
                       JOIN `fan_club`.`evento` as `env` ON `env`.`id` = `ins`.`idEvento`
                       JOIN `fan_club`.`pessoa` as `ps` ON `ps`.`id` = `usr`.`idPessoa`
                       JOIN `fan_club`.`endereco` as `end` ON `end`.`id` = `ps`.`idEndereco`
                       JOIN `fan_club`.`cidade` as `cd` ON `cd`.`id` = `end`.`idCidade`
                       WHERE `usr`.`id` = ?;
                    """
            );
            st.setInt(1, idUsuario);

            ArrayList<Inscricao> inscricoes = new ArrayList<>();
            ResultSet result = st.executeQuery();

            while (result.next()) {
                inscricoes.add(new Inscricao(result));
            }
            return inscricoes;
        });
    }

    @Override
    public Inscricao save(Inscricao entity) {
        return performOperation((connection -> {
            PreparedStatement st = connection.prepareStatement("""
                            INSERT INTO `fan_club`.`inscricao` (idUsuario, idEvento)
                            VALUES (?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setInt(1, entity.getIdUsuario());
            st.setInt(2, entity.getIdEvento());

            if (st.executeUpdate() > 0) {
                ResultSet resultSet = st.getGeneratedKeys();
                if (resultSet.next()) {
                    entity.setId(resultSet.getInt(1));
                }
                DataBase.closeResultSet(resultSet);
                DataBase.closeStatement(st);
                return entity;
            }
            DataBase.closeStatement(st);

            return null;
        }));
    }

}
