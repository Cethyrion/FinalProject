package edu.neumont.csc110.finalproject.group05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Methods {

	private static final int CHAR_VAL_NUM_MIN = 48, CHAR_VAL_NUM_MAX = 57;

	private static Scanner in = new Scanner(System.in);
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

	private static Boolean answer = false;
	private static String input;
	private static Date dateFormat;
	private static String newDateString;

	public Methods() {

	}

	public static String getValidInput(String question) {
		System.out.println(question);
		boolean valid = false;

		do {

			// CS110 Requirement 1: Console I/O

			input = in.nextLine();

			if (!input.isEmpty()) {
				valid = true;
			} else {
				System.out.println("\nNo valid input. " + question);
			}
		} while (!valid);

		return input.trim();
	}

	public static int getValidInteger(String question, int min, int max) {
		System.out.println(question);

		// CS110 Requirement 2: Primitive Types (ex. int & boolean)

		boolean valid = false;
		int num = 0;
		do {
			input = in.nextLine();

			input = onlyNum(input);

			if (!input.isEmpty()) {
				num = Integer.parseInt(input);

				if (num >= min && num <= max) {
					valid = true;
				} else {
					System.out.println("Out of range. " + question);
				}
			} else {
				System.out.println("No valid input. " + question);
			}
		} while (!valid);

		return num;
	}

	private static String onlyNum(String input) {
		String temp = "";

		// CS110 Requirement 4: Iteration - for loop

		for (int x = 0; x < input.length(); x++) {
			if (input.charAt(x) >= CHAR_VAL_NUM_MIN && input.charAt(x) <= CHAR_VAL_NUM_MAX) {
				temp += input.charAt(x);
			}
		}

		return temp;
	}

	// CS110 Requirement 12: Error (User Input Validation)

	public static Date getValidDateInput(String question) {
		System.out.println(question);
		System.out.println("Ex. MM/DD/YYYY, 1/1/1111, 01/01/1111");

		input = in.nextLine();

		String regex = "(0?[1-9]|[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/([0-9]{4}$)";
		/*
		 * limits input months 1 - 12, limits days 1-31, limits year to 4 digits
		 */

		while (!input.matches(regex)) {

			System.out.println("Please enter a date.\nEx. MM/DD/YYYY, 1/1/1111, 01/01/1111\n" + question);
			input = in.nextLine();
		}

		try {
			dateFormat = formatter.parse(input);
			newDateString = formatter.format(dateFormat);
		} catch (ParseException e) {
		}

		return dateFormat;
	}

	// CS110 Requirement 6: Methods / Fuctions

	public static boolean getConfirmation(String question) {
		question += " (yes or no)";
		System.out.println(question);
		boolean valid = false;
		answer = false;

		// CS110 Requirement 4: Iteration - do while loop

		do {
			String confirmation = in.nextLine();

			if (!confirmation.isEmpty()) {
				switch (confirmation.toLowerCase()) {
				case "yes":
				case "y":
					answer = true;
					valid = true;
					break;
				case "no":
				case "n":
					valid = true;
					break;
				default:
					System.out.println("\nUnrecognizable input. " + question);
				}
			} else {
				System.out.println("\nNo valid input. " + question);
			}
		} while (!valid);

		return answer;
	}

	public static void pauseOn(String line, boolean clearScreen) {
		if (!line.isEmpty()) {
			System.out.println("\n" + line);
		}
		System.out.println("Enter to continue");
		in.nextLine();

		if (clearScreen) {
			clearScreen();
		}
	}

	public static void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}

	public static String getLastInput() {
		return input;
	}

	public static boolean getAnswer() {
		return answer;
	}

	public static Date getLastDateInput() {
		return dateFormat;
	}

	public static String getLastDateString() {
		return newDateString;
	}

}
