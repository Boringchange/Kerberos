import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        BdArray bdArray = new BdArray();

        String adC, IPC, TicketCifrado, Enviar_ASCifrada;
        int lifetime, puertoC, idC, idTgs, ts2, ts1, idclibd = 0;
        SecretKey ks_c_tgs, ks_tgs, ks_c;
        boolean terminar = false, existe = false;
        String[] adc = bdArray.getAdc();
        int[] idcli = bdArray.getIdcli();


        do {
            System.out.println("Ingrese el IP del cliente");
            IPC = sc.next();

            System.out.println("Ingrese el puerto en el que se trabajara");
            puertoC = sc.nextInt();

            infoClien = e_r.Recibe_Enviar_C_AS(IPC, puertoC);


            idTgs = infoClien.getID_TGS();
            idC = infoClien.getID_client();
            ts1 = infoClien.getTS();
            ks_c_tgs = generador.secretKey("aeda17fa60187851b74f9928664dd08b314");
            adC = IPC;
            ts2 = generador.horalocal();
            lifetime = 2000;

            for(int i = 0; i < idcli.length;i++){
                idclibd = idcli[i];
                if (idclibd == infoClien.getID_client()){
                    existe = true;
                }
            }

            if (existe == true){
                if (ts1 == ts2){
                    //Guardar datos en ticket
                    ticket_as.setClave_c_tgs(ks_c_tgs);
                    ticket_as.setIdC(idC);
                    ticket_as.setIpC(adC);
                    ticket_as.setIdTgs(idTgs);
                    ticket_as.setTs2(ts2);
                    ticket_as.setLifetime(lifetime);

                    ks_tgs =generador.secretKey("aeda17fa60187851b74f9928664dd08b312");

                    //Ticket Cifrado
                    TicketCifrado = cifrador_clases.Cifrado_Ticket_As(ticket_as, ks_tgs);

                    //Guardar paquete para enviar a cifrado
                    enviar_as.setKs_c_tgs(ks_c_tgs);
                    enviar_as.setID_tgs(idTgs);
                    enviar_as.setHora_AS(ts2);
                    enviar_as.setLifetime_2(lifetime);
                    enviar_as.setTicket_tgs_Cifrado(TicketCifrado);

                    ks_c = generador.secretKey("aeda17fa60187851b74f9928664dd08b312");

                    Enviar_ASCifrada = cifrador_clases.Cifrado_Enviar_AS(enviar_as, ks_c);
                    //Enviar clase cifrada
                    e_r.Enviar_Cifrado(Enviar_ASCifrada, puertoC);
                }
                else{
                    System.out.println("Hay un desfase de horas");
                }
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println("El usuario no existe");
            }
        }
        while(terminar == false);
    }
}
