import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import oracle.jrockit.jfr.events.DynamicValueDescriptor;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    public int maxDepth(TreeNode root) {
        return root != null ? 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) : 0;
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static int hammingWeight(int n) {
        int x = 0;
        while (n != 0) {
            x += (n & 1);
            n = n >>> 1;
        }
        return x;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
        } else return false;
    }

    public static int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public static int maxProfit(int[] prices) {
        int profix = 0;
        if (prices.length < 2) return profix;
        for (int i = 1; i < prices.length; i++) {
            profix += Math.max((prices[i] - prices[i-1]), 0);
        }
        return profix;
    }

    /**
     * Lowest Common Ancestor of a Binary Search Tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            return root;
        }
        else if (p.val >= root.val && q.val >= root.val) {
            return this.lowestCommonAncestor(root.right, p, q);
        }
        else return this.lowestCommonAncestor(root.left, p, q);
    }

    public static String convertToTitle(int n) {
        StringBuffer buffer = new StringBuffer();
        while (n != 0) {
            int tag = n % 26;
            n /= 26;
            char temp = (char) ((int) 'A' + tag - 1);
            if (tag != 0) {
                buffer.append(temp);
            } else {
                buffer.append('Z');
                n--;
            }
        }
        if (buffer.length() > 1) {
            buffer = buffer.reverse();
        }
        return buffer.toString();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                result.add(root.val);
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                root = temp.right;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(nums.length <= 2 || nums == null)
            return resultList;
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> tracker = new HashSet<ArrayList<Integer>>();
        int len = nums.length;
        for(int i = 0; i < len-2; i++){
            //left
            int j = i+1;
            //right
            int k = len-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(tracker.add(temp)){
                        resultList.add(temp);
                    }
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
            }
        }
        return resultList;
    }
}
