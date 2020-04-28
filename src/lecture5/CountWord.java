package lecture5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] sentence = line.split(" ");
            for (int i = 0; i < sentence.length; i++) {
                String word = sentence[i].toLowerCase();
                System.out.println(word);
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                    if (max < map.get(word)) {
                        max = map.get(word);
                    }
                } else {
                    map.put(word, map.get(word)+1);
                    if (max < map.get(word)) {
                        max = map.get(word);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
