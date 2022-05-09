
package thread;

import java.util.Scanner;

public class InterThreadWaitNotify {

	public void produce() throws InterruptedException {
// synchronized block ensures only one thread running at a time.
		synchronized (this) {
			System.out.println("Producer thread Running");
			// releases the lock on shared resource
			wait();
			// and waits till some other method invokes notify().
			System.out.println("Producer thread Resumed");
		}
	}

// Sleeps for some time and waits for a key press. After key is pressed, it notifies produce().
	public void consume() throws InterruptedException {
// this makes the produce thread to run first.
		Thread.sleep(1000);
		Scanner s = new Scanner(System.in);
// synchronized block ensures only one thread running at a time.
		synchronized (this) {
			System.out.println("Consumer thread running...Waiting for return key.");
			s.nextLine();
			System.out.println("Return key pressed ");
			// notifies the produce thread that it can wake up.
			notify();
			Thread.sleep(2000); // As you might have observed that even after notifying, the control does not
								// immediately passes over to the produce thread. The reason for it being that
								// we have called Thread.sleep() after notify(). As we already know that the
								// consume thread is holding a lock on PC object, another thread cannot access
								// it until it has released the lock. Hence only after the consume thread
								// finishes its sleep time and thereafter terminates by itself, the produce
								// thread cannot take back the control.After a 2 second pause, the program
								// terminates to its completion.
			System.out.println("Exiting consumer thread");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		InterThreadWaitNotify pc = new InterThreadWaitNotify();
// Create a thread object that calls pc.produce()
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

// Create another thread object that calls
// pc.consume()
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

// Start both threads
		t1.start();
		t2.start();

// t1 finishes before t2
		//t1.join();
		//t2.join();
	}

}


/**
 * class Customer{    
int amount=10000;    
    
synchronized void withdraw(int amount){    
System.out.println("going to withdraw...");    
    
if(this.amount<amount){    
System.out.println("Less balance; waiting for deposit...");    
try{wait();}catch(Exception e){}    
}    
this.amount-=amount;    
System.out.println("withdraw completed...");    
}    
    
synchronized void deposit(int amount){    
System.out.println("going to deposit...");    
this.amount+=amount;    
System.out.println("deposit completed... ");    
notify();    
}    
}    
    
class Test{    
public static void main(String args[]){    
final Customer c=new Customer();    
new Thread(){    
public void run(){c.withdraw(15000);}    
}.start();    
new Thread(){    
public void run(){c.deposit(10000);}    
}.start();    
    
}}    
 */










