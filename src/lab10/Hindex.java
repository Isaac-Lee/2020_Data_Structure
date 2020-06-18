package lab10;

import java.util.*;

public class Hindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        Map<String, Integer> names = new HashMap<>();
        while (sc.hasNextLine()) {
            st = new StringTokenizer(sc.nextLine());
            String name = st.nextToken();

            ArrayList<Integer> index = new ArrayList<>();
            while (st.hasMoreTokens()) {
                index.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(index, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    if (integer < t1) {
                        return 1;
                    } else if (integer > t1){
                        return -1;
                    }
                    return 0;
                }
            });

            Integer hIndex = index.size()+1;
            for (int i = 1; i < index.size() ; i++) {
                if (i > index.get(i-1)) {
                    hIndex = i-1;
                    break;
                }
            }
            names.put(name, hIndex);
        }

        List<String> keyList = new ArrayList<String>(names.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return names.get(t1).compareTo(names.get(s));
            }
        });
        System.out.println(keyList.get(0) +" "+ names.get(keyList.get(0)));
    }
}
