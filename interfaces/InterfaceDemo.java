package com.onebill.corejava.interfaces;

interface Demo{
	void method1();
	void method2();
}

public class InterfaceDemo implements Demo {

	public static void main(String[] args) {
		Demo d = new InterfaceDemo();
		d.method1();
		d.method2();
	}

	@Override
	public void method1() {
		System.out.println("Hi");
	}

	@Override
	public void method2() {
		System.out.println("Hello");
	}

}
