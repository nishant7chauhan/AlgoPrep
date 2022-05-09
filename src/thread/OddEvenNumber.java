package thread;

public class OddEvenNumber {

	int counter = 1;
	int N = 20;

	public void printOddNumber() {
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is even then print
				while (counter % 2 == 0) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to second thread
				notify();
			}
		}
	}

	// Function to print even numbers
	public void printEvenNumber() {
		
		synchronized (this) {
			// Print number till the N
			while (counter < N) {

				// If count is odd then print
				while (counter % 2 == 1) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print(counter + " ");

				// Increment counter
				counter++;

				// Notify to 2nd thread
				notify();
			}
		}
	}

	public static void main(String[] args) {

		OddEvenNumber oep = new OddEvenNumber();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printOddNumber();

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				oep.printEvenNumber();

			}
		});

		t1.start();
		t2.start();

	}

}
