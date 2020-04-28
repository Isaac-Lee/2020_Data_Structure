package lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double max = 0;
        String maxWord = null;
        double size = 0;
        Map<String, Integer> map = new HashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] sentence = line.split("[\\W_]+");
            for (int i = 0; i < sentence.length; i++) {
                String word = sentence[i].toLowerCase();
//                if (word.equals("")) {
//                    continue;
//                }
                size++;
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                    if (max < map.get(word)) {
                        max = map.get(word);
                        maxWord = word;
                    }
                } else {
                    map.put(word, map.get(word)+1);
                    if (max < map.get(word)) {
                        max = map.get(word);
                        maxWord = word;
                    }
                }
            }
        }
        System.out.println(maxWord + " " + Math.round((100*(max/size)))/100.0);
    }
}
