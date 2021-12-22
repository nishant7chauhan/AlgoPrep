
package array;

/**
 * Find duplicate character in a array O(n) time with no extra space.
 * @author IN006166
 * O(n), can check for abs solution also 
 */




public class DublicateElement {

	public static void main(String args[]) {
		int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };

		for (int i = 0; i < numRay.length; i++) {
			numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
		}
		
		for (int i = 0; i < numRay.length; i++) System.out.print(numRay[i]+" ");
		System.out.println("The repeating elements are : ");
		for (int i = 0; i < numRay.length; i++) {
			if (numRay[i] >= numRay.length * 2) {
				System.out.println(i + " ");
			}
		}
	}

}
