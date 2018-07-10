// Sean Szumlanski
// COP 3503, Fall 2016

// ==============================
// SneakyKnights: TestCase05.java
// ==============================
// A small test case in which at least two of the knights can attack one another.


import java.io.*;
import java.util.*;

public class TestCase05
{
	private static void checkTest(boolean success)
	{
		System.out.println(success ? "Hooray!" : "fail whale :(");
	}

	public static void main(String [] args) throws Exception
	{
		Scanner in = new Scanner(new File("input_files/TestCase05-input.txt"));
		ArrayList<String> list = new ArrayList<String>();

		// Read each line from the input file into the ArrayList.
		while (in.hasNext())
			list.add(in.next());

		checkTest(SneakyKnights.allTheKnightsAreSafe(list, 10) == false);
	}
}
