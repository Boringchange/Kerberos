import javax.crypto.SecretKey;

public class Enviar_TGS {
    SecretKey Ks_C_V;
    int ID_V = 004;
    int TS_4;
    String ticket_v_Cifrado;

    public SecretKey getKs_c_tgs() {
        return Ks_C_V;
    }

    public void setKs_c_tgs(SecretKey ks_c_tgs) {
        Ks_C_V = ks_c_tgs;
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

    public String getTicket_v_Cifrado() {
        return ticket_v_Cifrado;
    }

    public void setTicket_v_Cifrado(String ticket_v_Cifrado) {
        this.ticket_v_Cifrado = ticket_v_Cifrado;
    }
}
