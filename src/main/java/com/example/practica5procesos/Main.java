package com.example.practica5procesos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final List<String> urlList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        URLService urlService = new URLService();
        Downloader downloader = new Downloader();

        urlService.addObserver(downloader);

        while (true) {
            System.out.println("Ingrese una URL para descargar (o escriba 'salir' para terminar):");
            String input = scanner.nextLine();

            if ("salir".equalsIgnoreCase(input)) {
                break;
            }

            urlService.addUrl(input);
        }
    }

}
