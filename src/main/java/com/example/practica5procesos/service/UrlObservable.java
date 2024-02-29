package com.example.practica5procesos.service;

import com.example.practica5procesos.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como sujeto observable dentro del patrón Observer, específicamente para manejar URLs.
 */
public class UrlObservable {
    private final List<String> urls = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Registra un observador que será notificado cuando se añada una nueva URL.
     *
     * @param observer El observador a añadir.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Añade una nueva URL a la lista y notifica a todos los observadores registrados.
     *
     * @param url La URL a añadir.
     */
    public void addUrl(String url) {
        urls.add(url);
        notifyAllObservers(url);
    }

    /**
     * Notifica a todos los observadores registrados sobre la adición de una nueva URL.
     * Cada observador recibirá la URL añadida como parte de su actualización.
     *
     * @param url La URL que ha sido añadida.
     */
    private void notifyAllObservers(String url) {
        for (Observer observer : observers) {
            observer.update(url);
        }
    }
}
