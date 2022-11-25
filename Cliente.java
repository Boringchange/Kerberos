import java.util.Scanner;

public class Cliente {
    public static void main (String[] args){
        Enviar_Cliente enviar_cliente = new Enviar_Cliente();
        Generador generador = new Generador();
        Enviar_Recibir enviar_recibir = new Enviar_Recibir();
        Scanner sc = new Scanner(System.in);

        int hora = generador.horalocal();

        enviar_cliente.setTS(hora);

        System.out.println("Introduzca el puerto de Servidor de Autentificacion: ");
        int puerto = sc.nextInt();

        enviar_recibir.Enviar_AS_C(enviar_cliente, puerto);
    }
}
