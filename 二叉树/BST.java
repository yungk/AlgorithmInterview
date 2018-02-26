import java.util.LinkedList;

/**
 * @author: luoluo
 * @description:二分搜索树
 * @Date: Created in 23:47 2018/2/23
 * @modified By:
 */
public class BST {

    private class Node{
        private int key;
        private int value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;
    private int count;

    public BST() {
        this.count = 0;
        root = null;
    }

    public void insert(int key, int value) {
        root = insert(root,key,value);
    }

    private Node insert(Node node, int key, int value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.key == key) {
            node.value = value;
        } else if (node.key > key) {
            node.left = insert(node.left, key, value);
        }else{
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public int search(int key) {
        Node node = search(root, key);
        return node.value;
    }

    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        } else if (node.key > key) {
            return search(node.left, key);
        }else{
            return search(node.right, key);
        }
    }

    public boolean contain(int key) {
        Node search = search(root, key);
        if (search == null) {
            return true;
        }else{
            return false;
        }
    }
    // 二分搜索树的前序遍历
    public void preOder(){
        preOder(root);
    }

    private void preOder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOder(node.left);
            preOder(node.right);
        }

    }

    public void inOrder() {
        inOrder(root);
    }
    // 二分搜索树的中序遍历
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node);
            System.out.println(node.key);
            inOrder(node);
        }
    }
    // 二分搜索树的后序遍历
    private void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            preOder(node.left);
            preOder(node.right);
            System.out.println(node.key);
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder(){
        if (isEmpty()) {
            return;
        }
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            System.out.println(root.key);
            Node remove = q.remove();
            if(remove.left!=null){
                q.add(remove.left);
            }
            if (remove.right != null) {
                q.add(remove.right);
            }
        }
    }

    public int min() {
        if (isEmpty()) {
            return -1;
        }
        Node node = min(root);
        return node.key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }else{
            return min(node);
        }
    }

    public int max(){
        if (isEmpty()) {
            return -1;
        }

        Node node = max(root);
        return node.key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }else{
            return max(node.right);
        }
    }

    public void removeMin() {
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            count--;
            node.right = null;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public void removeMax(){
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            count--;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(int key) {
        if(!isEmpty()){
           root = remove(root, key);
        }
    }

    private Node remove(Node node, int key) {
        if (node.key > key) {
            node = remove(node.left, key);
            return node;
        } else if (node.key < key) {
            Node remove = remove(node.right, key);
            return remove;
        }else{
            if (node.right == null) {
                Node left = node.left;
                count--;
                node.left = null;
                return left;
            } else if (node.left == null) {
                Node right = node.right;
                node.right = null;
                count--;
                return right;
            }else{
                Node successor = min(node.right);
                count++;
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                count--;
                return successor;
            }
        }
    }

    public int size(){
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
