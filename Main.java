import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
  // Given a binary tree, populate an array to represent its level-by-level
  // traversal. You should populate the values of all nodes of each level from
  // left to right in separate sub-arrays.

  private static List<List<Integer>> leverOrderTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> currentLevel = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        TreeNode currentNode = queue.poll();
        // add node to the current level
        currentLevel.add(currentNode.val);
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
      res.add(currentLevel);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    System.out.println(Main.leverOrderTraversal(root));
  }
}