package challenges.isBST;

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

class Node {
	int data;
	Node left;
	Node right;
}

public class Solution {

	boolean checkBST(Node root) {
		if (root == null)
			return true;

		Boolean isBST = true;

		if (root.left != null) {
			isBST = checkLeftSubtree(root.left, null, root.data);
		}

		if (root.right != null) {
			isBST &= checkRightSubtree(root.right, root.data, null);
		}
		return isBST;
	}

	boolean checkLeftSubtree(Node node, Integer leftLimit, Integer rightLimit) {
		if (node == null)
			return true;

		if (rightLimit != null && node.data >= rightLimit) {
			return false;
		}

		if (leftLimit != null && node.data <= leftLimit) {
			return false;
		}

		boolean isBST = true;
		if (node.left != null) {
			isBST = checkLeftSubtree(node.left, leftLimit, node.data);
		}

		if (node.right != null) {
			isBST &= checkRightSubtree(node.right, node.data, rightLimit);
		}

		return isBST;
	}

	boolean checkRightSubtree(Node node, Integer leftLimit, Integer rightLimit) {
		if (node == null)
			return true;

		if (leftLimit != null && node.data <= leftLimit) {
			return false;
		}

		if (rightLimit != null && node.data >= rightLimit) {
			return false;
		}

		boolean isBST = true;
		if (node.left != null) {
			isBST = checkLeftSubtree(node.left, leftLimit, node.data);
		}

		if (node.right != null) {
			isBST &= checkRightSubtree(node.right, node.data, rightLimit);
		}

		return isBST;
	}

}
