package application;

import application.backend.dto.EventoEnderecoCidadeDTO;
import application.backend.dto.PessoaEnderecoCidadeDTO;
import application.backend.dto.UsuarioTipoDTO;
import application.backend.entities.Evento;
import application.backend.entities.Usuario;
import application.backend.repository.EventoRepository;
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
        UsuarioTipoDTO usuarioDTO = new UsuarioRepository().findByEmail("john@example.com", UsuarioTipoDTO.class);
        if (usuarioDTO != null) {
            System.out.println(usuarioDTO);
            System.out.println(new PessoaRepository().find(usuarioDTO.getIdPessoa(), PessoaEnderecoCidadeDTO.class));
        }

        for (EventoEnderecoCidadeDTO dto : new EventoRepository().findAll(EventoEnderecoCidadeDTO.class)) {
            System.out.println(dto);
        }
    }
}