package 算法集合101_150;

import source.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2ms
 * 40.3MB
 */
public class _113_路径总和II {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum) {
        //当前节点为空
        if(root == null){
            return;
        }
        //当前节点为叶节点
        if(root.left == null && root.right == null){
            if(sum == root.val){
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        //当前节点为根节点
        list.add(root.val);
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
