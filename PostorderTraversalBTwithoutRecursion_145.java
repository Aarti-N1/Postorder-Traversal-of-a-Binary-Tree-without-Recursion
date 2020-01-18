package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import general.TreeNode;

public class PostorderTraversalBTwithoutRecursion_145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer>res = postorderTraversal(root);
		for(int i=0;i< res.size();i++) {
			System.out.println(res.get(i));
		}
	}

	 public static List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        if(root== null)
	            return res;
	        TreeNode prev=null;
	        TreeNode cur = root;
	        Stack<TreeNode> st = new Stack<TreeNode>();
	        st.push(root);
	        while(!st.isEmpty()){
	            cur= st.peek();
	            if(prev==null || prev.left==cur || prev.right == cur){//we came down to cur from prev
	                if(cur.left!=null)//go left
	                    st.push(cur.left);
	                else if(cur.right!=null) //go right
	                    st.push(cur.right);
	                else{ //leaf node
	                    cur=st.pop();
	                    res.add(cur.val);
	                }
	            }
	            else if(cur.left==prev){
	                //came up from left go right
	            	if(cur.right!=null)
	                    st.push(cur.right);
	            	else {
	            		 cur =st.pop();
	 	                res.add(cur.val);
	            	}
	            		
	            }else{//came up from right print parent
	                cur =st.pop();
	                res.add(cur.val);
	            }
	            
	            prev= cur;
	        }
	        return res;
	    }
}
