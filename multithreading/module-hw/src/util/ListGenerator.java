package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListGenerator {

    public static List<Integer> generateRandomList() {
        Random random = new Random();

        int size = random.nextInt(6) + 4; // от 4 до 9 включительно
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100)); // случайные числа от 0 до 99
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> numbers = generateRandomList();
        System.out.println(numbers);
    }
}