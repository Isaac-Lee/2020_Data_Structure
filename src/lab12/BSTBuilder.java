//package lab12;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BSTBuilder {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        Map<String, Node> map = new HashMap<>();
//        Node root = null;
//
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String key = st.nextToken();
//            root = insert(root, Integer.parseInt(key));
//        }
//
//        preorder(root);
//        System.out.println("");
//        postorder(root);
//        System.out.println("");
//        inorder(root);
//
//    }
//
//    public static Node insert(Node root, int key) {
//        Node newNode = new Node(key);
//        if (root == null) {
//            root = newNode;
//            return root;
//        }
//        Node current = root;
//        Node parent = null;
//
//        while(true) {
//            parent = current;
//            if (key < current.data) {
//                current = current.left;
//                if (current == null) {
//                    parent.left = newNode;
//                    return root;
//                }
//            } else {
//                current = current.right;
//                if (current == null) {
//                    parent.right = newNode;
//                    return root;
//                }
//            }
//        }
//    }
//
//    public static void preorder(Node root) {
//        if (root != null) {
//            System.out.print(root.data + " ");
//            preorder(root.left);
//            preorder(root.right);
//        }
//    }
//
//    public static void postorder(Node root) {
//        if (root != null) {
//            postorder(root.left);
//            postorder(root.right);
//            System.out.print(root.data + " ");
//        }
//    }
//
//    public static void inorder(Node root) {
//        if (root != null) {
//            inorder(root.left);
//            System.out.print(root.data + " ");
//            inorder(root.right);
//        }
//    }
//}
//
//class Node {
//    int data;
//    public Node left;
//    public Node right;
//
//    public Node(int data) {
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    @Override
//    public String toString(){
//        return "Node: " + data;
//    }
//}