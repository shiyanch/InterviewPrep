package Trees;

import Util.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanch on 12/30/16.
 */
public class ConstructBinaryTreeFromInorderAndPreorder {


    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        return buildTree(preorder, inorder, 0,preorder.size()-1, 0, inorder.size()-1);
    }

    private TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight || preLeft >= preorder.size() || preRight >= preorder.size()
                || inLeft >= inorder.size() || inRight >= inorder.size()) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(preLeft));
        int index = inLeft;
        while (index <= inRight) {
            if (inorder.get(index) == preorder.get(preLeft)) {
                break;
            }
            index++;
        }

        root.left = buildTree(preorder, inorder, preLeft+1, preLeft+(index-inLeft), inLeft, index-1);
        root.right = buildTree(preorder, inorder, preLeft+(index-inLeft)+1, preRight, index+1, inRight);
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();

        preorder.add(1);
        preorder.add(2);
        preorder.add(3);

        inorder.add(2);
        inorder.add(1);
        inorder.add(3);

        TreeNode root = new ConstructBinaryTreeFromInorderAndPreorder().buildTree(preorder, inorder);
        System.out.println("hehe");
    }
}
