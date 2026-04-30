package CONTROLLER;

import MODEL.Cliente;
import REPOSITORY.ClienteRepository;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteUtil {
    private static final Logger logger = Logger.getLogger(ClienteUtil.class.getName());
    private final ClienteRepository clienteRepository;

    public ClienteUtil() {
        this.clienteRepository = new ClienteRepository();
    }

    public boolean clienteExiste(String cpf) {
        try {
            return clienteRepository.clienteExiste(cpf);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao verificar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao verificar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean adicionar(Cliente cliente) {
        try {
            return clienteRepository.adicionar(cliente);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cadastrar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean atualizar(Cliente cliente) {
        try {
            return clienteRepository.atualizar(cliente);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao atualizar cliente", e);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            return clienteRepository.buscarPorCpf(cpf);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar cliente por CPF", e);
            return null;
        }
    }
}
