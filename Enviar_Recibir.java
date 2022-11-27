import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Enviar_Recibir {
    public void Enviar_C_AS(Enviar_Cliente enviar, int puerto){
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
    public Enviar_Cliente Recibe_Enviar_C_AS (String IP, int puerto){
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
    public void Enviar_Cifrado(String ClaseCifrada, int puerto){
        ServerSocket socketconnection = null;
        try {
            socketconnection = new ServerSocket(puerto);
            Socket socketDatos = socketconnection.accept();
            OutputStream flujosalida = socketDatos.getOutputStream();
            PrintWriter salidaSocket = new PrintWriter(new OutputStreamWriter(flujosalida));
            salidaSocket.flush();
            socketDatos.close();
            socketconnection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String Recibir_Cifrado (String IP, int puerto){
        String cifrado = "";

        try {
            InetAddress maquinaAceptadora = InetAddress.getByName(IP);
            Socket socket = new Socket(maquinaAceptadora, puerto);
            InputStream flujoEntrada = socket.getInputStream();
            BufferedReader socketinput = new BufferedReader(new InputStreamReader(flujoEntrada));
            cifrado = socketinput.readLine();
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cifrado;
    }


}
