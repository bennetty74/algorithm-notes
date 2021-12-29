package org.bugkit.leetcode;

import org.bugkit.structure.TreeNode;

/**
 * 翻转二叉树：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author bugkit
 * @since 2021.12.29
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 对左子树和右子树递归处理
        //      4
        //    /   \
        //    2     7
        //    / \   / \
        //   1   3 6   9
        //
        //       4
        //     /    \
        //    7      2
        //   / \    /  \
        //  6   9  1    3
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
