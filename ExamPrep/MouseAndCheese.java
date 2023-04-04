package oop.ExamPrep;

import java.util.Scanner;

public class MouseAndCheese {
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            // Mutators:
            // up -> { -1, 0 }
            // down -> { 1, 0 }
            // left -> { 0, -1 }
            // right -> { 0, 1 }


            if (input.equals("up")) {
                moveMouse(matrix, -1, 0);
            } else if (input.equals("down")) {
                moveMouse(matrix, 1, 0);
            } else if (input.equals("left")) {
                moveMouse(matrix, 0, -1);
            } else if (input.equals("right")) {
                moveMouse(matrix, 0, 1);
            }

            if (!mouseIsInField) {
                break;
            }

            input = scanner.nextLine();
        }

        if(!mouseIsInField){
            System.out.println("Where is the mouse?");
        }

        if(eatenCheese >= 5){
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - eatenCheese) + " cheeses more.");
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

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if(matrix[nextRow][nextCol] == 'c'){
            eatenCheese++;
        } else if (matrix[nextRow][nextCol] == 'B'){
            isBonusHit = true;
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if(isBonusHit){
            moveMouse(matrix,rowMutator,colMutator);
        }

    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[nextRow].length;
    }
}


