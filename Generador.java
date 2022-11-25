import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.net.ServerSocket;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;

public class Generador {
    public int horalocal(){
        Calendar calendar = Calendar.getInstance();

        int hora = calendar.get(calendar.HOUR_OF_DAY);

        return hora;
    }
    public SecretKey secretKey(String clave){
        KeyPairGenerator generator;

        SecretKey secretKey = null;

        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keySpec = new DESKeySpec(clave.getBytes());
            secretKey = secretKeyFactory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        return secretKey;
    }
}
