package lab6;

import java.util.*;

public class RepWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        List<String[]> sents = new ArrayList<>();
        String line = sc.nextLine().toLowerCase();
        int index = 0;
        while (index < m) {
            StringBuilder sb = new StringBuilder();
            if (index == 0) {
                sb.append(line);
            }
            while(sc.hasNext()){
                line = sc.nextLine().toLowerCase();
                if (line.equals("")){
                    break;
                }
               sb.append(line+" ");
            }
            sents.add(sb.toString().split("[\\W_]+"));
            index++;
        }

        Set<String> allWord = new HashSet<>(Arrays.asList(sents.get(0)));
        for (int i = 1; i < m; i++) {
            allWord.retainAll(Arrays.asList(sents.get(i)));
        }

        for (int i = 0; i < m; i++) {
            String[] sentArr = sents.get(i);
            Set<String> sent = new HashSet<>(Arrays.asList(sentArr));
            sent.removeAll(allWord);

            double max = 0;
            String maxWord = null;
            double size = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int k = 0; k < sentArr.length; k++){
                String word = sentArr[k];
                if (allWord.contains(word)) {
                    continue;
                }
                if (word.equals("")) {
                    continue;
                }
                size++;
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (max < map.get(word)) {
                    max = map.get(word);
                    maxWord = word;
                }
            }
            System.out.println(maxWord + " " + Math.round((100*(max/size)))/100.0);
        }
    }
}
