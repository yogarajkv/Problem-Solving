package com.map.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEven {

	AtomicInteger a = new AtomicInteger(1);

	public void printEven() {
		synchronized (a) {

			try {
				if (a.get() % 2 == 0)
					System.out.println(a.getAndIncrement() + " :" + Thread.currentThread().getName());

				a.notify();
				a.wait();
			} catch (InterruptedException e) {

			}

		}
	}

	public void printOdd() {
		synchronized (a) {

			try {
				if (a.get() % 2 != 0)
					System.out.println(a.getAndIncrement() + " :" + Thread.currentThread().getName());

				a.notify();
				a.wait();
			} catch (InterruptedException e) {

			}

		}
	}

	public static void main(String[] args) {

		final OddEven e = new OddEven();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				while (true) {
					e.printEven();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		};
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					e.printOdd();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		};
		new Thread(r, "Even").start();
		new Thread(r1, "Odd").start();
	}

}
