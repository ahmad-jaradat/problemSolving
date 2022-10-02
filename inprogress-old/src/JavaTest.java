
public class JavaTest {

	
	public static void main(String[] args) {
		String a = "Hello world";
		String b = new String("Hello world");
		String c = "Hello world";
		
		System.out.println(a == b);
		System.out.println(a == c);
		b = b.intern();
		System.out.println(a == b);
		
		Integer.valueOf(4);
		new Integer(4);
		
	}
}
