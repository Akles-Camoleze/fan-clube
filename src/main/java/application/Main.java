package application;

import application.backend.entities.Usuario;
import application.backend.repository.PessoaRepository;
import application.backend.repository.UsuarioRepository;
import application.database.Migration;
import application.database.Seeder;
import application.ui.Login;
import application.ui.Register;

public class Main {
    public static void main(String[] args) {
//        Migration.initDatabase();
//        Seeder.run();
//        java.awt.EventQueue.invokeLater(() -> new Register().setVisible(true));
        Usuario usuario = new UsuarioRepository().findByEmail("john@example.com");
        if (usuario != null) {
            System.out.println(new PessoaRepository().find(usuario.getIdPessoa()));
        }
    }
}