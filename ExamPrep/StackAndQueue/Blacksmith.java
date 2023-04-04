package Exam.examPrep.StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        Map<String, Integer> forgedSwords = new TreeMap<>();
        int counter = 0;

        while(!steel.isEmpty() && !carbon.isEmpty()){
            int lastSteel = steel.poll();
            int lastCarbon = carbon.pop();
            int sum = lastCarbon + lastSteel;

            String sword;
            switch (sum){
                case 70:
                    sword = "Gladius";
                    break;
                case 80:
                    sword = "Shamshir";
                    break;
                case 90:
                    sword = "Katana";
                    break;
                case 110:
                    sword = "Sabre";
                    break;
                default:
                    sword = null;
                    break;
            }
            if(sword != null){
                counter++;
                forgedSwords.putIfAbsent(sword, 0);
                int newValue = forgedSwords.get(sword) + 1;
                forgedSwords.put(sword, newValue);
            } else {
                carbon.push(lastCarbon + 5);
            }
        }

        if(counter > 0){
            System.out.printf("You have forged %d swords.%n", counter);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        String remainingSteel = steel.isEmpty() ? "none" : steel.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Steel left: " + remainingSteel);

        String remainingCarbon = carbon.isEmpty() ? "none" : carbon.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Carbon left: " + remainingCarbon);

        forgedSwords.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
