package REPOSITORY;

import CONTROLLER.Conexao;
import MODEL.Vendas;
import SERVICE.DataUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendasRepository {

    public boolean adicionar(Vendas venda) throws SQLException {
        String sql = "INSERT INTO vendas (data_venda, cpf_cliente, nome_cliente, produto, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, DataUtils.paraBanco(venda.getData()));
            stmt.setString(2, venda.getCpf());
            stmt.setString(3, venda.getNome());
            stmt.setString(4, venda.getProduto());
            stmt.setDouble(5, venda.getValor());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Vendas> listarVendas() throws SQLException {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas";
        return consultar(sql, null, null);
    }

    public List<Vendas> filtrarPorData(String data) throws SQLException {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda = ?";
        return consultar(sql, DataUtils.paraBanco(data), null);
    }

    public List<Vendas> filtrarPorPeriodo(String dataInicio, String dataFim) throws SQLException {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE data_venda BETWEEN ? AND ?";
        return consultar(sql, DataUtils.paraBanco(dataInicio), DataUtils.paraBanco(dataFim));
    }

    public List<Vendas> buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT data_venda, cpf_cliente, nome_cliente, produto, valor FROM vendas WHERE cpf_cliente LIKE ?";
        return consultar(sql, "%" + cpf + "%", null);
    }

    private List<Vendas> consultar(String sql, String param1, String param2) throws SQLException {
        List<Vendas> vendas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (param1 != null) {
                stmt.setString(1, param1);
            }
            if (param2 != null) {
                stmt.setString(2, param2);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    vendas.add(mapearVenda(rs));
                }
            }
        }
        return vendas;
    }

    private Vendas mapearVenda(ResultSet rs) throws SQLException {
        String dataTela;
        try {
            dataTela = DataUtils.paraTela(rs.getString("data_venda"));
        } catch (IllegalArgumentException e) {
            dataTela = rs.getString("data_venda");
        }

        return new Vendas(
                rs.getString("cpf_cliente"),
                rs.getString("nome_cliente"),
                "",
                "",
                rs.getString("produto"),
                rs.getDouble("valor"),
                dataTela
        );
    }
}
