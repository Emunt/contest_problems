
public class p040 {
	public static void main(String[] args) {
		int i = 0;
		StringBuilder b = new StringBuilder("");
		
		while(b.length() < 1000050) {
			b.append(i);
			i++;
			System.out.println(b.length());
		}
		String str = b.toString();
		System.out.println(g(str, 1)*g(str, 10)*g(str, 100)*g(str, 1000)*g(str, 10000)*g(str, 100000)*g(str, 1000000));
	}
	
	public static int g(String str, int n) {
		return str.charAt(n) - '0';
	}
}
