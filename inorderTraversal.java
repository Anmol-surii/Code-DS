
import java.util.ArrayList;
import java.util.List;


public class inorderTraversal {
    public List<Integer> inorderTraversalQ(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
