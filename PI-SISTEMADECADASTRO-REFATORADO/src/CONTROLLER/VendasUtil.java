package CONTROLLER;

import MODEL.Vendas;
import REPOSITORY.VendasRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendasUtil {

    private static final Logger logger = Logger.getLogger(VendasUtil.class.getName());
    private final VendasRepository vendasRepository;

    public VendasUtil() {
        this.vendasRepository = new VendasRepository();
    }

    public boolean adicionar(Vendas venda) {
        try {
            return vendasRepository.adicionar(venda);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao registrar venda", e);
            JOptionPane.showMessageDialog(null, "Erro ao registrar venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Vendas> listarVendas() {
        try {
            return vendasRepository.listarVendas();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar vendas", e);
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public List<Vendas> filtrarPorData(String data) {
        try {
            return vendasRepository.filtrarPorData(data);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Formato de data invalido. Use DD/MM/AAAA", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por data", e);
            JOptionPane.showMessageDialog(null, "Erro ao filtrar vendas", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public List<Vendas> filtrarPorPeriodo(String dataInicio, String dataFim) {
        try {
            return vendasRepository.filtrarPorPeriodo(dataInicio, dataFim);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Formato de data invalido. Use DD/MM/AAAA", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao filtrar por periodo", e);
            JOptionPane.showMessageDialog(null, "Erro ao filtrar vendas por periodo", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public static List<Vendas> buscarPorCpf(String cpf) {
        VendasUtil vendasUtil = new VendasUtil();
        try {
            return vendasUtil.vendasRepository.buscarPorCpf(cpf);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar vendas por CPF", e);
            throw new RuntimeException("Erro ao buscar vendas por CPF", e);
        }
    }
}
