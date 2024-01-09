package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String str = main.generateString();
        // 1
        System.out.println("*********1*********");
        System.out.println(main.sumAllNumbersInString(str));        //12a3 = 12 + 3
        System.out.println(main.sumAllSimpleNumbersInString(str));  //12a3 = 1 + 2 + 3

        // 2
        System.out.println("*********2*********");
        main.countCharsInString(str);

        // 3
        System.out.println("*********3*********");
        int num = main.getNumberLesson();
        int[] test = main.getLessonTimeByNumber(num);
        System.out.println(test[0] + ":" + test[1]);

    }

    public int getNumberLesson() throws IOException {
        int result = 0;
        while (true) {
            System.out.print("Set Lesson Nummer (1-10): ");
            result = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println();
            if(result <= 0 || result > 10) {
                System.out.println("Incorrect nummer! Try again!");
            }
            else {
                break;
            }
        }
        return result;
    }

    private void countCharsInString(String str) {
        String sortedString = sortString(str);
        String resultString = removeNumbers(sortedString);
        for (int i = 0, k = 0; i < resultString.length(); i++) {
            int count = 1;
            for (int j = i + 1; j < resultString.length(); j++) {
                if(resultString.charAt(i) == resultString.charAt(j)) {
                    count++;
                    i = j;
                    continue;
                }
                break;
            }
            System.out.println(++k + ". " + resultString.charAt(i) + " - " + count);
        }
    }

    public int sumAllNumbersInString(String str) throws IOException {
        int sum = 0;
        char[] stringToChar = new char[str.length()];
        for (int i = 0; i < stringToChar.length; i++) {
            int temp = 0;
            for (int j = i; j < str.length(); j++) {
                if(str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                    temp = temp * 10 + (str.charAt(j) - 48);
                    if(j == str.length() - 1) {
                        i = j;
                        sum += temp;
                    }
                } else {
                    i = j;
                    sum += temp;
                    break;
                }
            }
        }
        return sum;
    }
    public int sumAllSimpleNumbersInString(String str) {
        String resultString = removeLetters(str);
        int sum = 0;
        for (int i = 0; i < resultString.length(); i++) {
            sum = sum + (resultString.charAt(i) - 48);
        }
        return sum;
    }
    public String sortString(String str) {
        char[] tempArr = str.toCharArray();
        Arrays.sort(tempArr);
        return new String(tempArr);
    }
    public String generateString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
    public int[] getLessonTimeByNumber(int nummer) {
        int[] result = new int[2];
        int temp5 = nummer / 2;
        int temp15 = nummer - nummer / 2 - 1;
        int tempResult = (nummer * 45) + (temp5 * 5) + (temp15 * 15);
        result[0] = tempResult / 60 + 9;
        result[1] = tempResult % 60;
        return result;
    }
    private String removeLetters(String str) {
        return str.replaceAll("[\\D]", "");
    }
    private String removeNumbers(String str) {
        return str.replaceAll("[^a-zA-Zа-яА-Я]", "");
    }
}