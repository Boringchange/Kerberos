import java.io.Serializable;

public class Enviar_Cliente implements Serializable {
    private int ID_client = 001;
    private int ID_TGS = 002;
    private int TS;


    public int getTS() {
        return TS;
    }

    public void setTS(int TS) {
        this.TS = TS;
    }

    public int getID_client() {
        return ID_client;
    }

    public void setID_client(int ID_client) {
        this.ID_client = ID_client;
    }

    public int getID_TGS() {
        return ID_TGS;
    }

    public void setID_TGS(int ID_TGS) {
        this.ID_TGS = ID_TGS;
    }
}
