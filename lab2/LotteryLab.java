package lab2_hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

import lab2_hw.NumberGenerator;
import lab2_hw.LotteryTicket;

public class LotteryLab {

	private static int[] winningNumbers = { 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) throws Exception {

		
		/**
		 * TODO Parse the arguments 'from', 'to', 'count'.
		 *
		 * - Your code here -
		 *
		 */
		
		int from = Integer.parseInt(args[0]);
		int to = Integer.parseInt(args[1]);
		int count = Integer.parseInt(args[2]);
		
		NumberGenerator selecter = new NumberGenerator();
		winningNumbers = selecter.generateWinningNumbers(from, to, count);
		
		/**
		 * TODO Use number generator's static method to generate the winning
		 * numbers and store it in the winningNumbers variable.
		 *
		 * - Your code here -
		 *
		 */

		// print the winning numbers
		printNumbers("Winning Numbers: ", winningNumbers);

		// create a scanner for input
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		// print the user interaction message
		System.out
				.println("Please enter your ticket numbers: (ex:'1 2 3 4 5 6')");
		String inputString = "";

		// read a line and create a new ticket from input string
		while (!(inputString = reader.readLine()).equals("quit")) {

			/**
			 * TODO The input numbers string is stored in the inputString. (You
			 * need to split the string first, and then convert the string
			 * number into integer)
			 *
			 * Create a lottery ticket with the number you picks and raffle it.
			 *
			 * - Your code here -
			 *
			 */
			
			String[] inputSplits = inputString.split(" ");
			
			int[] inputInt = new int[to+1];
			int sum = 0;
			
			for(String i : inputSplits){
				int now = Integer.parseInt(i);
				if(now <= from || now > to)continue;
				if(inputInt[now] == 0)sum++;
				inputInt[now] = 1;
			}
			
			if(sum != count){
				System.out.println("invalid form ( only " + sum +" valid numbers)");
				continue;
			}
			
			int[] numList = new int[count];
			int list_n = 0;
			for(int i = from; i < to; i++){
				if(inputInt[i] == 1)numList[list_n++] = i;
			}
			
			printNumbers("Your ticket numbers: ", numList);
			LotteryTicket myTicket = new LotteryTicket(numList);
			myTicket.raffle(winningNumbers);
			
			// prepare for the next loop
			Thread.sleep(1000);
			System.out
					.println("\nPlease enter your ticket numbers: (ex:'1 2 3 4 5 6')");
		}

		System.out.println("\nGoodbye~");

	}

	private static void printNumbers(String info, int[] numbers) {
		System.out.print(info + " ");
		for (Integer i : numbers)
			System.out.print(i + " ");
		System.out.println();
	}

	private static void printNumbers(String info, String numbers) {
		System.out.println(info + " " + numbers);
	}

}