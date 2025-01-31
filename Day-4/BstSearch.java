// search a element in BST and return the level of element, if no element -1

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

class BstSearch {
    Node root;

    public BstSearch() {
        root = null;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    public Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if(val < root.data) {
            root.left = insertRec(root.left, val);
        } else if (val > root.data) {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public int search(int val) {
        return searchRec(root, val, 1);
    }

    public int searchRec(Node root, int val, int level) {
        if(root == null) {
            return -1;
        }
        if(root.data == val) {
            return level;
        }
        if(val < root.data) {
            return searchRec(root.left, val, level+1);
        }
        if(val > root.data) {
            return searchRec(root.right, val, level+1);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BstSearch tree = new BstSearch();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Level of 40 in the BST: " + tree.search(40)); // Should return level where 40 is found
        System.out.println("Level of 25 in the BST: " + tree.search(25));
    }
}