package com.javarush.task.task39.task3913;

import java.util.Date;

public class Log {

    private String ip;
    private String user;
    private Date date;
    private Event event;
    private int number;
    private Status status;

    public Log(String ip, String user, Date date, Event event, Status status, int number) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.number = number;
        this.status = status;
    }

    public Log(String ip, String user, Date date, Event event, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.status = status;
        this.number=0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
