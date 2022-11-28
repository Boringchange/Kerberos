import org.ietf.jgss.GSSName;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.util.Scanner;

public class Servidor {

    public static int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja la opcion que desee:\n1.Reintentar Conexion a cliente\n2.Salir");
        int op = sc.nextInt();

        return op;
    }
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Autentificador autentificador = new Autentificador();
        Cifrador_Clases cifrador_clases = new Cifrador_Clases();
        Scanner sc = new Scanner(System.in);
        Generador generador = new Generador();
        Ticket_V ticket_v = new Ticket_V();
        Enviar_Server enviar_server = new Enviar_Server();
        int Puerto = 0;
        String IP_C = "";
        SecretKey Ks_V, Ks_C_V;
        int TS_5_1;
        boolean pasedirecto = false;
        int TimerIncial = 0;
        int TimerFinal = 0;

        boolean terminar = false;

        do{
            int op = Menu();
            switch (op){
                case 1:
                    if (pasedirecto == false){
                        System.out.println("Introduzca la IP cliente: ");
                        IP_C = sc.nextLine();
                        System.out.println("Introduzca el puerto: ");
                        Puerto = sc.nextInt();


                        enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C, Puerto);

                        Ks_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b320");
                        Ks_C_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b311");

                        autentificador = cifrador_clases.Decifrador_Autentificador(enviar_cliente.getAutentificador_V(), Ks_V);
                        ticket_v = cifrador_clases.Descifrado_Ticket_V(enviar_cliente.getTicket_V(), Ks_C_V);

                        TS_5_1 = autentificador.getHora_3() + 1;
                        pasedirecto = true;

                        TimerIncial = generador.minutolocal();

                        enviar_server.setTS_5_1(TS_5_1);
                        enviar_server.setPasedirecto(pasedirecto);

                        String enviar_server_cifrado = cifrador_clases.Cifrado_Enviar_server(enviar_server, Ks_C_V);

                        if (ticket_v.getIP_C().equals(autentificador.getIP_C())){
                            enviar_recibir.Enviar_Cifrado(enviar_server_cifrado, Puerto);
                        }
                        else{
                            System.out.println("Tas mal mijo");
                        }
                    }
                    else{
                        TimerFinal = generador.minutolocal();

                        int minutosPasados = TimerFinal - TimerIncial;

                        if (minutosPasados >= 2){
                            pasedirecto = false;
                        }

                        System.out.println("Introduzca la IP cliente: ");
                        IP_C = sc.nextLine();
                        System.out.println("Introduzca el puerto: ");
                        Puerto = sc.nextInt();

                        enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C, Puerto);

                        Ks_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b320");
                        Ks_C_V = generador.secretKey("aeda17fa60187851b74f9928664dd08b311");

                        autentificador = cifrador_clases.Decifrador_Autentificador(enviar_cliente.getAutentificador_V(), Ks_V);
                        ticket_v = cifrador_clases.Descifrado_Ticket_V(enviar_cliente.getTicket_V(), Ks_C_V);

                        TS_5_1 = autentificador.getHora_3() + 1;

                        enviar_server.setTS_5_1(TS_5_1);

                        String enviar_server_cifrado = cifrador_clases.Cifrado_Enviar_server(enviar_server, Ks_C_V);

                        if (ticket_v.getIP_C().equals(autentificador.getIP_C())){
                            enviar_recibir.Enviar_Cifrado(enviar_server_cifrado, Puerto);
                        }
                        else{
                            System.out.println("Tas mal mijo");
                        }
                    }
                    break;
                case 2:
                    terminar = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
        while(terminar == false);
    }
}
