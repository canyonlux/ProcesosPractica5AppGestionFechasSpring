package com.example.practica5procesos;

import com.example.practica5procesos.observer.Observador;
import com.example.practica5procesos.service.UrlObservable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Punto de entrada para la lógica de negocio después de la inicialización de la aplicación Spring Boot.
     * Configura y ejecuta el bucle principal para procesar URLs de entrada.
     *
     * @param args Argumentos de la línea de comandos.
     */
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        UrlObservable urlService = new UrlObservable();
        Observador downloader = new Observador();

        // Registra el observador en el observable  para que reciba actualizaciones
        urlService.addObserver(downloader);

        while (true) {
            System.out.println("Ingrese una URL para descargar (o escriba 'salir' para terminar):");
            String input = scanner.nextLine();

            if ("salir".equalsIgnoreCase(input)) {
                break; // Termina el bucle y, por ende, la ejecución del programa
            }

            // Añade la URL al servicio observable, que notificará al observador para iniciar la descarga
            urlService.addUrl(input);
        }
    }
}
