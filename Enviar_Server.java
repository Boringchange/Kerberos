import java.io.Serializable;

public class Enviar_Server implements Serializable {
    private int TS_5_1;
    private boolean pasedirecto;

    public int getTS_5_1() {
        return TS_5_1;
    }

    public void setTS_5_1(int TS_5_1) {
        this.TS_5_1 = TS_5_1;
    }

    public boolean isPasedirecto() {
        return pasedirecto;
    }

    public void setPasedirecto(boolean pasedirecto) {
        this.pasedirecto = pasedirecto;
    }
}
