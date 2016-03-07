package lab2_hw;

public class LotteryTicket {
	private int[] pickedNumbers = new int[100];
	
	public LotteryTicket(int numbers[]){
		pickedNumbers = numbers;
	}
	
	public void raffle(int winningNumbers[]){
		int match = 0;
		
		for(int i : pickedNumbers){
			for(int j : winningNumbers){
				if(i == j){
					match++;
				}
			}
		}
		
		if(match == winningNumbers.length)System.out.println("You are millionare now!");
		else System.out.println("match " + match + " numbers orz...");
	}
}
