package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter some String: ");
        String src = reader.readLine();
        while (true) {
            System.out.println("enter 1 to reverse String \n" +
                    "enter 2 to reverse Substring in String \n" +
                    "enter 3 to reverse String by range \n" +
                    "enter 4 to exit:");
            int position = Integer.parseInt(reader.readLine());
            if (position < 1 || position > 4) {
                System.out.println("Incorrect input! Try again.");
                continue;
            }
            String result = "";
            switch (position) {
                case 1:
                    result = MyOwnString.reverse(src);
                    break;
                case 2:
                    System.out.print("Enter substring for \"" + src + "\": ");
                    String sub = reader.readLine();
                    result = MyOwnString.reverse(src, sub);
                    break;
                case 3:
                    System.out.println("Enter range for \"" + src + "\": ");
                    System.out.print("First index: ");
                    int firstIndex = Integer.parseInt(reader.readLine());
                    System.out.print("Last index: ");
                    int lastIndex = Integer.parseInt(reader.readLine());
                    result = MyOwnString.reverse(src, firstIndex, lastIndex);
                    break;
                case 4:
                    System.exit(0);
            }
            System.out.println("Original:");
            System.out.println(src);
            System.out.println("Result:");
            System.out.println(result);
        }
    }
}