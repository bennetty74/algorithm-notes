package org.bugkit.leetcode;

import org.bugkit.Utils;
import org.bugkit.structure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.12.29
 */
class InvertTreeTest {

    private TreeNode root;
    private TreeNode root1;
    private InvertTree invertTree;

    @BeforeEach
    void setup() {
        invertTree = new InvertTree();
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root1 = new TreeNode(1, new TreeNode(2), null);
    }

    @Test
    void invertTreeTest() {
        System.out.println(Utils.bfs(root));
        assertEquals("4,7,2,9,6,3,1",Utils.bfs(invertTree.invertTree(root)));
    }
}