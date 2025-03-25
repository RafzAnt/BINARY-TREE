public class Binary {

    
    static class Node {
        int value;
        Node left, right;

        
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

        

    private Node insertRecursive(Node currentRoot, int value) {
        if (currentRoot == null) {
            currentRoot = new Node(value);
            return currentRoot;
        }
        if (value < currentRoot.value) {
            currentRoot.left = insertRecursive(currentRoot.left, value);
        } else if (value > currentRoot.value) {
            currentRoot.right = insertRecursive(currentRoot.right, value);
        }
        return currentRoot;
    }

    
    public void inOrderTraversal(Node currentRoot) {
        if (currentRoot != null) {
            inOrderTraversal(currentRoot.left);
            System.out.print(currentRoot.value + " ");
            inOrderTraversal(currentRoot.right);
        }
    }

    
    public void preOrderTraversal(Node currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.value + " ");
            preOrderTraversal(currentRoot.left);
            preOrderTraversal(currentRoot.right);
        }
    }

    
    public void postOrderTraversal(Node currentRoot) {
        if (currentRoot != null) {
            postOrderTraversal(currentRoot.left);
            postOrderTraversal(currentRoot.right);
            System.out.print(currentRoot.value + " ");
        }
    }

    public static void main(String[] args) {
        Binary tree = new Binary();
        int[] values = {10, 5, 15, 3, 8, 20};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("In-Order Traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Pre-Order Traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Post-Order Traversal:");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
}
