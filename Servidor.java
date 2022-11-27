import org.ietf.jgss.GSSName;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ClassNotFoundException {
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Autentificador autentificador = new Autentificador();
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Scanner sc = new Scanner(System.in);
        Generador generador = new Generador();
        Ticket_V ticket_v = new Ticket_V();
        Enviar_Server enviar_server = new Enviar_Server();

        int TS_5_1;

        System.out.println("Introduzca la IP cliente: ");
        String IP_C = sc.nextLine();
        System.out.println("Introduzca el puerto: ");
        int Puerto = sc.nextInt();
        SecretKey Ks_V, Ks_C_V;


        enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C, Puerto);

        Ks_V = generador.secretKey("20");
        Ks_C_V = generador.secretKey("11");

        autentificador = cifrador_clases.Decifrador_Autentificador(enviar_cliente.getAutentificador_V(), Ks_V);
        ticket_v = cifrador_clases.Descifrado_Ticket_V(enviar_cliente.getTicket_V(), Ks_C_V);

        TS_5_1 = autentificador.getHora_3() + 1;

        enviar_server.setTS_5_1(TS_5_1);

        String enviar_server_cifrado = cifrador_clases.Cifrado_Enviar_server(enviar_server, Ks_C_V);

        enviar_recibir.Enviar_Cifrado(enviar_server_cifrado, Puerto);
        enviar_recibir.Enviar_Cifrado(enviar_server_cifrado, Puerto);
    }
}
