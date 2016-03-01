package lab2_hw;

public class NumberGenerator {
	
	public static int[] generateWinningNumbers(int from, int to, int count){
		double random = Math.random();
		int[] num = new int[100];
		for(int i = 0; i < count; i++){
			num[i] = count+(from-to)*(int)random;
			for(int j = 0; num[j]!=0; j++){
				if(num[j] == num[i]){
					i--;
					break;
				}
			}
		}
		return num;
	}
}
