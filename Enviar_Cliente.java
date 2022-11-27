import java.io.Serializable;

public class Enviar_Cliente implements Serializable {
    private int ID_client = 001;
    private int ID_TGS = 003;
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

    private int ID_V = 004;
    private String Ticket_AS_Cifrado;
    private String Autentificacion_cifrado;

    public int getID_V() {
        return ID_V;
    }

    public void setID_V(int ID_V) {
        this.ID_V = ID_V;
    }

    public String getTicket_AS_Cifrado() {
        return Ticket_AS_Cifrado;
    }

    public void setTicket_AS_Cifrado(String ticket_AS_Cifrado) {
        Ticket_AS_Cifrado = ticket_AS_Cifrado;
    }

    public String getAutentificacion() {
        return Autentificacion_cifrado;
    }

    public void setAutentificacion(String autentificacion) {
        Autentificacion_cifrado = autentificacion;
    }
    private String Autentificador_V;
    private String Ticket_V;

    public String getAutentificacion_cifrado() {
        return Autentificacion_cifrado;
    }

    public void setAutentificacion_cifrado(String autentificacion_cifrado) {
        Autentificacion_cifrado = autentificacion_cifrado;
    }

    public String getAutentificador_V() {
        return Autentificador_V;
    }

    public void setAutentificador_V(String autentificador_V) {
        Autentificador_V = autentificador_V;
    }

    public String getTicket_V() {
        return Ticket_V;
    }

    public void setTicket_V(String ticket_V) {
        Ticket_V = ticket_V;
    }
}
