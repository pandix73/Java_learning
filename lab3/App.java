package netdb.courses.softwarestudio.buggyscorer;

/**
 * A buggy scorer that contains four logical errors.
 * 
 */
public class App {
	public static void main(String[] args) {

		double score[] = { 96.9, 25.59, 75.6, 69.9, 65, 85.75, 88 };
		ScoreMgr scoremgr = new ScoreMgr(score);

		System.out.println("////////MAX//////////");
		System.out.println(scoremgr.findMax());

		System.out.println("////////MIN//////////");
		System.out.println(scoremgr.findMin());

		System.out.println("////////AVG//////////");
		System.out.println(scoremgr.getAvg());

		System.out.println("///FailedStudent#////");
		System.out.println(scoremgr.getFailedStudentNumber(75));

		System.out.println("/////PassRatio///////");
		System.out.println(scoremgr.getPassRatio(75));

		System.out.println("//////UnSortList//////");
		scoremgr.printScoreList();

		System.out.println("//////SortedList//////");
		scoremgr.sortScoreList();
		scoremgr.printScoreList();

	}
}
