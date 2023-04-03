package InterfacesAndAbstraction.exercise.BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<Birthable> creatures = new ArrayList<>();

        while(!"End".equals(input)){
            String[] inputParts = input.split("\\s+");
            String type = inputParts[0];

            switch (type){
                case "Citizen":
                    String citizenName = inputParts[1];
                    int citizenAge = Integer.parseInt(inputParts[2]);
                    String citizenId = inputParts[3];
                    String citizenBirthDate = inputParts[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                    creatures.add(citizen);
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBirthDate = inputParts[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    creatures.add(pet);
                    break;
                case "Robot":
                    String robotName = inputParts[1];
                    String robotModel = inputParts[2];
                    Robot robot = new Robot(robotName, robotModel);
                    break;
            }

            input = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        creatures.stream()
                .filter(c -> c.getBirthDate().endsWith(specificYear))
                .forEach(s -> System.out.println(s.getBirthDate()));
    }
}
