package digit;

import java.util.Scanner;

public class digit_Test { // 수정중

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int year, month, days; // 년월일
		int ylength, mlength, dlength; // 년월일 자리수 확인용 변수
		
		while(true)
		{
			String str = ""; // 출력용 변수
			System.out.println("연도 4자리 숫자 입력: ");
			year = sc.nextInt();
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
//					System.out.println(year + "년");
					str += year + "년 ";
//	    			return;
				} 
				else 
				{
					System.out.println("잘못입력");
				}
			}
    		System.out.println("월 입력: ");
    		month = sc.nextInt();
    		if(month < 0 && month > 12)
    		{
    			System.out.println("잘못입력");
    		}
    		else
    		{
    			str += month + "월 ";
    		}
    		
    		System.out.println("일 입력: ");
    		days = sc.nextInt();
    		if(days < 0 && days > 31)
    		{
    			System.out.println("다시 입력");
    		}
    		else
    		{
    			str += days + "일";
    		}
    		System.out.println(str);
    		return;
		}
	}
}
