package com.ecart.utility;

import java.util.Scanner;

public class InputValidation {

	public static int inputIntegerValidation() {
		Scanner sc = new Scanner(System.in);
		int number;
		do {
			System.out.println("(Please enter a positive number) ::");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!\n" + "Please enter a positive number ::");
				sc.next();
			}
			number = sc.nextInt();
		} while (number <= 0);
		System.out.println("Thank you! " + number + "\n");
		return number;

	}

	public static String inputStringValidation() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNext("[A-Za-z]*")) {
			System.out.println("That's not alphabet " + "\n" + "Please enter an alphabets ::");
			sc.next();
		}
		String name = sc.nextLine();
		System.out.println("Thank you ! " + name);
		return name;
	}

}
