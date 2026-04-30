package SERVICE;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class DataUtils {

    private static final SimpleDateFormat DATE_FORMAT_DB = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT_DISPLAY = new SimpleDateFormat("dd/MM/yyyy");

    static {
        DATE_FORMAT_DB.setLenient(false);
        DATE_FORMAT_DISPLAY.setLenient(false);
    }

    private DataUtils() {
    }

    public static String paraBanco(String dataExibicao) {
        try {
            return DATE_FORMAT_DB.format(DATE_FORMAT_DISPLAY.parse(dataExibicao));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data invalido. Use DD/MM/AAAA.", e);
        }
    }

    public static String paraExibicao(String dataBanco) {
        try {
            return DATE_FORMAT_DISPLAY.format(DATE_FORMAT_DB.parse(dataBanco));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data invalido no banco.", e);
        }
    }
}
