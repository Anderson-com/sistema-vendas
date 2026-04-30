package REPOSITORY;

import CONTROLLER.Conexao;
import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public Usuario autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = SHA2(?, 256)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setTipo(rs.getString("tipo"));
                    usuario.setCpf(rs.getString("cpf"));
                    return usuario;
                }
            }
        }
        return null;
    }

    public boolean cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (login, senha, tipo, cpf) VALUES (?, SHA2(?, 256), ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            stmt.setString(4, usuario.getCpf());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        String sql = "SELECT login, tipo, cpf FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setCpf(rs.getString("cpf"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public boolean excluirUsuario(String login) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE login = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            return stmt.executeUpdate() > 0;
        }
    }
}
