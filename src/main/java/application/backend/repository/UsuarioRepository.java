package application.backend.repository;

import application.backend.dto.DataTransferObject;
import application.backend.entities.*;
import application.database.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends BaseRepository<Usuario> {
    public UsuarioRepository() {
    }

    @Override
    public Usuario find(Integer id) {
        return performOperation(connection -> {
            PreparedStatement st;
            try {
                st = connection.prepareStatement("""
                        SELECT `usr`.*, `tp`.*, `ps`.*, `end`.*, `cd`.*
                        FROM `fan_club`.`usuario` as `usr`
                        JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                        JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                        JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                        JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`;"""
                );
                ResultSet result = st.executeQuery();

                Usuario usuario = null;
                if (result.next()) {
                    usuario = new Usuario(result);
                }
                DataBase.closeResultSet(result);

                return usuario;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
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
    public List<Usuario> findAll() {
        return performOperation(connection -> {
            PreparedStatement st = connection.prepareStatement("""
                    SELECT `usr`.*, `tp`.*, `ps`.*, `end`.*, `cd`.*
                        FROM `fan_club`.`usuario` as `usr`
                        JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                        JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                        JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                        JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`;"""
            );
            ArrayList<Usuario> usuarios = new ArrayList<>();
            ResultSet result = st.executeQuery();

            while (result.next()) {
                usuarios.add(new Usuario(result));
            }
            DataBase.closeResultSet(result);
            DataBase.closeStatement(st);
            return usuarios;
        });
    }

    @Override
    public Usuario save(Usuario entity) {
        return performOperation((connection -> {
            PreparedStatement st = connection.prepareStatement("""
                            INSERT INTO `fan_club`.`usuario` (nome, email, senha, idPessoa, idTipoUsuario)
                            VALUES (?, ?, ?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, entity.getNome());
            st.setString(2, entity.getEmail());
            st.setString(3, entity.getSenha());
            st.setInt(4, entity.getIdPessoa());
            st.setInt(5, entity.getIdTipoUsuario());

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

    public void update(Usuario entity) {
        performOperation(connection -> {
            String sql = "UPDATE `fan_club`.`usuario` SET nome = ?, email = ?, idPessoa = ?, idTipoUsuario = ?";
            if (entity.getSenha() != null) {
                sql += ", senha = ?";
            }
            sql += " WHERE id = ?";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, entity.getNome());
            st.setString(2, entity.getEmail());
            st.setInt(3, entity.getIdPessoa());
            st.setInt(4, entity.getIdTipoUsuario());

            if (entity.getSenha() != null) {
                st.setString(5, entity.getSenha());
                st.setInt(6, entity.getId());
            } else {
                st.setInt(5, entity.getId());
            }

            st.executeUpdate();
            DataBase.closeStatement(st);
        });
    }


    public Usuario findByEmail(String email) {
        return performOperation(connection -> {
            PreparedStatement st;
            try {
                st = connection.prepareStatement("""
                        SELECT `usr`.*, `tp`.*, `ps`.*, `end`.*, `cd`.*
                        FROM `fan_club`.`usuario` as `usr`
                        JOIN `fan_club`.`tipoUsuario` as `tp` on `tp`.`id` = `usr`.`idTipoUsuario`
                        JOIN `fan_club`.`pessoa` as `ps` on `ps`.`id` = `usr`.`idPessoa`
                        JOIN `fan_club`.`endereco` as `end` on `end`.`id` = `ps`.`idEndereco`
                        JOIN `fan_club`.`cidade` as `cd` on `cd`.`id` = `end`.`idCidade`
                        WHERE `usr`.`email` = ?;"""
                );
                st.setString(1, email);
                ResultSet result = st.executeQuery();

                if (result.next()) {
                    return new Usuario(result);
                }

                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
