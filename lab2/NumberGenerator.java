package lab2_hw;

public class NumberGenerator {
	
	public int[] generateWinningNumbers(int from, int to, int count){

		int[] num = new int[to];
		int[] num_list = new int[count];
		for(int i = 0; i < count;){
			double random = Math.random();
			int index_now = (int)(from+(to-from)*random);
			if(num[index_now] == 0){
				num[index_now] = 1;
				i++;
			}
		}
		int list_n = 0;
		for(int i = from; i < to; i++){
			if(num[i] == 1)num_list[list_n++] = i+1;
		}
		return num_list;
	}
}
