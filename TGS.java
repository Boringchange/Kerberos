import java.util.Scanner;

public class TGS {
    public static void main(String[] args){
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);

        String IP_C;
        int puertoC;

        System.out.println("Ingrese el IP del cliente");
        IP_C = sc.nextLine();
        System.out.println("Ingrese el puerto donde se buscara al cliente: ");
        puertoC = sc.nextInt();

        //recibe los datos de cliente
        enviar_cliente = enviar_recibir.Recibe_Enviar_C_AS(IP_C,puertoC);
    }
}
