package oop.WorkingWithAbstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());

        rhombusTopPart(row);
        rhombusBottomPart(row);
    }

    private static void rhombusBottomPart(int row) {
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= row - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void rhombusTopPart(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
