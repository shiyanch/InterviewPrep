package Trees;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shiyanch on 12/30/16.
 */
public class ZigZag {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == null) {
            return result;
        }
        boolean leftToRight = true;
        queue.offer(a);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode root = queue.poll();
                if (leftToRight) {
                    list.add(root.val);
                }
                else {
                    list.add(0, root.val);
                }

                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(list);
        }

        return result;
    }
}
