package win.yulongsun.demo.interv.剑指Offer.树的子结构;

/**
 * 树的子结构:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author sunyulong on 2017/1/22.
 */
public class Solution {


    public static void main(String[] args) {

    }


    /**
     * http://blog.csdn.net/snow_7/article/details/51848566
     * <p>
     * 思路：
     * 1. 在树A中找到与树B种根相同的节点R
     * 2. 在判断R中的子树是不是包含B树
     * <p>
     * <p>
     * 做法二：
     * KMP算法
     *
     * @param root1 树A
     * @param root2 树B
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {

            //判断是否包含
            if (root1.val == root2.val) {
                result = isSubTree(root1, root2);
            }
            //判断左子树，递归
            if (result == false) {
                result = HasSubtree(root1.left, root2);
            }
            //判断右子树，递归
            if (result == false) {
                result = HasSubtree(root1.right, root2);
            }


        }

        return result;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        //如果树B为空，还没return的话，说明树A包含树B
        if (root2 == null)
            return true;

        //如果树B还没遍历完，树A却为null了的话，说明树A不完全包含树B
        if (root1 == null)
            return false;

        if (root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }


    class TreeNode {
        int      val   = 0;
        TreeNode left  = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}

