import java.util.Calendar;

public class Generador {
    public int horalocal(){
        Calendar calendar = Calendar.getInstance();

        int hora = calendar.get(calendar.HOUR_OF_DAY);

        return hora;
    }
}
