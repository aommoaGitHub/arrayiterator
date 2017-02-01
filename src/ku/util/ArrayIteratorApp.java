package ku.util;
/**
 * File for trying ArrayIterator class
 * @author Vittunyuta Maeprasart
 *
 */
public class ArrayIteratorApp {

	public static void main(String[] args) {
		String[] array = { "apple", "banana", null, "carrot" };
		ArrayIterator<String> a = new ArrayIterator<String>(array);
//		a.next();
//		a.remove();
//		a.remove();
		while (a.hasNext()) {
			System.out.println(a.next());
		}
	}
}
