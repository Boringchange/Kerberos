

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cliente {
    public static void main (String[] args) throws InterruptedException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ClassNotFoundException {
        //Puerto de cliente

        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Generador generador = new Generador();
        Enviar_AS enviar_as = new Enviar_AS();
        SecretKey ks_c, Ks_C_TGS;
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Autentificador autentificador = new Autentificador();
        Enviar_TGS enviar_tgs = new Enviar_TGS();
        Enviar_Server enviar_server = new Enviar_Server();

        String cifrado_ticket, IP_AS, IP_TGS, cifrado_autentificador, cifrado_Enviar_TGS;
        int hora = generador.horalocal();

        enviar_cliente.setTS(hora);

        System.out.println("Introduzca el puerto de Servidor de Autentificacion: ");
        int puerto = sc.nextInt();

        //Enviar hora local

        enviar_recibir.Enviar_C_AS(enviar_cliente, puerto);

        System.out.println("Introduzca el ip del servidor Autentificador");
        IP_AS = sc.nextLine();

        //Recibe datos de AC
        Thread.sleep(500);

        cifrado_ticket = enviar_recibir.Recibir_Cifrado(IP_AS, puerto);

        //Descifra la clase
        ks_c = generador.secretKey("10");

        enviar_as = cifrador_clases.Decifrador_Enviar_AS(cifrado_ticket, ks_c);

        autentificador.setID_C(enviar_cliente.getID_client());
        autentificador.setIP_C(args[0]);
        autentificador.setHora_3(generador.horalocal());

        //Generador autentificador
        cifrado_autentificador = cifrador_clases.Cifrado_Autentificador(autentificador, enviar_as.getKs_c_tgs());

        //Guarda datos
        enviar_cliente.setTicket_AS_Cifrado(enviar_as.getTicket_tgs_Cifrado());
        enviar_cliente.setAutentificacion(cifrado_autentificador);

        System.out.println("Introduzca el puerto que se usara para la conexion Servidor generador de tickets");
        int puertoTGS = sc.nextInt();

        //enviar
        enviar_recibir.Enviar_C_AS(enviar_cliente, puertoTGS);

        System.out.println("Introduzca el IP del servidor TGS");
        IP_TGS = sc.nextLine();
        //Va a recibir datos de TGS
        cifrado_Enviar_TGS = enviar_recibir.Recibir_Cifrado(IP_TGS, puertoTGS);

        Ks_C_TGS = generador.secretKey("14");

        //Enviar a Server

        enviar_tgs = cifrador_clases.Descifrado_Enviar_TGS(cifrado_Enviar_TGS, Ks_C_TGS);

        enviar_cliente.setTicket_V(enviar_tgs.getTicket_v_Cifrado());

        autentificador.setIP_C(args[0]);
        int TS_5 = generador.horalocal();
        autentificador.setHora_3(TS_5);
        String autentificador_cifrado = cifrador_clases.Cifrado_Autentificador(autentificador, enviar_tgs.getKs_c_tgs());

        enviar_cliente.setAutentificador_V(autentificador_cifrado);
        enviar_cliente.setTicket_V(enviar_tgs.getTicket_v_Cifrado());

        System.out.println("Introduzca el puerto del servidor");
        int puertoV =  sc.nextInt();

        enviar_recibir.Enviar_C_AS(enviar_cliente, puertoV);

        System.out.println("Introduca el IP del server: ");
        String IP_S = sc.nextLine();

        String Enviar_servercifrado;
        Enviar_servercifrado = enviar_recibir.Recibir_Cifrado(IP_S, puertoV);

        enviar_server = cifrador_clases.Descifrado_Enviar_server(Enviar_servercifrado, enviar_tgs.getKs_c_tgs());

        System.out.println(enviar_server.getTS_5_1());
    }
}

