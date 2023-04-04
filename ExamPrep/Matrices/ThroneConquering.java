package Exam.examPrep.Matrices;

import java.util.Scanner;

public class ThroneConquering {
    private static int rowMatrix = 0;
    private static int parisRow = 0;
    private static int parisCol = 0;
    private static  int energyParis = 0;
    private static String command = null;
    private static char[][] matrix = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energyParis = Integer.parseInt(scanner.nextLine());
        rowMatrix = Integer.parseInt(scanner.nextLine());

        matrix = new char[rowMatrix][rowMatrix];
        for (int i = 0; i < rowMatrix; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();

            if(input.contains("P")){
                parisRow = i;
                parisCol = input.indexOf("P");
            }
        }

        boolean abductedHelen = false;

        while (energyParis > 0){
            String[] tokens = scanner.nextLine().split(" ");
            command = tokens[0];

            matrix[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[2])] = 'S';
            matrix[parisRow][parisCol] = '-';
            move();

            if(matrix[parisRow][parisCol] == 'H'){
                abductedHelen = true;
                matrix[parisRow][parisCol] = '-';
                break;
            }

            if(matrix[parisRow][parisCol] == 'S'){
                energyParis -= 2;
            }

            matrix[parisRow][parisCol] = 'P';
        }

        if(energyParis <= 0){
            if(!abductedHelen){
                matrix[parisRow][parisCol] = 'X';
            }
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }

        if(abductedHelen){
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energyParis);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void move() {
        energyParis--;

        switch (command){
            case "up":
                if(SpartanInMatrix(-1, 0, rowMatrix)){
                    parisRow--;
                }
                break;
            case "down":
                if(SpartanInMatrix(1, 0, rowMatrix)){
                    parisRow++;
                }
                break;
            case "left":
                if(SpartanInMatrix(0, -1, rowMatrix)){
                    parisCol--;
                }
                break;
            case "right":
                if(SpartanInMatrix(0, 1, rowMatrix)){
                    parisCol++;
                }
                break;
        }
    }

    private static boolean SpartanInMatrix(int rowMutator, int colMutator, int rowMatrix) {
        return parisRow + rowMutator >= 0 && parisRow + rowMutator < rowMatrix
                && parisCol + colMutator >= 0 && parisCol + colMutator < rowMatrix;
    }
}
