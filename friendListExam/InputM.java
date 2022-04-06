package friendListExam;

import java.util.Scanner;

public class InputM {
	static Scanner sc = new Scanner(System.in);
	
	public static int IntData() {
		int num = sc.nextInt();
		return num;
	}
	
	public static String StringData()
	{
		String str = sc.nextLine();
		return str;
	}
}
