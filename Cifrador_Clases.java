import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Cifrador_Clases {

    public String Cifrado_Ticket_As(Ticket_AS ticketAs, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] ticketSplit;

        objectOutputStream.writeObject(ticketAs);
        ticketSplit = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] ticketAsCifrado = cipher.doFinal(ticketSplit);
        cifrado = Base64.getEncoder().encodeToString(ticketAsCifrado);

        return cifrado;
    }
    public Ticket_AS Descifrado_Ticket_As(String TicketCifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
        Ticket_AS ticket_as = new Ticket_AS();

        byte[] TicketAs;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        TicketAs = cipher.doFinal(Base64.getDecoder().decode(TicketCifrado));
        InputStream inputStream = new ByteArrayInputStream(TicketAs);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ticket_as = (Ticket_AS) (objectInputStream.readObject());

        return ticket_as;
    }

}
