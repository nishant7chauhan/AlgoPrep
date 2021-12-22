
package thread;

import java.util.Scanner;

public class InterThreadWaitNotifyAll {

	public void producer1() throws InterruptedException {

		synchronized (this) {
			System.out.print("Producer1 running...\n");
			wait();
			System.out.print("Producer1 resumed...\n");
		}

	}

	public void producer2() throws InterruptedException {

		synchronized (this) {
			System.out.print("Producer2 running...\n");
			wait();
			System.out.print("Producer2 resumed...\n");
		}

	}

	public void consumer() throws InterruptedException {
		Thread.sleep(1000);
		Scanner in = new Scanner(System.in);
		synchronized (this) {
			System.out.print("consumer running...Waiting for return key");
			in.nextLine();
			System.out.println("Return key pressed ");
			Thread.sleep(2000);
			//notify();   // good example check with this condition also
			notifyAll();
			System.out.println("Exiting consumer thread");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		InterThreadWaitNotifyAll obj = new InterThreadWaitNotifyAll();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					obj.producer1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					obj.producer2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					obj.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		t1.start();
		t2.start();
		t3.start();

	}
}
