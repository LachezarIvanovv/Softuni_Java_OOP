package Exam.examPrep.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> male = new ArrayDeque<>();//stack
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(male::push);

        ArrayDeque<Integer> female = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));//queue


        int matchesCount = 0;

        while(!female.isEmpty() && !male.isEmpty()){

            if(male.peek() <= 0){
                male.poll();
                continue;
            }

            if(female.peek() <= 0){
                female.pop();
                continue;
            }

            if(male.peek() % 25 == 0){
                male.poll();
                male.poll();
                continue;
            }

            if(female.peek() % 25 == 0){
                female.pop();
                female.pop();
                continue;
            }

            int lastMale = male.poll();
            int lastFemale = female.pop();

            if(lastMale == lastFemale){
                matchesCount++;
            } else {
                male.push(lastMale - 2);
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);

        String remainingMales = male.isEmpty() ? "none" : male.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Males left: " + remainingMales);

        String remainingFemales = female.isEmpty() ? "none" : female.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Females left: " + remainingFemales);
    }
}
