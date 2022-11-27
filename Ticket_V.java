import javax.crypto.SecretKey;
import java.io.Serializable;

public class Ticket_V implements Serializable {
    private SecretKey Ks_C_V;
    private int ID_C = 001;
    private String IP_C;
    private int ID_V = 004;
    private int TS_4;
    private int timelife;

    public SecretKey getKs_C_V() {
        return Ks_C_V;
    }

    public void setKs_C_V(SecretKey ks_C_V) {
        Ks_C_V = ks_C_V;
    }

    public int getID_C() {
        return ID_C;
    }

    public void setID_C(int ID_C) {
        this.ID_C = ID_C;
    }

    public String getIP_C() {
        return IP_C;
    }

    public void setIP_C(String IP_C) {
        this.IP_C = IP_C;
    }

    public int getID_V() {
        return ID_V;
    }

    public void setID_V(int ID_V) {
        this.ID_V = ID_V;
    }

    public int getTS_4() {
        return TS_4;
    }

    public void setTS_4(int TS_4) {
        this.TS_4 = TS_4;
    }

    public int getTimelife() {
        return timelife;
    }

    public void setTimelife(int timelife) {
        this.timelife = timelife;
    }
}
