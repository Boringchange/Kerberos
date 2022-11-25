import javax.crypto.SecretKey;

public class Enviar_AS {
    private SecretKey ks_c_tgs;
    private int ID_tgs;
    private int Hora_AS;
    private int lifetime_2;
    private String ticket_tgs_Cifrado;

    public SecretKey getKs_c_tgs() {
        return ks_c_tgs;
    }

    public void setKs_c_tgs(SecretKey ks_c_tgs) {
        this.ks_c_tgs = ks_c_tgs;
    }

    public int getID_tgs() {
        return ID_tgs;
    }

    public void setID_tgs(int ID_tgsl) {
        this.ID_tgs = ID_tgsl;
    }

    public int getHora_AS() {
        return Hora_AS;
    }

    public void setHora_AS(int hora_AS) {
        Hora_AS = hora_AS;
    }

    public int getLifetime_2() {
        return lifetime_2;
    }

    public void setLifetime_2(int lifetime_2) {
        this.lifetime_2 = lifetime_2;
    }

    public String getTicket_tgs_Cifrado() {
        return ticket_tgs_Cifrado;
    }

    public void setTicket_tgs_Cifrado(String ticket_tgs_Cifrado) {
        this.ticket_tgs_Cifrado = ticket_tgs_Cifrado;
    }
}
