package stevesun.algorithms;

import stevesun.common.classes.TreeNode;

import java.util.*;

/**107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

*/
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			List<Integer> thisLevel = new ArrayList<Integer>();
			int qSize = q.size();
			for(int i = 0; i < qSize; i++){
				TreeNode curr = q.poll();
				thisLevel.add(curr.val);
				if(curr.left != null) q.offer(curr.left);
				if(curr.right != null) q.offer(curr.right);
			}
			result.add(thisLevel);
		}
		Collections.reverse(result);//this is the only line that gets added/changed to the previous solution.
		return result;
	}
}
