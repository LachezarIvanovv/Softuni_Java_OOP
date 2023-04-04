package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    private static int robberRow = 0;
    private static int robberCol = 0;
    private static int robbedHouseRow = 0;
    private static int robbedHouseCol = 0;
    private static int robbedMoney = 0;
    private static int totalRobbedMoney = 0;
    private static boolean foundPolice = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);
                if (currentChar == 'D') {
                    robberRow = row;
                    robberCol = col;
                }
                matrix[row][col] = currentChar;
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String commandName = commands[i];
            switch (commandName) {
                case "up":
                    moveRobber(matrix, -1, 0);
                    break;
                case "down":
                    moveRobber(matrix, 1, 0);
                    break;
                case "right":
                    moveRobber(matrix, 0, 1);
                    break;
                case "left":
                    moveRobber(matrix, 0, -1);
                    break;
            }
            if(foundPolice){
                break;
            }
        }
        if(!foundPolice){
            System.out.println("Your last theft has finished successfully with " + totalRobbedMoney + "$ in your pocket.");
        } else {
            System.out.println("You got caught with " + totalRobbedMoney + "$, and you are going to jail.");
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void moveRobber(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = robberRow + rowMutator;
        int nextCol = robberCol + colMutator;

        if(!isInBounds(matrix, nextRow, nextCol)){
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }

        if(matrix[nextRow][nextCol] == '$'){
            robbedHouseRow = nextRow;
            robbedHouseCol = nextCol;
            robbedMoney = robbedHouseRow * robbedHouseCol;
            totalRobbedMoney += robbedMoney;
            matrix[nextRow][nextCol] = '+';
            System.out.println("You successfully stole " + robbedMoney + "$.");
        } else if (matrix[nextRow][nextCol] == 'P'){
            foundPolice = true;
            matrix[nextRow][nextCol] = '#';
            matrix[robberRow][robberCol] = '+';
            return;
        }

        matrix[robberRow][robberCol] = '+';
        matrix[nextRow][nextCol] = 'D';
        robberRow = nextRow;
        robberCol = nextCol;

    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 &&  row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
