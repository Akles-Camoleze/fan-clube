package application.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Seeder {
    static final String insertTipoUsuario = "INSERT INTO fan_club.tipoUsuario (nome) VALUES ('Administrador'), ('Comum');";

    static final String insertCidade = "INSERT INTO fan_club.cidade (nome, uf) VALUES" +
            "('São Paulo', 'SP'), " +
            "('Santo André', 'SP'), " +
            "('Guarulhos', 'SP'), " +
            "('Formiga', 'MG'), " +
            "('Divinópolis', 'MG'), " +
            "('Cristais', 'MG'), " +
            "('Camacho', 'MG'), " +
            "('Rezende', 'RJ')," +
            "('Vitória', 'ES')," +
            "('Rio de Janeiro', 'RJ');";

    static final String insertEndereco = "INSERT INTO fan_club.endereco (rua, numero, bairro, idCidade) VALUES " +
            "('Rua X', 789, 'Vila Nova', 3)," +
            "('Avenida Y', 101, 'Jardim Paulista', 1)," +
            "('Rua Z', 234, 'Copacabana', 9)," +
            "('Avenida W', 567, 'Santa Teresa', 8)," +
            "('Rua P', 876, 'Ipanema', 10)," +
            "('Avenida Q', 543, 'Centro', 6)," +
            "('Rua R', 210, 'Barra da Tijuca', 9)," +
            "('Avenida S', 987, 'Laranjeiras', 7)," +
            "('Rua T', 321, 'Gloria', 5)," +
            "('Avenida U', 654, 'Botafogo', 2), " +
            "('Rua A1', 123, 'Centro', 1)," +
            "('Rua B1', 456, 'Botafogo', 2)," +
            "('Rua C1', 789, 'Ipanema', 3)," +
            "('Rua D1', 101, 'Copacabana', 4)," +
            "('Rua E1', 234, 'Lapa', 5)," +
            "('Rua F1', 567, 'Gávea', 6)," +
            "('Rua G1', 876, 'Humaitá', 7)," +
            "('Rua H1', 210, 'Leblon', 8)," +
            "('Rua I1', 321, 'Laranjeiras', 9)," +
            "('Rua J1', 654, 'Jardim Botânico', 10);";


    static final String insertPessoa = "INSERT INTO fan_club.pessoa (nome, sobrenome, telefone, dataNascimento, idEndereco) VALUES " +
            "('Ana', 'Oliveira', '11111111111', '1988-03-20', 3)," +
            "('Carlos', 'Pereira', '22222222222', '1995-07-10', 4)," +
            "('Fernanda', 'Rodrigues', '33333333333', '1980-11-25', 5)," +
            "('Lucas', 'Costa', '44444444444', '1992-04-15', 6)," +
            "('Juliana', 'Almeida', '55555555555', '1987-09-30', 7)," +
            "('Ricardo', 'Nunes', '66666666666', '1983-12-05', 8)," +
            "('Amanda', 'Ferreira', '77777777777', '1998-02-18', 9)," +
            "('Felipe', 'Mendes', '88888888888', '1986-06-22', 10)," +
            "('Patricia', 'Souza', '99999999999', '1994-08-08', 1)," +
            "('Gustavo', 'Lima', '00000000000', '1989-10-12', 2);";

    static final String insertUsuario = "INSERT INTO fan_club.usuario (nome, email, senha, idTipoUsuario, idPessoa) VALUES " +
            "('john', 'john@example.com', 'john123', 1, 1)," +
            "('maria123', 'maria@example.com', 'maria456', 1, 2)," +
            "('carlos', 'carlos@example.com', 'carlos789', 2, 3)," +
            "('ferRodrigues', 'fernanda@example.com', 'fernanda321', 2, 4)," +
            "('lucas', 'lucas@example.com', 'lucas789', 2, 5)," +
            "('juliana', 'juliana@example.com', 'juliana123', 2, 6)," +
            "('ricardo', 'ricardo@example.com', 'ricardo456', 2, 7)," +
            "('amanda', 'amanda@example.com', 'amanda789', 2, 8)," +
            "('felipe', 'felipe@example.com', 'felipe123', 2, 9)," +
            "('patricia', 'patricia@example.com', 'patricia456', 2, 10);";


    static final String insertEvento = "INSERT INTO fan_club.evento (nome, data, descricao, idEndereco, capacidade, valor) VALUES " +
            "('Evento 1', '2023-01-20', 'Descrição do Evento 1', 11, 1000, 50.00)," +
            "('Evento 2', '2023-02-15', 'Descrição do Evento 2', 12, 500, 25.00)," +
            "('Evento 3', '2023-03-10', 'Descrição do Evento 3', 13, 800, 40.00)," +
            "('Evento 4', '2023-04-25', 'Descrição do Evento 4', 14, 300, 15.00)," +
            "('Evento 5', '2023-05-15', 'Descrição do Evento 5', 15, 500, 20.00)," +
            "('Evento 6', '2023-06-20', 'Descrição do Evento 6', 16, 200, 10.00)," +
            "('Evento 7', '2023-07-10', 'Descrição do Evento 7', 17, 150, 8.00)," +
            "('Evento 8', '2023-08-05', 'Descrição do Evento 8', 18, 400, 18.00)," +
            "('Evento 9', '2023-09-15', 'Descrição do Evento 9', 19, 100, 5.00)," +
            "('Evento 10', '2023-10-20', 'Descrição do Evento 10', 20, 300, 15.00);";

    static final String insertComentario = "INSERT INTO fan_club.comentario (mensagem, idEvento, idUsuario) VALUES" +
            "('Ótimo evento!', 1, 3)," +
            "('Adorei a apresentação!', 2, 4)," +
            "('Parabéns pela organização!', 3, 5)," +
            "('Incrível, quero mais eventos assim!', 4, 6)," +
            "('Muito bom, recomendo!', 5, 7)," +
            "('Espero que tenham mais eventos como esse!', 6, 8)," +
            "('Gostei bastante da programação.', 7, 9)," +
            "('A música estava ótima!', 8, 10)," +
            "('Excelente evento, estou ansioso para o próximo.', 9, 1)," +
            "('As exposições foram incríveis!', 10, 2)," +
            "('Comentário 11', 1, 3)," +
            "('Comentário 12', 2, 4)," +
            "('Comentário 13', 3, 5)," +
            "('Comentário 14', 4, 6)," +
            "('Comentário 15', 5, 7)," +
            "('Comentário 16', 6, 8)," +
            "('Comentário 17', 7, 9)," +
            "('Comentário 18', 8, 10)," +
            "('Comentário 19', 9, 1)," +
            "('Comentário 20', 10, 2);";

    static final String insertResposta = "INSERT INTO fan_club.resposta (mensagem, idUsuario, idComentario) VALUES" +
            "('Obrigado pelo elogio!', 3, 1)," +
            "('Que bom que você gostou!', 4, 2)," +
            "('Agradecemos pelo feedback positivo!', 5, 3)," +
            "('Ficamos felizes em saber!', 6, 4)," +
            "('A equipe trabalhou duro para proporcionar uma boa experiência.', 7, 5)," +
            "('Contamos com a sua presença nos próximos eventos!', 8, 6)," +
            "('Apreciamos seu comentário!', 9, 7)," +
            "('Esperamos vê-lo novamente em breve!', 10, 8)," +
            "('Muito obrigado pelo apoio!', 1, 9)," +
            "('Estamos sempre buscando melhorar.', 2, 10);";


    static final String insertInscricao = "INSERT INTO fan_club.inscricao (dataInscricao, idUsuario, idEvento) VALUES" +
            "('2024-07-15', 1, 1)," +
            "('2024-08-02', 2, 2)," +
            "('2023-01-10', 3, 3)," +
            "('2023-02-01', 4, 4)," +
            "('2023-03-15', 5, 5)," +
            "('2023-04-05', 6, 6)," +
            "('2023-05-20', 7, 7)," +
            "('2023-06-10', 8, 8)," +
            "('2023-07-05', 9, 9)," +
            "('2023-08-12', 10, 10)," +
            "('2023-09-25', 1, 10)," +
            "('2023-10-30', 2, 9)," +
            "('2023-11-18', 3, 8)," +
            "('2023-12-01', 4, 7)," +
            "('2024-01-05', 5, 6)," +
            "('2024-02-20', 6, 5)," +
            "('2024-03-10', 7, 4)," +
            "('2024-04-15', 8, 3)," +
            "('2024-05-22', 9, 2)," +
            "('2024-06-08', 10, 1);";

    public static void run() {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate(insertTipoUsuario);
                System.out.println("Seeder TipoUsuario - OK!");

                statement.executeUpdate(insertCidade);
                System.out.println("Seeder Cidade - OK!");

                statement.executeUpdate(insertEndereco);
                System.out.println("Seeder Endereço - OK!");

                statement.executeUpdate(insertPessoa);
                System.out.println("Seeder Pessoa - OK!");

                statement.executeUpdate(insertUsuario);
                System.out.println("Seeder Usuário - OK!");

                statement.executeUpdate(insertEvento);
                System.out.println("Seeder Evento - OK!");

                statement.executeUpdate(insertComentario);
                System.out.println("Seeder Comentário - OK!");

                statement.executeUpdate(insertResposta);
                System.out.println("Seeder Resposta - OK!");

                statement.executeUpdate(insertInscricao);
                System.out.println("Seeder Inscrição - OK!");
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
