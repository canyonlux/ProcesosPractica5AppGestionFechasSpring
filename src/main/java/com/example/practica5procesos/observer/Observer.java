package com.example.practica5procesos.observer;

/**
 * La interfaz Observer define el método de notificación que deben implementar los observadores.
 * Es parte del patrón Observer, permitiendo a los objetos observadores ser notificados de cambios.
 */
public interface Observer {
    /**
     * Método llamado por el objeto observable para notificar a este observador acerca de un evento,
     * en este caso, la adición de una nueva URL.
     *
     * @param url La URL que ha sido añadida y sobre la cual el observador puede necesitar actuar.
     */
    void update(String url);
}
