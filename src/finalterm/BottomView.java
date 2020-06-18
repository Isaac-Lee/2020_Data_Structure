package finalterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BottomView {
    static Node root;
    static Queue<Node> answer = new LinkedList<>();
    static Map<String, Node> map = new HashMap<>();

    public static Node makeBT(Node left, String data, Node right){
        Node root = new Node(data);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String[] tmp = br.readLine().split(" ");

            String key = tmp[0];
            Node node = null;
            if (!map.containsKey(key)) {
                node = new Node(key);
                map.put(key, node);
                if (map.size() == 1) {
                    root = node;
                }
            } else {
                node = map.get(key);
            }

            String leftkey = tmp[1];
            if (!leftkey.equals(".")) {
                Node left = null;

                if (!map.containsKey(leftkey)) {
                    left = new Node(leftkey);
                    left.hd = node.hd - 1;
                    map.put(leftkey, left);
                } else {
                    left = map.get(leftkey);
                }
                node.left = left;
            }

            String rightKey = tmp[2];
            if (!rightKey.equals(".")) {
                Node right = null;

                if (!map.containsKey(rightKey)) {
                    right = new Node(rightKey);
                    right.hd = node.hd + 1;
                    map.put(rightKey, right);
                } else {
                    right = map.get(rightKey);
                }

                node.right = right;
            }
        }

        Queue<Node> answer = new LinkedList<>();
        Map<Integer, Node> topView  = new TreeMap<>();

        answer.offer(root);
        while (answer.size() != 0) {
            int size = answer.size();
            Set<Integer> isChange = new HashSet<>();

            for (int i = 0 ; i < size; i ++) {
                Node node = answer.poll();
                if (node.left != null) {
                    answer.offer(node.left);
                }
                if (node.right != null) {
                    answer.offer(node.right);
                }
                if (!isChange.contains(node.hd)) {
                    topView.put(node.hd, node);
                    isChange.add(node.hd);
                }
            }
        }

        for (Object n : topView.values().toArray()) {
            Node node = (Node) n;
            System.out.print(node+" ");
        }

    }
}

class Node {
    String data;
    Node left;
    Node right;
    int hd = 0;


    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString(){
        return data;
    }
}