import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Servidor_Autentificador {

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        Enviar_Recibir e_r = new Enviar_Recibir();
        Enviar_Cliente infoClien = new Enviar_Cliente();
        Scanner sc = new Scanner(System.in);
        Generador generador = new Generador();
        Ticket_AS ticket_as = new Ticket_AS();
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Enviar_AS enviar_as = new Enviar_AS();

        String Kc, Ktgs, adC, IP, TicketCifrado;
        int lifetime, puerto, idC, idTgs, ts2, ts1;
        SecretKey ks_c_tgs, ks_tgs;

        System.out.println("Ingrese el IP del cliente");
        IP = sc.nextLine();

        System.out.println("Ingrese el puerto en el que se trabajara");
        puerto = sc.nextInt();

        infoClien = e_r.Recibe_Autentificador(IP, puerto);

        ts1 = infoClien.getID_TGS();

        ks_c_tgs = generador.secretKey("14");
        idC = infoClien.getID_client();
        adC = IP;
        idTgs = infoClien.getID_TGS();
        ts2 = generador.horalocal();
        lifetime = 120000;

        if (ts1 == ts2){
            //Guardar datos en ticket
            ticket_as.setClave_c_tgs(ks_c_tgs);
            ticket_as.setIdC(idC);
            ticket_as.setIpC(adC);
            ticket_as.setIdTgs(idTgs);
            ticket_as.setTs2(ts2);
            ticket_as.setLifetime(lifetime);

            ks_tgs =generador.secretKey("12");
            //Ticket Cifrado
            TicketCifrado = cifrador_clases.Cifrado_Ticket_As(ticket_as, ks_tgs);

            //Guardar paquete para enviar a cifrado
            enviar_as.setKs_c_tgs(ks_c_tgs);
            enviar_as.setID_tgs(idTgs);
            enviar_as.setHora_AS(ts2);
            enviar_as.setLifetime_2(lifetime);
            enviar_as.setTicket_tgs_Cifrado(TicketCifrado);

            //

        }
        else{
            System.out.println("Hay un desfase de horas");
        }
    }
}
