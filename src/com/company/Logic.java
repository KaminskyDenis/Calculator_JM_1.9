package com.company;

//import java.util.Arrays;
import java.util.Scanner;

public class Logic {
    private static char sign;
    private static int minNum = 1;
    private static int maxNum = 10;
    private static int[] arab = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static String[] rome = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static String num1;
    private static int romano;
    private static int result;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Calculator calc = new Calculator();
        RomanArabConvrt convrtRomArbConvrt = new RomanArabConvrt();
        String text = "";

        try {
            System.out.println("Введите арифметическую операцию:");
            num1 = reader.nextLine();
            text = num1.replaceAll("\\s",""); // удалить все пробелы из введенной строки
            String[] blocks = text.split("[+-/*]"); // поместить в строковый массив все переменные до знака и после любого из арифметических знаков
            romano = 0;
            sign = checkSign(text); // метод определения знака операции

            for (int i = 0; i <= 9; i++) {
                if (rome[i].equals(blocks[0])) {
                    blocks[0] = Integer.toString(arab[i]);
                    romano++;
                }
                if (rome[i].equals(blocks[1])) {
                    blocks[1] = Integer.toString(arab[i]);
                    romano++;
                }
            }
            if (romano == 1) {
                System.out.println("Используются одновременно разные системы счисления.");
                throw new IllegalArgumentException();
            }
            if ((isNumsInRange(Integer.parseInt(blocks[0]))) && (isNumsInRange(Integer.parseInt(blocks[1])))) { //метод проверка входят ли введенные цифры в заданный диапазон 1...9
                result = calc.calculate(Integer.parseInt(blocks[0]), Integer.parseInt(blocks[1]), sign); //выполнить арифметическую операцию в классе Calculator
            } else {
                System.out.println("Введенные числа должны быть только от 1 до 10 включительно."); //выдать ошибку, если введенные числа вне диапазона 1...9
                throw new IllegalArgumentException();
            }
            if (romano == 2) {
                convrtRomArbConvrt.arabicToRoman(result);
            } else {
                System.out.println(result);
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Неверный формат данных.");
        }
    }

    private static char checkSign(String text) { //определение знака арифметической операции
        if (text.indexOf("+") != -1) {
            return '+';
        } else if (text.indexOf("-") != -1) {
            return '-';
        } else if (text.indexOf("*") != -1) {
            return '*';
        } else if (text.indexOf("/") != -1) {
            return '/';
        } else {
            System.out.println("Арифметические операции только со знаками: /, *, +, -.");
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumsInRange(int number) { //проверка введенного числа >=1 и <=10
        return (number >= minNum && number <= maxNum);
    }
}
