import java.io.*;
import java.net.*;

public class ClienteTCP {
    public static void main(String[] args) {
        final String servidorIP = "localhost"; // Cambia esto si el servidor se encuentra en otro equipo
        final int puerto = 12345; // Puerto en el que está escuchando el servidor
        try {
            Socket cliente = new Socket(servidorIP, puerto);

            // Configuración de los flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            // Enviar un número al servidor
            int numero = 5; // Cambia el número a tu elección
            salida.println(numero);

            // Leer la respuesta del servidor
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar conexión
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
