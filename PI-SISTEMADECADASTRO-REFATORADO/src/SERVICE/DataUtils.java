package SERVICE;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class DataUtils {

    private static final SimpleDateFormat FORMATO_DB = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat FORMATO_TELA = new SimpleDateFormat("dd/MM/yyyy");

    static {
        FORMATO_DB.setLenient(false);
        FORMATO_TELA.setLenient(false);
    }

    private DataUtils() {
    }

    public static String paraBanco(String dataTela) {
        try {
            return FORMATO_DB.format(FORMATO_TELA.parse(dataTela));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data invalido. Use DD/MM/AAAA.", e);
        }
    }

    public static String paraTela(String dataBanco) {
        try {
            return FORMATO_TELA.format(FORMATO_DB.parse(dataBanco));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data invalido retornado pelo banco.", e);
        }
    }
}
