package com.example.practica5procesos.observer;

import com.example.practica5procesos.observer.Observer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Clase Observador que implementa la interfaz Observer y se encarga de la descarga de archivos desde URLs especificadas.
 * Utiliza un servicio de ejecutor para manejar las descargas de manera asincrónica.
 */
public class Observador implements Observer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * Método invocado cuando el Observable notifica a este Observador acerca de una nueva URL.
     * Inicia la descarga del archivo de manera asincrónica utilizando un ExecutorService.
     *
     * @param urlString La URL del archivo a descargar.
     */
    @Override
    public void update(String urlString) {
        executorService.submit(() -> {
            try {
                downloadFile(urlString);
                // Se elimina cualquier impresión para cumplir con los requerimientos
            } catch (IOException e) {
                // Considera registrar los errores en un log si es necesario, en lugar de imprimirlos en consola
            }
        });
    }

    /**
     * Descarga el archivo de la URL especificada y lo guarda localmente.
     *
     * @param urlString La URL del archivo a descargar.
     * @throws IOException Si ocurre un error durante la descarga o el guardado del archivo.
     */
    private void downloadFile(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String fileName = extractFileName(urlString);

        try (InputStream inputStream = connection.getInputStream();
             OutputStream outputStream = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            // El mensaje de descarga completada se elimina para cumplir con los requerimientos
        } finally {
            connection.disconnect();
        }
    }
    /**
     * Extrae el nombre del archivo de la URL. Si la URL no termina con un nombre de archivo,
     * genera un nombre utilizando un timestamp para evitar colisiones.
     *
     * @param urlString La URL del archivo a descargar.
     * @return El nombre del archivo extraído o generado.
     */
    private String extractFileName(String urlString) {
        String defaultFileName = "descarga";
        String fileName = urlString.substring(urlString.lastIndexOf('/') + 1);

        if (fileName.isEmpty() || fileName.endsWith("/")) {

            return defaultFileName + "_" + System.currentTimeMillis();
        }
        return fileName;
    }
}
