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
    public String Cifrado_Enviar_AS(Enviar_AS enviar_as, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] separado;

        objectOutputStream.writeObject(enviar_as);
        separado = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] Cifrado = cipher.doFinal(separado);
        cifrado = Base64.getEncoder().encodeToString(Cifrado);

        return cifrado;
    }
    public Enviar_AS Decifrador_Enviar_AS(String cifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        Enviar_AS enviarAs = new Enviar_AS();

        byte[] enviar_AS;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        enviar_AS = cipher.doFinal(Base64.getDecoder().decode(cifrado));
        InputStream inputStream = new ByteArrayInputStream(enviar_AS);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        enviarAs = (Enviar_AS) (objectInputStream.readObject());

        return enviarAs;
    }
    public String Cifrado_Autentificador(Autentificador autentificador, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] separado;

        objectOutputStream.writeObject(autentificador);
        separado = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] Cifrado = cipher.doFinal(separado);
        cifrado = Base64.getEncoder().encodeToString(Cifrado);

        return cifrado;
    }
    public Autentificador Decifrador_Autentificador(String cifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        Autentificador autentificador;

        byte[] enviar_AS;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        enviar_AS = cipher.doFinal(Base64.getDecoder().decode(cifrado));
        InputStream inputStream = new ByteArrayInputStream(enviar_AS);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        autentificador = (Autentificador) (objectInputStream.readObject());

        return autentificador;
    }
    public String Cifrado_Ticket_V(Ticket_V ticket_v, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] ticketSplit;

        objectOutputStream.writeObject(ticket_v);
        ticketSplit = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] ticketAsCifrado = cipher.doFinal(ticketSplit);
        cifrado = Base64.getEncoder().encodeToString(ticketAsCifrado);

        return cifrado;
    }
    public Ticket_V Descifrado_Ticket_V(String TicketCifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
        Ticket_V ticket_v= new Ticket_V();

        byte[] TicketAs;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        TicketAs = cipher.doFinal(Base64.getDecoder().decode(TicketCifrado));
        InputStream inputStream = new ByteArrayInputStream(TicketAs);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ticket_v = (Ticket_V) (objectInputStream.readObject());

        return ticket_v ;
    }
    public String Cifrado_Enviar_TGS(Enviar_TGS enviar_tgs, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] ticketSplit;

        objectOutputStream.writeObject(enviar_tgs);
        ticketSplit = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] ticketAsCifrado = cipher.doFinal(ticketSplit);
        cifrado = Base64.getEncoder().encodeToString(ticketAsCifrado);

        return cifrado;
    }
    public Enviar_TGS Descifrado_Enviar_TGS(String TicketCifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
        Enviar_TGS enviar_tgs = new Enviar_TGS();

        byte[] TicketAs;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        TicketAs = cipher.doFinal(Base64.getDecoder().decode(TicketCifrado));
        InputStream inputStream = new ByteArrayInputStream(TicketAs);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        enviar_tgs = (Enviar_TGS) (objectInputStream.readObject());

        return enviar_tgs;
    }
    public String Cifrado_Enviar_server(Enviar_Server enviar_server, SecretKey secretKey) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String cifrado;
        byte[] ticketSplit;

        objectOutputStream.writeObject(enviar_server);
        ticketSplit = outputStream.toByteArray();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] ticketAsCifrado = cipher.doFinal(ticketSplit);
        cifrado = Base64.getEncoder().encodeToString(ticketAsCifrado);

        return cifrado;
    }
    public Enviar_Server Descifrado_Enviar_server(String TicketCifrado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
        Enviar_Server  enviar_server = new Enviar_Server();

        byte[] TicketAs;

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        TicketAs = cipher.doFinal(Base64.getDecoder().decode(TicketCifrado));
        InputStream inputStream = new ByteArrayInputStream(TicketAs);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        enviar_server = (Enviar_Server) (objectInputStream.readObject());

        return enviar_server;
    }
}
