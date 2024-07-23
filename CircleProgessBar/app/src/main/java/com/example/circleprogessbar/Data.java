package com.example.circleprogessbar;

public class Data {
    private String id, timestamp;
    private int data_temperature, data_humidity;
    public Data() {
        this.id = id;
        this.data_temperature = data_temperature;
        this.data_humidity = data_humidity;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getData_temperature() {
        return data_temperature;
    }

    public void setData_temperature(int data_temperature) {
        this.data_temperature = data_temperature;
    }

    public int getData_humidity() {
        return data_humidity;
    }

    public void setData_humidity(int data_humidity) {
        this.data_humidity = data_humidity;
    }
}

