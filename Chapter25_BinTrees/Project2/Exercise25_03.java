/**************************************************************************************
(Test perfect binary tree)
A perfect binary tree is a complete binary tree with all levels fully filled.
Define a new class named BSTWithTestPerfect that extends BST with the following method: 
(Hint: The number of nodes in a perfect binary tree is 2^(height+1) - 1.)
/** Returns true if the tree is a perfect binary tree */
public boolean isPerfectBST()
**************************************************************************************/
import java.util.*;

public class Exercise25_03 {
    public static void main(String[] args) {
        BSTWithTestPerfect<String> tree = new BSTWithTestPerfect<>();
        System.out.print("Is an empty tree perfect? " + tree.isPerfectBST());

        tree.insert("Green");
        System.out.print("\nIs a one-node tree perfect? " + tree.isPerfectBST());

        tree.insert("Red");
        System.out.print("\nIs a two-node tree perfect? " + tree.isPerfectBST());

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String s = input.next();
        tree.insert(s.trim());
        System.out.print("Is this tree perfect? " + tree.isPerfectBST());

        BSTWithTestPerfect<String> tree1 = new BSTWithTestPerfect<>(new String[]
                {"Tom", "George", "Jean", "Jane", "Kevin", "Peter", "Susan",
                        "Jen", "Kim", "Michael", "Michelle"});
        System.out.print("\nIs tree1 perfect? " + tree1.isPerfectBST());

        BSTWithTestPerfect<Integer> tree2 =
                new BSTWithTestPerfect<>(new Integer[]{50, 45, 75, 18, 49, 51, 98});
        System.out.print("\nIs tree2 perfect? " + tree2.isPerfectBST());
    }
}

interface Tree<E> extends java.util.Collection<E> {
    public boolean search(E e);

    public boolean insert(E e);

    public boolean delete(E e);

    public int getSize();

    public default void inorder() {
    }

    public default void postorder() {
    }

    public default void preorder() {
    }

    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean contains(Object e) {
        return search((E) e);
    }

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E) e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public default Object[] toArray() {
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        return null;
    }
}

class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    public BST() {
        this.c = new Comparator<E>() {
            public int compare(E e1, E e2) {
                return ((Comparable<E>) e1).compareTo(e2);
            }
        };
    }

    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    public BST(E[] objects) {
        this();
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else
                return true;
        }

        return false;
    }

    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;

            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else
                break;
        }

        return list;
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }

        if (current == null)
            return false;

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (c.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true;
    }

    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements java.util.Iterator<E> {
        private java.util.ArrayList<E> list =
                new java.util.ArrayList<>();
        private int current = 0;

        public InorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        public boolean hasNext() {
            return current < list.size();
        }

        public E next() {
            return list.get(current++);
        }

        public void remove() {
            if (current == 0)
                throw new IllegalStateException();

            delete(list.get(--current));
            list.clear();
            inorder();
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }
}

class BSTWithTestPerfect<E> extends BST<E> {
    public BSTWithTestPerfect() {
        super();
    }

    public BSTWithTestPerfect(java.util.Comparator<E> c) {
        super(c);
    }

    public BSTWithTestPerfect(E[] objects) {
        super(objects);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> root) {
        if (root == null) {
            return -1;
        } else if (root.left == null && root.right == null) {
            return 0;
        } else {
            int leftH = height(root.left);
            int rightH = height(root.right);
            return 1 + Math.max(leftH, rightH);
        }
    }

    public boolean isPerfectBST() {
        return getSize() == (Math.pow(2, height() + 1) - 1);
    }
}

