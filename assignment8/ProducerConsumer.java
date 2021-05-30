package com.onebill.corejava.assignment8;

class storage{
	int product;
	boolean bool = false;
	
	public synchronized void setProduct(int product) {
		while(bool) {
			try {
				System.out.println("Set waiting.....");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Set : " + product);
		this.product = product;
		bool=true;
		notify();
	}
	
	public synchronized void getProduct() {
		while(!bool) {
			try {
				System.out.println("Get waiting.....");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Get : " + this.product);
		bool=false;
		notify();
	}

}

class producer implements Runnable{

	storage S;
	producer(storage st){
		this.S = st;
	}
	
	@Override
	public void run() {
		int i=0;
		while(true) {
			S.setProduct(i++);
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class consumer implements Runnable{

	storage S;
	consumer(storage st){
		this.S = st;
	}
	
	@Override
	public void run() {
		while(true) {
			S.getProduct();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		storage st = new storage();
		producer p = new producer(st);
		consumer c = new consumer(st);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();

	}

}
