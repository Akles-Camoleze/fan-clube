package application.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration {

    public static void initDatabase() {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            try {
                String sql = "CREATE SCHEMA IF NOT EXISTS `fan_club` DEFAULT CHARACTER SET utf8";
                statement.executeUpdate(sql);
                System.out.println("Banco de dados criado com sucesso!");


                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`tipoUsuario` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `nome` VARCHAR(100) NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela tipoUsuario com sucesso!");


                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`cidade` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `nome` VARCHAR(100) NOT NULL," +
                        "  `uf` VARCHAR(3) NOT NULL," +
                        "  PRIMARY KEY (`id`))" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela cidade com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`endereco` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `rua` VARCHAR(100) NOT NULL," +
                        "  `numero` INT NOT NULL," +
                        "  `bairro` VARCHAR(100) NOT NULL," +
                        "  `idCidade` INT NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_endereco_cidade1_idx` (`idCidade` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_endereco_cidade1`" +
                        "    FOREIGN KEY (`idCidade`)" +
                        "    REFERENCES `fan_club`.`cidade` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela endereco com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`pessoa` (" +
                        "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                        "  `nome` VARCHAR(100) NOT NULL," +
                        "  `sobrenome` VARCHAR(100) NOT NULL," +
                        "  `telefone` VARCHAR(11) NOT NULL," +
                        "  `dataNascimento` DATE NOT NULL," +
                        "  `idEndereco` INT NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_pessoa_endereco1_idx` (`idEndereco` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_pessoa_endereco1`" +
                        "    FOREIGN KEY (`idEndereco`)" +
                        "    REFERENCES `fan_club`.`endereco` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela pessoa com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`usuario` (" +
                        "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                        "  `nome` VARCHAR(100) NOT NULL," +
                        "  `email` VARCHAR(100) NOT NULL," +
                        "  `senha` VARCHAR(100) NOT NULL," +
                        "  `idTipoUsuario` INT NOT NULL," +
                        "  `idPessoa` INT UNSIGNED NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE," +
                        "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
                        "  INDEX `fk_usuario_tipoUsuario_idx` (`idTipoUsuario` ASC) VISIBLE," +
                        "  INDEX `fk_usuario_pessoa1_idx` (`idPessoa` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_usuario_tipoUsuario`" +
                        "    FOREIGN KEY (`idTipoUsuario`)" +
                        "    REFERENCES `fan_club`.`tipoUsuario` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION," +
                        "  CONSTRAINT `fk_usuario_pessoa1`" +
                        "    FOREIGN KEY (`idPessoa`)" +
                        "    REFERENCES `fan_club`.`pessoa` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela usuario com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`arquivo` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `caminho` VARCHAR(100) NOT NULL," +
                        "  `dataUpload` DATETIME NOT NULL DEFAULT CURRENT_DATE," +
                        "  PRIMARY KEY (`id`))" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela arquivo com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`evento` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `nome` VARCHAR(100) NOT NULL," +
                        "  `data` DATETIME NOT NULL," +
                        "  `descricao` VARCHAR(300) NOT NULL," +
                        "  `idEndereco` INT NOT NULL," +
                        "  `idArquivo` INT," +
                        "  `capacidade` INT UNSIGNED NOT NULL," +
                        "  `valor` DECIMAL(10, 2) UNSIGNED NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_evento_endereco1_idx` (`idEndereco` ASC) VISIBLE," +
                        "  INDEX `fk_evento_arquivo1_idx` (`idArquivo` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_evento_endereco1`" +
                        "    FOREIGN KEY (`idEndereco`)" +
                        "    REFERENCES `fan_club`.`endereco` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION," +
                        "  CONSTRAINT `fk_evento_arquivo1`" +
                        "    FOREIGN KEY (`idArquivo`)" +
                        "    REFERENCES `fan_club`.`arquivo` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela evento com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`comentario` (" +
                        "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                        "  `mensagem` VARCHAR(300) NOT NULL," +
                        "  `idEvento` INT NOT NULL," +
                        "  `idUsuario` INT UNSIGNED NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_comentario_evento1_idx` (`idEvento` ASC) VISIBLE," +
                        "  INDEX `fk_comentario_usuario1_idx` (`idUsuario` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_comentario_evento1`" +
                        "    FOREIGN KEY (`idEvento`)" +
                        "    REFERENCES `fan_club`.`evento` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION," +
                        "  CONSTRAINT `fk_comentario_usuario1`" +
                        "    FOREIGN KEY (`idUsuario`)" +
                        "    REFERENCES `fan_club`.`usuario` (`id`)" +
                        "    ON DELETE NO ACTION" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela comentario com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`resposta` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `mensagem` VARCHAR(300) NOT NULL," +
                        "  `idUsuario` INT UNSIGNED NOT NULL," +
                        "  `idComentario` INT UNSIGNED NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_resposta_usuario1_idx` (`idUsuario` ASC) VISIBLE," +
                        "  INDEX `fk_resposta_comentario1_idx` (`idComentario` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_resposta_usuario1`" +
                        "    FOREIGN KEY (`idUsuario`)" +
                        "    REFERENCES `fan_club`.`usuario` (`id`)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE NO ACTION," +
                        "  CONSTRAINT `fk_resposta_comentario1`" +
                        "    FOREIGN KEY (`idComentario`)" +
                        "    REFERENCES `fan_club`.`comentario` (`id`)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela resposta com sucesso!");

                sql = "CREATE TABLE IF NOT EXISTS `fan_club`.`inscricao` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `dataInscricao` DATETIME NOT NULL DEFAULT CURRENT_DATE," +
                        "  `idUsuario` INT UNSIGNED NOT NULL," +
                        "  `idEvento` INT NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  INDEX `fk_inscricao_usuario1_idx` (`idUsuario` ASC) VISIBLE," +
                        "  INDEX `fk_inscricao_evento1_idx` (`idEvento` ASC) VISIBLE," +
                        "  CONSTRAINT `fk_inscricao_usuario1`" +
                        "    FOREIGN KEY (`idUsuario`)" +
                        "    REFERENCES `fan_club`.`usuario` (`id`)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE NO ACTION," +
                        "  CONSTRAINT `fk_inscricao_evento1`" +
                        "    FOREIGN KEY (`idEvento`)" +
                        "    REFERENCES `fan_club`.`evento` (`id`)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE NO ACTION)" +
                        "ENGINE = InnoDB;";
                statement.executeUpdate(sql);
                System.out.println("Tabela inscricao com sucesso!");

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            } finally {
                DataBase.closeResultSet(statement.getResultSet());
                DataBase.closeStatement(statement);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }
}

