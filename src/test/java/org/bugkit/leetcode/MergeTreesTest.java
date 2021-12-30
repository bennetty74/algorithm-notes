package org.bugkit.leetcode;

import org.bugkit.Utils;
import org.bugkit.structure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bugkit
 * @since 2021.12.29
 */
class MergeTreesTest {



    @Test
    void mergeTrees() {
        MergeTrees mergeTrees = new MergeTrees();
        TreeNode root1 = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        assertEquals("3,4,5,5,4,7", Utils.bfs(mergeTrees.mergeTrees(root1, root2)));

    }
}