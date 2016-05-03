package com.thread.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPractice {

	AtomicInteger count = new AtomicInteger(1);
	Object lock = new Object();

	public void printEven() throws InterruptedException {

		synchronized (lock) {
			lock.notify();
			lock.wait();
			if (count.get() % 2 == 0) {
				System.out.println(Thread.currentThread().getName()+ count.get());
			}
			count.getAndIncrement();
		}

	}

	public void printOdd() throws InterruptedException {

		synchronized (lock) {

			if (count.get() % 2 == 0) {
				count.getAndIncrement();
			}

			if (count.get() % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + count.get());
			}
			count.getAndIncrement();

			lock.notify();
			lock.wait();
		}
	}

	public static void main(String[] args) {

		final OddEvenPractice obj = new OddEvenPractice();

		Thread t1 = new Thread("Even") {

			public void run() {

				int i = 0;
				while (i < 5) {
					try {
						obj.printEven();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}

		};

		Thread t2 = new Thread("Odd") {

			public void run() {

				int i=0;
				while (i < 5) {
					try {
						obj.printOdd();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}

			}

		};

		/*Thread t3 = new Thread("Third") {

			public void run() {

				int i=0;
				while (i < 5) {
					try {
						obj.printOdd();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}

			}

		};*/

		t1.start();
		t2.start();
	//	t3.start();

	}

}
