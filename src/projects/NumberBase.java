package projects;

import java.util.Scanner;

/**
 * Class performs number base conversions
 * 
 * @author Andrew Olesak
 * @version September 3, 2016
 */
public class NumberBase {

	private static char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * Method converts a number from a given base to another base respectfully
	 * @param input a string of the number to be converted
	 * @param base_in an integer representing the current base of the input
	 * @param base_out an integer representing the base that the input will be converted to
	 * @return
	 */
	public static String convert(String input, int base_in, int base_out) {

		if (input == "") {
			throw new IllegalArgumentException("You didn't enter anything as input.");
		}

		int decimal = 0;
		int power = 0;
		for (int i = input.length() - 1; i > -1; i--) {
			int counter = 0;
			while (input.charAt(i) != numbers[counter]) {
				counter++;

				if (counter >= base_in) {
					throw new IllegalArgumentException("That was not the correct Base.");
				}
			}

			decimal += counter * (int) Math.pow(base_in, power);
			power++;
		}
		String newBase = "";
		int digit = 0;
		if (decimal == 0) {
			return "0";
		}
		while (decimal != 0) {
			digit = decimal % base_out;
			newBase += numbers[digit];
			decimal = (int) (decimal / base_out);
		}
		String finalBase = "";
		for (int i = newBase.length() - 1; i > -1; i--) {
			finalBase += newBase.charAt(i);
		}
		return finalBase;
	}

	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a number: ");
			String number = scnr.next();
			System.out.print("Enter the base of the current number: ");
			int baseIn = scnr.nextInt();
			System.out.print("Enter the base to convert to: ");
			int baseOut = scnr.nextInt();
			String str = NumberBase.convert(number, baseIn, baseOut);
				System.out.println(number + " in base " + baseIn + " is " + str + " in base " + baseOut + "\n");
			
		}
	}
}
