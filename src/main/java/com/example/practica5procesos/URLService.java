package com.example.practica5procesos;

import java.util.ArrayList;
import java.util.List;

public class URLService {
    private final List<String> urls = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addUrl(String url) {
        urls.add(url);
        notifyAllObservers(url);
    }

    private void notifyAllObservers(String url) {
        for (Observer observer : observers) {
            observer.update(url);
        }
    }
}
