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

public class Solution{
	 boolean checkBST(Node root) {
	        return 
	        ( CheckSubTree(root.left, root.data, 0) &&
	        CheckSubTree(root.right, root.data, 1) );
	    }

	    boolean CheckSubTree(Node node, int data, int direction){ //0: left, 1: right
	        if(node == null)
	            return true;
	        
	        if(direction == 1){
	            if(node.data <= data)
	                return false;
	            else
	            {
	                return (CheckSubTree(node.left,node.data,0) && CheckSubTree(node.right,node.data,1));
	            }
	            
	        }else{
	            if(node.data >= data)
	                return false;
	            else{
	                return (CheckSubTree(node.left,node.data,0) && CheckSubTree(node.right,node.data,1));
	            }
	        }

	    }
}
