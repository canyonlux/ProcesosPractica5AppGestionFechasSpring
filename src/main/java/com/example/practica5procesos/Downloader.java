package com.example.practica5procesos;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

public class Downloader implements Observer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override //Metodo para actualizar el estado del archivo
    public void update(String urlString) {
        Future<?> future = executorService.submit(() -> {
            try {
                downloadFile(urlString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
//Metodo para descargar el archivo
    private void downloadFile(String urlString) throws IOException { //Metodo para descargar el archivo
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        String fileName = extractFileName(urlString);

        try (InputStream inputStream = connection.getInputStream()) {
            try (OutputStream outputStream = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("Archivo descargado: " + fileName);
            }
        } finally {
            connection.disconnect();
        }
    }
 //Metodo para extraer el nombre del archivo
    private String extractFileName(String urlString) {
        String defaultFileName = "descarga";
        String fileName = urlString.substring(urlString.lastIndexOf('/') + 1);

        if (fileName.isEmpty() || fileName.endsWith("/")) {
            // Generar un nombre de archivo si la URL no termina con uno
            // Por ejemplo, puedes usar un contador o un timestamp
            return defaultFileName + "_" + System.currentTimeMillis();
        }
        return fileName;
    }


}
