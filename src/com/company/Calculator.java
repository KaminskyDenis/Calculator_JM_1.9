package com.company;

import java.util.Scanner;

public class Calculator {
    private static Scanner reader = new Scanner(System.in);
    private static int result;

    public static void main(String[] args){}

    public int calculate(int num1, int num2, char sign) {
        switch (sign) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }

}
