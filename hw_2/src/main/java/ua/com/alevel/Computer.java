package ua.com.alevel;

import java.util.Random;

public class Computer {
    private String serialNumber;
    private String brand;
    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = generateSerialNumber();
    }

    private String generateSerialNumber() {
        return Integer.toString(Math.abs(new Random().nextInt() % 100000));
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
