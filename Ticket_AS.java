import javax.crypto.SecretKey;
import java.io.Serializable;

public class Ticket_AS implements Serializable {
    private SecretKey clave_c_tgs;
    private int idC;
    private String IpC;
    private int idTgs;
    private int ts2;
    private int lifetime;

    public SecretKey getClave_c_tgs() {
        return clave_c_tgs;
    }

    public void setClave_c_tgs(SecretKey clave_c_tgs) {
        this.clave_c_tgs = clave_c_tgs;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getIpC() {
        return IpC;
    }

    public void setIpC(String ipC) {
        IpC = ipC;
    }

    public int getIdTgs() {
        return idTgs;
    }

    public void setIdTgs(int idTgs) {
        this.idTgs = idTgs;
    }

    public int getTs2() {
        return ts2;
    }

    public void setTs2(int ts2) {
        this.ts2 = ts2;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

}
