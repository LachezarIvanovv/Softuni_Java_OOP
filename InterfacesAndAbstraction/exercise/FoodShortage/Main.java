package InterfacesAndAbstraction.exercise.FoodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            if(data.length == 3){
                String rebelName = data[0];
                int rebelAge = Integer.parseInt(data[1]);
                String rebelGroup = data[2];
                Rebel rebel = new Rebel(rebelName, rebelAge, rebelGroup);
                buyerMap.put(rebelName, rebel);
            } else {
                String citizenName = data[0];
                int citizenAge = Integer.parseInt(data[1]);
                String citizenId = data[2];
                String citizenBirthDate = data[3];
                Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                buyerMap.put(citizenName, citizen);
            }
        }

        String names = scanner.nextLine();

        while(!"End".equals(names)){
             Buyer buyer = buyerMap.get(names);

            if(buyer != null){
                buyer.buyFood();
            }

            names = scanner.nextLine();
        }

        int total = buyerMap.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(total);
    }
}
