import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TGS {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, IOException, InvalidKeyException, ClassNotFoundException {
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);
        Generador generador = new Generador();
        Ticket_V ticket_v = new Ticket_V();
        Ticket_AS ticket_as = new Ticket_AS();
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Enviar_TGS enviar_tgs = new Enviar_TGS();
        Autentificador autentificador = new Autentificador();

        String IP_C, Ticket_V_Cifrado, Enviar_TGS_Cifrado;
        int puertoC, TS_4;
        SecretKey Ks_c_tgs, Ks_C_V, Ks_tgs, Ks_V;
        boolean terminar = false;
        do{
            System.out.println("Ingrese el IP del cliente");
            IP_C = sc.nextLine();
            System.out.println("Ingrese el puerto donde se buscara al cliente: ");
            puertoC = sc.nextInt();

            Ks_c_tgs = generador.secretKey("aeda17fa60187851b74f9928664dd08b314");

            //recibe los datos de cliente
            Ks_tgs = generador.secretKey("aeda17fa60187851b74f9928664dd08b312");

            enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C,puertoC);
            ticket_as = cifrador_clases.Descifrado_Ticket_As(enviar_cliente.getTicket_AS_Cifrado(), Ks_tgs);
            autentificador = cifrador_clases.Decifrador_Autentificador(enviar_cliente.getAutentificacion(), Ks_c_tgs);

            if (ticket_as.getIpC().equals(autentificador.getIP_C())){
                //Prepara archivos para enviar
                Ks_C_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b311");
                TS_4 = generador.horalocal();

                //Generador ticket servidor
                ticket_v.setKs_C_V(Ks_C_V);
                ticket_v.setIP_C(ticket_as.getIpC());
                ticket_v.setTS_4(TS_4);
                ticket_v.setTimelife(120000);

                //cifrar ticket
                Ks_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b320");
                Ticket_V_Cifrado = cifrador_clases.Cifrado_Ticket_V(ticket_v, Ks_V);

                //Guardar cosas para enviar
                enviar_tgs.setKs_C_V(Ks_C_V);
                enviar_tgs.setTS_4(TS_4);
                enviar_tgs.setTicket_v_Cifrado(Ticket_V_Cifrado);

                //Cifrar clase
                Enviar_TGS_Cifrado = cifrador_clases.Cifrado_Enviar_TGS(enviar_tgs, Ks_c_tgs);

                //Enviar cifrado
                enviar_recibir.Enviar_Cifrado(Enviar_TGS_Cifrado, puertoC);
            }
            System.out.println("bai");
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (terminar == false);
    }
}
