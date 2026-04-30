package SERVICE;

public final class CpfUtils {

    private CpfUtils() {
    }

    public static String somenteDigitos(String cpf) {
        if (cpf == null) {
            return "";
        }
        return cpf.replaceAll("[^0-9]", "");
    }

    public static boolean possuiOnzeDigitos(String cpf) {
        return somenteDigitos(cpf).matches("\\d{11}");
    }

    public static String formatar(String cpf) {
        String cpfLimpo = somenteDigitos(cpf);
        if (!possuiOnzeDigitos(cpfLimpo)) {
            return cpf;
        }
        return cpfLimpo.substring(0, 3) + "." + cpfLimpo.substring(3, 6) + "."
                + cpfLimpo.substring(6, 9) + "-" + cpfLimpo.substring(9);
    }
}
