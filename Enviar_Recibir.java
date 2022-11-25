import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Enviar_Recibir {
    public void Enviar_AS_C(Enviar_Cliente enviar, int puerto){
        try {
            ServerSocket socketconnection = new ServerSocket(puerto);
            Socket socketDatos = socketconnection.accept();
            OutputStream flujosalida = socketDatos.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(flujosalida);
            outputStream.writeObject(enviar);
            flujosalida.flush();
            socketDatos.close();
            socketconnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Enviar_Cliente Recibe_Autentificador (String IP, int puerto){
        Enviar_Cliente enviaC = null;
        try{
            InetAddress maquinaAceptadora = InetAddress.getByName(IP);
            Socket miSocket = new Socket(maquinaAceptadora, puerto);
            InputStream flujoEntrada = miSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(flujoEntrada);
            enviaC = (Enviar_Cliente) objectInputStream.readObject();
            miSocket.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return enviaC;
    }


}
