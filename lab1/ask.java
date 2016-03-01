package lab1;

import java.util.Scanner;

public class ask {

	public static void main( String[] args )
	{
	// TODO: Create an instance of Student class.
		student s = new student();
	// Give this student a name.
	// TODO: Change the name.
		Scanner scanner = new Scanner(System.in);

		s.setName(scanner.next());

	// Call the introduce method.
		s.introduce();
	}
}

