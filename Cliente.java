

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
        SecretKey ks_c;
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Autentificador autentificador = new Autentificador();

        String cifrado_ticket, IP_AS, IP_TGS, cifrado_autentificador;
        int hora = generador.horalocal();

        enviar_cliente.setTS(hora);

        System.out.println("Introduzca el puerto de Servidor de Autentificacion: ");
        int puerto = sc.nextInt();

        //Enviar hora local

        enviar_recibir.Enviar_C_AS(enviar_cliente, puerto);

        System.out.println("Introduzca el ip del sercidor Autentificador");
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
    }
}

