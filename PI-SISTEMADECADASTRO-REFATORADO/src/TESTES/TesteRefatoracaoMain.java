package TESTES;

import MODEL.Vendas;
import SERVICE.CpfUtils;
import SERVICE.DataUtils;

public class TesteRefatoracaoMain {

    public static void main(String[] args) {
        System.out.println("Iniciando testes da refatoracao...");

        testarCpfUtils();
        testarDataUtils();
        testarDataInvalidaEmVendas();

        System.out.println("Todos os testes foram executados com sucesso.");
    }

    private static void testarCpfUtils() {
        String cpfComMascara = "123.456.789-09";
        String cpfLimpo = CpfUtils.somenteDigitos(cpfComMascara);
        assertIgual("12345678909", cpfLimpo, "Remocao de mascara do CPF");

        String cpfFormatado = CpfUtils.formatar(cpfLimpo);
        assertIgual("123.456.789-09", cpfFormatado, "Formatacao de CPF");

        if (!CpfUtils.possuiOnzeDigitos(cpfFormatado)) {
            throw new RuntimeException("CPF deveria ser valido com 11 digitos.");
        }
    }

    private static void testarDataUtils() {
        String dataBanco = DataUtils.paraBanco("27/04/2026");
        assertIgual("2026-04-27", dataBanco, "Conversao de data para banco");

        String dataTela = DataUtils.paraTela("2026-04-27");
        assertIgual("27/04/2026", dataTela, "Conversao de data para tela");
    }

    private static void testarDataInvalidaEmVendas() {
        boolean erroLancado = false;
        try {
            new Vendas("12345678909", "Ana", "ana@email.com", "11999999999", "Mouse", 99.9, "40/15/2026");
        } catch (IllegalArgumentException e) {
            erroLancado = true;
        }

        if (!erroLancado) {
            throw new RuntimeException("Era esperado erro para data invalida em Vendas.");
        }
    }

    private static void assertIgual(String esperado, String atual, String contexto) {
        if (!esperado.equals(atual)) {
            throw new RuntimeException(contexto + " falhou. Esperado: " + esperado + ", atual: " + atual);
        }
    }
}
