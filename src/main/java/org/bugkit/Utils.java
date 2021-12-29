package org.bugkit;

import org.bugkit.structure.LinkedList;
import org.bugkit.structure.Queue;
import org.bugkit.structure.TreeNode;

import java.util.Locale;

/**
 * @author bugkit
 * @since 2021.12.29
 */
public class Utils {


    public static String inorder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        internalInorder(root, sb);
        String sequence = sb.substring(0, sb.length() - 1);
        sb.delete(0, sb.length());
        return sequence;
    }


    private static void internalInorder(TreeNode root, StringBuilder sb) {
        if (root != null) {
            if (root.left != null) {
                internalInorder(root.left, sb);
            }
            sb.append(root.val).append(",");
            if (root.right != null) {
                internalInorder(root.right, sb);
            }
            return;
        }
        sb.append("N").append(",");
    }

    public static String preOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        internalPreOrder(root, sb);
        String sequence = sb.substring(0, sb.length() - 1);
        sb.delete(0, sb.length());
        return sequence;
    }



    public static void internalPreOrder(TreeNode root,StringBuilder sb) {
        if (root != null) {
            sb.append(root.val).append(",");
            if (root.left != null) {
                internalInorder(root.left, sb);
            }
            if (root.right != null) {
                internalInorder(root.right, sb);
            }
            return;
        }
        sb.append("N").append(",");
    }

    public static String postOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        internalPostOrder(root, sb);
        String sequence = sb.substring(0, sb.length() - 1);
        sb.delete(0, sb.length());
        return sequence;
    }

    public static void internalPostOrder(TreeNode root,StringBuilder sb) {
        if (root != null) {
            if (root.left != null) {
                internalInorder(root.left, sb);
            }
            if (root.right != null) {
                internalInorder(root.right, sb);
            }
            sb.append(root.val).append(",");
            return;
        }
        sb.append("N").append(",");
    }

    public static String bfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                continue;
            }
            sb.append("N").append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
