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
        String cpfNumerico = somenteDigitos(cpf);
        if (!possuiOnzeDigitos(cpfNumerico)) {
            return cpf;
        }
        return cpfNumerico.substring(0, 3) + "." + cpfNumerico.substring(3, 6) + "." 
                + cpfNumerico.substring(6, 9) + "-" + cpfNumerico.substring(9);
    }
}
