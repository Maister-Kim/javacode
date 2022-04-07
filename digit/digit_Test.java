package digit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class digit_Test { // 수정중

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = 0, month = 0, day, monthDays = 0; // 년월일
		int ylength, mlength, dlength; // 년월일 자리수 확인용 변수
		String str = ""; // 출력용 변수
		
		while(true)
		{
			do {
				try	{
					System.out.println("연도 4자리 숫자 입력: ");
					year = sc.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("정수형만 입력");
					sc.nextLine();
				}
				
				if(year == 0)
					System.exit(0);
				ylength = (int)Math.log10(year);
				// int형으로 변환해서 확인
				// Math.log10() -> 숫자의 자리수 확인, 0부터 시작해서 자리수를 출력하므로 +1을 해줌
				 
				if ((ylength + 1) != 4) 
				{
	//				System.out.println(length);
					System.out.println("잘못입력");
				} 
				else 
				{
					String count = String.valueOf(year);
					if (count.charAt(0) == '2' || 
						count.charAt(0) == '1' || 
						count.charAt(0) == '0') // 입력한 연도 맨 앞자리만 확인
					{
	//		    		System.out.println(length);
						str += year + "년 ";
						//					System.out.println(year + "년");
		    			break;
					} 
					else 
					{
						System.out.println("잘못입력");
					}
				}
			}while(true);
		
	   		do {
	   			try {
	   				System.out.println("월 입력: ");
	   				month = sc.nextInt();
	   			}catch(InputMismatchException e) {
		   			System.out.println("정수형만 입력");
	   			}
		   		if(month < 0 || month > 12)
		   		{
		   			System.out.println("잘못입력");
		   		}
		   		else
		   		{
		   			monthDays = days[month - 1];
		   			str += month + "월 ";
		   			break;
		   		}
	   		}while(true);
	   		
	   		do {
		   		System.out.println("일 입력: ");
		   		day = sc.nextInt();
		   		
	   			if(month == 2)
		   		{
		   			if((year % 4 == 0) && (year % 100 == 0) || (year % 400 == 0))
		   			{
		   				monthDays = 29; 
		   			}
		   			else
		   			{
		   				monthDays = 28;
		   			}
		   		}
	   			
	   			if(day < 0 || day > monthDays)
		   			System.out.println("다시 입력");
	   			else
	   			{
	   				str += days + "일";
		   			break;
	   			}
	   		}while(true);
	   		
	   		System.out.println(str);
	   		System.out.println();
		}
	}
}
