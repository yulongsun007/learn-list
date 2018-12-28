package win.yulongsun.demo.interv.剑指Offer.序列化二叉树;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author sunyulong on 2017/2/18.
 */
public class Solution {

    /**
     * 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
     * 不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
     * 2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树(特别注意：
     * 在递归时，递归函数的参数一定要是char ** ，这样才能保证每次递归后指向字符串的指针会
     * 随着递归的进行而移动
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }


    int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        int length = str.length();
        if (index >= length) {
            return null;
        }

        String[] split = str.split(",");


        TreeNode node = null;
        if (!split[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(split[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }


    public static void main(String[] args) {

    }

}

class TreeNode {
    int      val   = 0;
    TreeNode left  = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
