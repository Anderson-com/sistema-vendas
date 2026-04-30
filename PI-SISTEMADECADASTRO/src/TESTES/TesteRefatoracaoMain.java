package TESTES;

import MODEL.Vendas;
import SERVICE.CpfUtils;
import SERVICE.DataUtils;

public class TesteRefatoracaoMain {

    public static void main(String[] args) {
        System.out.println("Iniciando testes de refatoracao...");

        testarCpfUtils();
        testarDataUtils();
        testarDataInvalidaEmVenda();

        System.out.println("Todos os testes executados com sucesso.");
    }

    private static void testarCpfUtils() {
        String cpfFormatado = "123.456.789-09";
        String cpfLimpo = CpfUtils.somenteDigitos(cpfFormatado);
        assertIgual("12345678909", cpfLimpo, "CPF deve conter apenas digitos");

        String cpfComMascara = CpfUtils.formatar(cpfLimpo);
        assertIgual("123.456.789-09", cpfComMascara, "CPF deve ser formatado corretamente");

        if (!CpfUtils.possuiOnzeDigitos(cpfComMascara)) {
            throw new RuntimeException("CPF com 11 digitos deveria ser valido");
        }
    }

    private static void testarDataUtils() {
        String dataBanco = DataUtils.paraBanco("27/04/2026");
        assertIgual("2026-04-27", dataBanco, "Data de exibicao deve converter para banco");

        String dataExibicao = DataUtils.paraExibicao("2026-04-27");
        assertIgual("27/04/2026", dataExibicao, "Data de banco deve converter para exibicao");
    }

    private static void testarDataInvalidaEmVenda() {
        boolean erroLancado = false;
        try {
            new Vendas("12345678909", "Ana", "ana@email.com", "11999999999", "Mouse", 100.0, "40/15/2026");
        } catch (IllegalArgumentException e) {
            erroLancado = true;
        }

        if (!erroLancado) {
            throw new RuntimeException("Esperava erro para data invalida em Vendas");
        }
    }

    private static void assertIgual(String esperado, String atual, String contexto) {
        if (!esperado.equals(atual)) {
            throw new RuntimeException(contexto + ". Esperado: " + esperado + ", atual: " + atual);
        }
    }
}
