package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();//queue
        ArrayDeque<Double> cacao = new ArrayDeque<>();//stack

        Double[] milks = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .toArray(Double[]::new);
        Double[] cacaos = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .toArray(Double[]::new);

        Collections.addAll(milk, milks);
        Arrays.stream(cacaos).forEach(cacao::push);

        Map<String, Integer> chocolatesMade = new TreeMap<>();

        chocolatesMade.put("Milk Chocolate", 0);
        chocolatesMade.put("Dark Chocolate", 0);
        chocolatesMade.put("Baking Chocolate", 0);

        int chocolateCounter = 0;

        while(!(milk.isEmpty() || cacao.isEmpty())){
            double singleMilk = milk.poll();
            double singleCacao = cacao.pop();
            double sum = singleMilk + singleCacao;
            double cacaoPercentage = singleCacao / sum;

            String chocolate;
            switch ( String.valueOf(cacaoPercentage)){
                case "0.3":
                    chocolate = "Milk Chocolate";
                    break;
                case "0.5":
                    chocolate = "Dark Chocolate";
                    break;
                case "1.0":
                    chocolate = "Baking Chocolate";
                    break;
                default:
                    chocolate = null;
                    break;
            }
            if(chocolate != null){
                chocolateCounter++;
                int newValue = chocolatesMade.get(chocolate) + 1;
                chocolatesMade.put(chocolate, newValue);
            } else {
                milk.offer(singleMilk + 10);
            }

        }
        boolean areAllChocolatesMade = chocolatesMade.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if(areAllChocolatesMade){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMade.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach((key) -> System.out.print(String.format("# %s --> %d%n", key.getKey(), key.getValue())));

        //"# %s --> %d%n", key, value
    }
}
