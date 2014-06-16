import static org.junit.Assert.*;
import org.junit.Test;

//William Nichols

public class a4Test {
	//Invalid Triangles
	
	@Test
	public void test1() {
		a4.Triangle t = new a4.Triangle("0 0 0");
		assertEquals("Invalid Triangle", t.getClassification());
	}
	@Test
	public void test2() {
		a4.Triangle t = new a4.Triangle("0 0 1");
		assertEquals("Invalid Triangle", t.getClassification());
	}
	@Test
	public void test3() {
		a4.Triangle t = new a4.Triangle("-1 -3 -3");
		assertEquals("Invalid Triangle", t.getClassification());
	}
	@Test
	public void test4() {
		a4.Triangle t = new a4.Triangle("1 2 3");
		assertEquals("Invalid Triangle", t.getClassification());
	}
	@Test
	public void test5() {
		a4.Triangle t = new a4.Triangle(Integer.toString(Integer.MIN_VALUE) + " " + Integer.toString(Integer.MIN_VALUE) +" "+Integer.toString(Integer.MIN_VALUE));
		assertEquals("Invalid Triangle", t.getClassification());
	}
	
	//Invalid Input
	@Test
	public void test6() {
		a4.Triangle t = new a4.Triangle("");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test7() {
		a4.Triangle t = new a4.Triangle("1");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test8() {
		a4.Triangle t = new a4.Triangle("1 1");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test9() {
		a4.Triangle t = new a4.Triangle("1 1 1 1");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test10() {
		long a = Integer.MAX_VALUE;
		a++;
		a4.Triangle t = new a4.Triangle(a +" " +a + " " + a);
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test11() {
		long a = Integer.MIN_VALUE;
		a--;
		a4.Triangle t = new a4.Triangle(a +" " +a + " " + a);
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test12() {
		a4.Triangle t = new a4.Triangle("a a a");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test13() {
		a4.Triangle t = new a4.Triangle("1 1 1 a");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test14() {
		a4.Triangle t = new a4.Triangle("123a 123b 123c");
		assertEquals("Invalid Input", t.getClassification());
	}
	
	@Test
	public void test15() {
		a4.Triangle t = new a4.Triangle("11111111111111111 123123123121312 12312412312");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test16() {
		a4.Triangle t = new a4.Triangle("3.2 4.7 5.6");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test17() {
		a4.Triangle t = new a4.Triangle("3.0 3.0 3.0");
		assertEquals("Invalid Input", t.getClassification());
	}
	@Test
	public void test18() {
		a4.Triangle t = new a4.Triangle("1\\n1\\n1\\n");
		assertEquals("Invalid Input", t.getClassification());
	}
	
	//Equilateral
	@Test
	public void test19() {
		a4.Triangle t = new a4.Triangle("3 3 3");
		assertEquals("Equilateral", t.getClassification());
	}
	@Test
	public void test20() {
		long a = Integer.MAX_VALUE;
		a4.Triangle t = new a4.Triangle(a +" " +a + " " + a);
		assertEquals("Equilateral", t.getClassification());
	}
	@Test
	public void test21() {
		a4.Triangle t = new a4.Triangle("3  3  3");
		assertEquals("Equilateral", t.getClassification());
	}
	@Test
	public void test22() {
		a4.Triangle t = new a4.Triangle("3	3	3");
		assertEquals("Equilateral", t.getClassification());
	}
	
	//Isosceles
	@Test
	public void test23() {
		a4.Triangle t = new a4.Triangle("2 2 3");
		assertEquals("Isosceles", t.getClassification());
	}
	@Test
	public void test24() {
		a4.Triangle t = new a4.Triangle("2 3 2");
		assertEquals("Isosceles", t.getClassification());
	}
	
	//Scalene
	@Test
	public void test25() {
		a4.Triangle t = new a4.Triangle("7 8 9");
		assertEquals("Scalene", t.getClassification());
	}
	
	@Test
	public void test26() {
		a4.Triangle t = new a4.Triangle("7 9 8");
		assertEquals("Scalene", t.getClassification());
	}
	
	//Extra
	@Test
	public void test27() {
		a4.Triangle t = new a4.Triangle("32 35 50");
		assertEquals("Scalene", t.getClassification());
	}
	
	@Test
	public void test28() {
		a4.Triangle t = new a4.Triangle("100 100 100");
		assertEquals("Equilateral", t.getClassification());
	}
	
	@Test
	public void test29() {
		a4.Triangle t = new a4.Triangle("77 77 1");
		assertEquals("Isosceles", t.getClassification());
	}
	
	@Test
	public void test30() {
		a4.Triangle t = new a4.Triangle("          ");
		assertEquals("Invalid Input", t.getClassification());
	}
	
	@Test
	public void test31() {
		a4.Triangle t = new a4.Triangle("3|3|3");
		assertEquals("Invalid Input", t.getClassification());
	}
}
