package netdb.courses.softwarestudio.buggyscorer;

public class ScoreMgr {

	private double scoreList[];

	public ScoreMgr(double[] scoreList) {
		this.scoreList = scoreList;
	}

	public double findMax() {
		double max = scoreList[0];
		for (int i = 0; i < getEnrollStudentNumber() - 1; i++) {
			if (max < scoreList[i + 1])
				max = scoreList[i + 1];
		}
		return max;
	}

	public double findMin() {
		double min = scoreList[0];
		for (int i = 0; i < getEnrollStudentNumber() - 1; i++) {
			if (min > scoreList[i + 1])
				min = scoreList[i + 1];
		}
		return min;
	}

	public double getAvg() {
		double tmp = 0;
		int count = 0;
		while (count < getEnrollStudentNumber()) {
			tmp += scoreList[count++];
		}
		return tmp / (double)getEnrollStudentNumber();
	}

	public void sortScoreList() {
		for (int i = 0; i < getEnrollStudentNumber(); i++)
			for (int j = i + 1; j < getEnrollStudentNumber(); j++) {
				if (scoreList[i] < scoreList[j]) {
					swap(j, i);
				}
			}
	}

	public void printScoreList() {
		for (int i = 0; i < getEnrollStudentNumber(); i++)
			System.out.print(scoreList[i] + " ");
		System.out.println(" ");
	}

	private void swap(int i, int j) {
		double tmp;
		tmp = scoreList[i];
		scoreList[i] = scoreList[j];
		scoreList[j] = tmp;
	}

	public int getFailedStudentNumber(int passScore) {
		int count = 0;
		for (int l = 0; l < getEnrollStudentNumber(); l++) {
			if (scoreList[l] < passScore)
				count = count + 1;
		}
		return count;
	}

	public int getEnrollStudentNumber() {
		return scoreList.length;
	}

	public double getPassRatio(int passScore) {

		return Calculator.div(getEnrollStudentNumber()
				- getFailedStudentNumber(passScore), getEnrollStudentNumber());

	}

}
