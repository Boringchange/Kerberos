import javax.crypto.SecretKey;
import java.util.Scanner;

public class TGS {
    public static void main(String[] args){
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);
        Generador generador = new Generador();

        String IP_C;
        int puertoC;
        SecretKey Ks_c_tgs;

        System.out.println("Ingrese el IP del cliente");
        IP_C = sc.nextLine();
        System.out.println("Ingrese el puerto donde se buscara al cliente: ");
        puertoC = sc.nextInt();

        Ks_c_tgs = generador.secretKey("14");

        //recibe los datos de cliente
        enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C,puertoC);

        //Prepara archivos para enviar


    }
}
