package lab2_hw;

public class LotteryTicket {
	private int[] pickedNumbers = new int[100];
	
	public LotteryTicket(int numbers[]){
		pickedNumbers = numbers;
	}
	
	public void raffle(int winningNumbers[]){
		for(int i : pickedNumbers){
			for(int j : winningNumbers){
				if(i == j){
					System.out.print(i);
				}
			}
		}
	}
}
