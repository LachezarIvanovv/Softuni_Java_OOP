package Exam.examPrep.Matrices;

import java.util.Scanner;

public class PawnWars {
    private static int whiteRow = 0;
    private static int whiteCol = 0;
    private static int blackRow = 0;
    private static int blackCol = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i <= 7; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("w")) {
                whiteRow = i;
                whiteCol = line.indexOf("w");
            } else if (line.contains("b")){
                blackRow = i;
                blackCol = line.indexOf("b");
            }
        }
    }
}
