package oop.WorkingWithAbstraction.exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediData = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilCurrentRow = evilData[0];
            int evilCurrentCol = evilData[1];

            while (evilCurrentRow >= 0 && evilCurrentCol >= 0) {
                if (isValidIndex(galaxy, evilCurrentRow, evilCurrentCol)) {
                    galaxy[evilCurrentRow][evilCurrentCol] = 0;
                }
                evilCurrentRow--;
                evilCurrentCol--;
            }

            int jediCurrentRow = jediData[0];
            int jediCurrentCol = jediData[1];

            while (jediCurrentRow >= 0 && jediCurrentCol < galaxy[1].length) {
                if (jediCurrentRow < galaxy.length && jediCurrentCol >= 0 && jediCurrentCol < galaxy[0].length) {
                    sum += galaxy[jediCurrentRow][jediCurrentCol];
                }

                jediCurrentCol++;
                jediCurrentRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static boolean isValidIndex(int[][] galaxy, int evilCurrentRow, int evilCurrentCol) {
        return evilCurrentRow < galaxy.length && evilCurrentCol < galaxy[0].length;
    }
}
