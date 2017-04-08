/*
答案解析：http://exercise.acmcoder.com/online/online_judge_answer_pdf?ques_id=4172&konwledgeId=169
*/
import java.util.*;

public class Main{
   public static int n;
   
   public class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x){
         val = x;
      }
   }
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
         n = sc.nextInt();
         int[] pre = new int[n];
         int[] in = new int[n];
         for(int i = 0; i<n; i++){
            pre[i] = sc.nextInt();
         }
         for(int i = 0; i<n; i++){
            in[i] = sc.nextInt();
         }
      
         //重新构造二叉树
         TreeNode root = reConstructTree(pre, in);
      
         //按层遍历
         printByLayer(root);
      }
   }
   
   //利用前序遍历和中序遍历重建二叉树
   public static TreeNode reConstructTree(int[] pre, int[] in){
       if(pre==null || in==null)  return null;
       
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0; i<n; i++){
          map.put(in[i], i);
       }
       
       return preIn(pre, 0, n-1, in, 0, n-1, map);
   }
   
   public static TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer,Integer> map){
       if(pi > pj)  return null;
       
       //先取前序遍历的第一个元素，这个元素为树的根节点
       Main m = new Main();
       TreeNode head = m.new TreeNode(p[pi]);
       //然后定位根节点在中序遍历数组中的位置index，则中序遍历数组中Index前面的为左子树，后面为右子树
       int index = map.get(p[pi]);
       
       //这里是最关键的一步，利用递归的思想，确定左子树和右子树在前序遍历和后序遍历数组中的位置，得到head节点的左子树和右子树
       head.left = preIn(p, pi+1, pi+index-ni, n, ni, index-1, map);
       head.right = preIn(p, pi+index-ni+1, pj, n, index+1, nj, map);
       
       return head;
   }
   
   public static void printByLayer(TreeNode root){
       if(root == null) return;
       
       //按层遍历的话，就要利用队列，先构建一个队列
       Queue<TreeNode> q = new LinkedList<>();
       //将根节点压入队列
       q.offer(root);
       while(!q.isEmpty()){
          TreeNode node = q.poll();
          if(node.left != null){
             q.offer(node.left);
          }
          if(node.right != null){
             q.offer(node.right);
          }
          System.out.print(node.val + " ");
       }      
   }
}
