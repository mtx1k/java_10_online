package ua.com.alevel;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComputerCrudView {
    private Computer[] computers = new Computer[10];
    private int counterComputers = 0;

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            mainMenu();
            String position = reader.readLine();
            if(position.equals("1") || position.equals("2") || position.equals("3") || position.equals("4")) {
                crud(position, reader);
            } else if(position.equals("5")) {
                System.out.println("Have a good day :)");
                System.exit(0);
            } else {
                System.out.println("Incorrect input! Try again.");
            }
        }
    }

    private void mainMenu() {
        System.out.println("If you want to CREATE Computer, please enter 1");
        System.out.println("If you want to SEE all Computers, please enter 2");
        System.out.println("If you want to Update some Computer, please enter 3");
        System.out.println("If you want to DELETE some Computer, please enter 4");
        System.out.println("If you want to EXIT Computer, please enter 5");
        System.out.print("Please make your choose: ");
    }
    private void updateMenu() {
        System.out.println("Enter 1 to update Serial Number");
        System.out.println("Enter 2 to update Brand");
        System.out.println("Enter 3 to update Model");
        System.out.println("Enter 4 to EXIT in Main Menu");
        System.out.print("Please make your choose: ");
    }

    private void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> readAll();
            case "3" -> update(reader);
            case "4" -> delete(reader);
        }
    }

    private void  create (BufferedReader reader) throws IOException {
        System.out.print("Brand: ");
        String brand = reader.readLine();
        System.out.print("Model: ");
        String model = reader.readLine();
        Computer newComputer = new Computer(brand, model);
        counterComputers++;
        if(counterComputers >= computers.length) {
            computers = expandComputersStorage(computers);
        }
        computers[counterComputers - 1] = newComputer;
    }

    private Computer[] expandComputersStorage(Computer[] computers) {
        Computer[] newComputers = new Computer[computers.length + 10];
        for (int i = 0; i < computers.length; i++) {
            newComputers[i] = computers[i];
        }
        return newComputers;
    }

    private void readAll() {
        for (int i = 0; i < computers.length; i++) {
            if(computers[i] == null) {
                break;
            }
            System.out.println((i + 1) + ". "
                    + "SerialNumber: " + computers[i].getSerialNumber()
                    + " Brand: "  + computers[i].getBrand()
                    + " Model: " + computers[i].getModel());
        }
    }

    private void update(BufferedReader reader) throws IOException {
        if(counterComputers == 0) {
            System.out.println("There are no computers to update. Back to Main Menu.");
            return;
        }
        int number = getNumberComputer(reader);
        if(number == 0) {
            return;
        }
        int operation = getOperationType(reader);
        if(operation == 4) {
            return;
        }
        System.out.print("Enter new Value: ");
        String newValue = reader.readLine();
        switch (operation) {
            case 1 -> computers[number - 1].setSerialNumber(newValue);
            case 2 -> computers[number - 1].setBrand(newValue);
            case 3 -> computers[number - 1].setModel(newValue);
        }
        System.out.println("Data updated. Return to Main Menu.");
    }

    private int getOperationType(BufferedReader reader) throws IOException {
        while (true) {
            updateMenu();
            String position = reader.readLine();
            int operationType = Integer.parseInt(position);
            if(operationType < 1 || operationType > 4) {
                System.out.println("Incorrect input! Try again.");
                continue;
            } else {
                return operationType;
            }
        }
    }

    private int getNumberComputer(BufferedReader reader) throws IOException {
        while(true) {
            System.out.print("Enter number of computer (0 to exit): ");
            String number = reader.readLine();
            int choose = Integer.parseInt(number);
            if(choose == 0) {
                return 0;
            } else if(choose < 0 || choose > counterComputers) {
                System.out.println("Incorrect input! Try again.");
                continue;
            } else {
                return choose;
            }
        }
    }

    private void delete(BufferedReader reader) throws IOException {
        if(counterComputers == 0) {
            System.out.println("There are no computers to delete. Back to Main Menu.");
            return;
        }
        int number = getNumberComputer(reader);
        Computer[] newComputers = new Computer[computers.length];
        for (int i = 0, j = 0; i < counterComputers; i++) {
            if(i == number - 1) {
                continue;
            } else {
                newComputers[j++] = computers[i];
            }
        }
        computers = newComputers;
        counterComputers--;
        System.out.println("Successfully deleted.");
    }
}