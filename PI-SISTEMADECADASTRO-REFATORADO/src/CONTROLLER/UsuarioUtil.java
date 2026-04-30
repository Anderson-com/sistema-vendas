package CONTROLLER;

import MODEL.Usuario;
import REPOSITORY.UsuarioRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioUtil {
    private static final Logger logger = Logger.getLogger(UsuarioUtil.class.getName());
    private final UsuarioRepository usuarioRepository;

    public UsuarioUtil() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public Usuario autenticar(String login, String senha) {
        try {
            return usuarioRepository.autenticar(login, senha);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro na autenticacao", e);
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuario", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean cadastrar(Usuario usuario) {
        try {
            return usuarioRepository.cadastrar(usuario);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar usuario", e);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioRepository.listarUsuarios();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar usuarios", e);
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarios", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public boolean excluirUsuario(String login) {
        try {
            return usuarioRepository.excluirUsuario(login);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao excluir usuario", e);
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuario", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
