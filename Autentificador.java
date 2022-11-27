import java.io.Serializable;

public class Autentificador implements Serializable {
    private int ID_C ;
    private String IP_C;
    private int Hora_3;

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

    public int getHora_3() {
        return Hora_3;
    }

    public void setHora_3(int hora_3) {
        Hora_3 = hora_3;
    }
}
