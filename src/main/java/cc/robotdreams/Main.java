package cc.robotdreams;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Enter one of values " + Arrays.asList(Car.values()).stream().map(Car::name).collect(Collectors.toList()));
        Scanner scanner = new Scanner(System.in);
        Car car = Car.valueOf(scanner.nextLine());
        System.out.println(car);

        switch (car) {
            case MERCEDES_BENZ:
                System.out.println("Process MERCEDES");
                break;
            case BMW:
                System.out.println("Process BMW");
                break;
            case RENO:
                System.out.println("Process RENO");
                break;
            default:
                System.out.println("Default");
        }

        printEvenChars(new String[] {"мама", "тато", "їж їжак желе", "івавіавіав", "папа"});

        String someValue = "Hello from Java application";

        System.out.println(reverseSameString(someValue));


    }

    public static String reverseString(String sourceString) {
        char[] target = new char[sourceString.length()];
        char[] source = sourceString.toCharArray();
        for (int i = 0; i < source.length; i ++) {
            target[source.length - 1 - i] = source[i];
        }
        return new String(target);
    }

    public static String reverseSameString(String sourceString) {
        char[] source = sourceString.toCharArray();
        for (int i = 0; i < source.length; i ++) {
            int fromLast = source.length - 1 - i;
            if (fromLast > i) {
                char tmp = source[i];
                source[i] = source[fromLast];
                source[fromLast] = tmp;
            } else
                break;
        }
        return new String(source);
    }

    public static void printEvenChars (String[] words) {
        List<String> evenWords = new ArrayList<>();
        int counter = 0;
        for (String word : words) {
            Map<Character, Integer> charCount = countCharacters(word);
            if (isEvenCountOfChars(charCount)) {
                evenWords.add(word);
                if (++ counter == 2)
                    break;
            }
        }
        Set<Character> uniqueChars = getUniqueChars(evenWords);
        System.out.println(uniqueChars);
    }

    private static Map<Character, Integer> countCharacters(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : chars) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        return charCount;
    }

    private static Set<Character> getUniqueChars(List<String> list) {
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : list) {
            char[] chars = word.toCharArray();
            for (char ch : chars)
                uniqueChars.add(ch);
        }
        return uniqueChars;
    }

    private static boolean isEvenCountOfChars(Map<Character, Integer> charCount) {
        boolean isEven = false;
        for (Character ch : charCount.keySet()) {
            isEven = charCount.get(ch) % 2 == 0;
            if (!isEven) break;
        }
        return isEven;
    }
}