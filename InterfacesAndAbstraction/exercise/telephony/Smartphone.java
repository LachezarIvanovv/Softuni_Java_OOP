package InterfacesAndAbstraction.exercise.telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(hasNumbers(url)){
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if(hastOnlyNumbers(number)){
                sb.append(String.format("Calling... %s",number)).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean hastOnlyNumbers(String number) {
        for (int i = 0; i < number.length(); i++) {
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean hasNumbers(String url) {
        for (int i = 0; i < url.length(); i++) {
            if(Character.isDigit(url.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
