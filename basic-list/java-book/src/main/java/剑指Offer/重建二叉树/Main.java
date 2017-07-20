//package 剑指Offer.重建二叉树;
//
//
///**
// * 重建二叉树：
// * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
// * <p>
// * <p>
// * https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
// *
// * @author sunyulong on 2017/1/22.
// */
//public class Main {
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        if (pre.length < 0 || in.length < 0 || pre.length != in.length) {
//            return null;
//        }
//        int len = pre.length - 1;
//        return constructBinaryTree(pre, in, 0, len - 1, 0, len - 1);
//    }
//
//    public static TreeNode constructBinaryTree(int[] pre, int[] in, int preStartPos, int preEndPos, int inStartPos, int inEndPos) {
//        TreeNode node = new TreeNode(pre[preStartPos]);
//        node.left = null;
//        node.right = null;
//
//
//        //叶子节点
//        if ((preStartPos == preEndPos) && (inStartPos == inEndPos) && (pre[preStartPos] == in[inStartPos])) {
//            return node;
//        } else {
//            return null;
//        }
//
//
//        //找到根节点:中序遍历和先序遍历相等的节点就i是根节点
////        int i = inStartPos;
////        for (i = inStartPos; i <= inEndPos; i++) {
////            if (pre[preStartPos] == in[i]) {
////                break;
////            }
////        }
//
//
////        int leftLen = i - inStartPos;
////
////        //构造左子树
////        if (leftLen > 0) {
////            node.left = constructBinaryTree(pre, in, preStartPos + 1, preStartPos + leftLen, inStartPos, i - 1);
////        }
////
////        //构造右子树
////        if (inEndPos - i > 0) {
////            node.right = constructBinaryTree(pre, in, preStartPos + leftLen + 1, preEndPos, i + 1, inEndPos);
////        }
//
//        return node;
//    }
//
//}
//
//class TreeNode {
//    int      val   = 0;
//    TreeNode left  = null;
//    TreeNode right = null;
//
//    TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}
