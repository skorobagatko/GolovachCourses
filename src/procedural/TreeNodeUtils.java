package procedural;
/*
    Методы для работы с классом TreeNode
 */

public class TreeNodeUtils {
    public static void main(String[] args) {
        TreeNode root = create(3);
        System.out.println("TreeNode height = " + height(root));
        System.out.println("TreeNode size = " + size(root));
        root.left.left.left = new TreeNode(1, null, null);
        root.right.right.right = new TreeNode(2, null, new TreeNode(4, null, null));
        System.out.println("TreeNode height = " + height(root));
        System.out.println("TreeNode size = " + size(root));
        System.out.println("TreeNode sum = " + sum(root));
        System.out.println("TreeNode max = " + max(root));
    }

    // Метод создает бинарное дерево заданной высоты
    public static TreeNode create(int height) {
        if (height == 0) return null;
        TreeNode result = new TreeNode(height, null, null);
        result.left = create(height-1);
        result.right = create(height-1);
        return result;
    }
    // Метод возвращает  размер дерева (количество всех его вершин)
    public static int size(TreeNode root) {
        return (root == null) ? 0 : 1 + size(root.left) + size(root.right);
    }

    // Метод возвращает высоту дерева (вычисляется по самой высокой ветке)
    public static int height(TreeNode root) {
        if (root == null) { return 0; }
        int result = 1;
        int leftBranch;
        int rightBranch;
        return ((leftBranch = height(root.left)) > (rightBranch = height(root.right))) ? result + leftBranch : result + rightBranch ;
    }

    // Метод возвращает сумму всех значений value всех вершин дерева
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.value + sum(root.left) + sum(root.right);
    }

    // Метод возвращает максимальное значение value среди всех вершин
    // TODO
    public static int max(TreeNode root) {
        if (root == null) return 0;
        int result;

        return 1;
    }

    public static String toString(TreeNode root) {
        if (root == null) return "null";
        return toString(root.left) + "--" + root.value + "--" + toString(root.right) + "\n";
    }
}
