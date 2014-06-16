import java.util.Scanner;


public class TreeRecovery {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext()) {
			String preorder = kb.next();
			String inorder = kb.next();
			System.out.println(solve(preorder, inorder));
		}
	}
	
	private static String solve(String preorder, String inorder) {
		if(preorder.length() <= 1) return preorder;
		String split = preorder.substring(0,1);
		String inorderleft = inorder.substring(0,inorder.indexOf(split));
		String inorderright = inorder.substring(inorder.indexOf(split) + 1);
		String preorderleft = preorder.substring(1, inorderleft.length() + 1);
		String preorderright = preorder.substring(inorderleft.length() + 1);
		
		return solve(preorderleft, inorderleft) + solve(preorderright, inorderright) + split;
	}
}
