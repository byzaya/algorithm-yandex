package Yandex;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public static boolean areSubtreesEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.value == root2.value &&
                areSubtreesEqual(root1.left, root2.left) &&
                areSubtreesEqual(root1.right, root2.right);
    }

    public static int findLargestEqualSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<String, Integer> subtreeCountMap = new HashMap<>();
        findLargestEqualSubtrees(root, subtreeCountMap);

        int maxCount = 0;
        for (int count : subtreeCountMap.values()) {
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private static String serializeSubtree(TreeNode node, Map<String, Integer> subtreeCountMap) {
        if (node == null) {
            return "";
        }

        String leftSubtree = serializeSubtree(node.left, subtreeCountMap);
        String rightSubtree = serializeSubtree(node.right, subtreeCountMap);

        String serialized = node.value + leftSubtree + rightSubtree;

        subtreeCountMap.put(serialized, subtreeCountMap.getOrDefault(serialized, 0) + 1);

        return serialized;
    }

    private static void findLargestEqualSubtrees(TreeNode root, Map<String, Integer> subtreeCountMap) {
        if (root == null) {
            return;
        }

        serializeSubtree(root, subtreeCountMap);

        findLargestEqualSubtrees(root.left, subtreeCountMap);
        findLargestEqualSubtrees(root.right, subtreeCountMap);
    }

    public static void main(String[] args) {
        // Создаем бинарное дерево для тестирования
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('a');
        root.left.left = new TreeNode('c');
        root.left.right = new TreeNode('d');
        root.right.left = new TreeNode('b');
        root.right.right = new TreeNode('a');
        root.left.left.left = new TreeNode('e');

        int largestEqualSubtrees = findLargestEqualSubtrees(root);
        System.out.println("Наибольшее количество равных поддеревьев: " + largestEqualSubtrees);
    }
}