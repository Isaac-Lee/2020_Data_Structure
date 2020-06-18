package lab10;

import java.util.*;

public class DisasterGrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> names = new HashMap<>();
        StringTokenizer st;
        while (sc.hasNextLine()) {
            st = new StringTokenizer(sc.nextLine());
            st.nextToken();
            Integer money = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (names.containsKey(name)) {
                names.put(name, names.get(name) + money);
            } else {
                names.put(name, money);
            }
        }

        List<String> keyList = new ArrayList<String>(names.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return -(names.get(t1).compareTo(names.get(s)));
            }
        });

        for (String name : keyList) {
            System.out.println(name);
        }

    }
}
