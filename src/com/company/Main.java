package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner scanner = new Scanner(System.in);
       Calculate calc = new Calculate();
        while (true){
            String str = scanner.nextLine();
            calc.calculate(str);
        }
    }
}