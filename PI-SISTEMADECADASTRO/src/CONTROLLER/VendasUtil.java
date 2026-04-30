package CONTROLLER;

import MODEL.Vendas;
import SERVICE.DataUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VendasUtil {

    private static final Logger logger = Logger.getLogger(VendasUtil.class.getName());

    public boolean adicionar(Vendas venda) {
        String sql = "INSERT INTO vendas (data_venda, cpf_cliente, nome_cliente, produto, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, DataUtils.paraBanco(venda.getData()));
            stmt.setString(2, venda.getCpf());
            stmt.setString(3, venda.getNome());
            stmt.setString(4, venda.getProduto());
            stmt.setDouble(5, venda.getValor());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao registrar venda", e);
            JOptionPane.showMessageDialog(null,
                    "Erro ao registrar venda: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Vendas> listarVendas() {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas";
        return consultarVendas(sql, null, null);
    }

    public void listarVendas(JTable tabela) {
        preencherTabela(tabela, listarVendas());
    }

    public List<Vendas> filtrarPorData(String data) {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda = ?";
        return consultarVendas(sql, DataUtils.paraBanco(data), null);
    }

    public void filtrarPorData(JTable tabela, String data) {
        preencherTabela(tabela, filtrarPorData(data));
    }

    public List<Vendas> filtrarPorPeriodo(String dataInicio, String dataFim) {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda BETWEEN ? AND ?";
        return consultarVendas(sql, DataUtils.paraBanco(dataInicio), DataUtils.paraBanco(dataFim));
    }

    public void filtrarPorPeriodo(JTable tabela, String dataInicio, String dataFim) {
        preencherTabela(tabela, filtrarPorPeriodo(dataInicio, dataFim));
    }

    public static List<Vendas> buscarPorCpf(String cpf) {
        VendasUtil vendasUtil = new VendasUtil();
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE cpf_cliente LIKE ?";
        return vendasUtil.consultarVendas(sql, "%" + cpf + "%", null);
    }

    private List<Vendas> consultarVendas(String sql, String parametro1, String parametro2) {
        List<Vendas> vendas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (parametro1 != null) {
                stmt.setString(1, parametro1);
            }
            if (parametro2 != null) {
                stmt.setString(2, parametro2);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    vendas.add(mapearVenda(rs));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao consultar vendas", e);
            throw new RuntimeException("Erro ao consultar vendas", e);
        }
        return vendas;
    }

    private Vendas mapearVenda(ResultSet rs) throws SQLException {
        String dataExibicao;
        try {
            dataExibicao = DataUtils.paraExibicao(rs.getString("data_venda"));
        } catch (IllegalArgumentException e) {
            dataExibicao = rs.getString("data_venda");
        }

        return new Vendas(
                rs.getString("cpf_cliente"),
                rs.getString("nome_cliente"),
                "",
                "",
                rs.getString("produto"),
                rs.getDouble("valor"),
                dataExibicao
        );
    }

    private void preencherTabela(JTable tabela, List<Vendas> vendas) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);

        for (Vendas venda : vendas) {
            model.addRow(new Object[]{
                venda.getData(),
                venda.getCpf(),
                venda.getNome(),
                venda.getProduto(),
                String.format("R$ %.2f", venda.getValor())
            });
        }
    }
}
