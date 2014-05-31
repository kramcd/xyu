package ru.tusur.service;

public interface Notifier {

    public void sendNotification(String from, String to, String topic, String body);
}
