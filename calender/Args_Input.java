package calender;

public class Args_Input {

	public static void main(String[] args) {
		
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = 0, month = 0, monthDays = 0, totalDays = 0;
		int firstDay = 0, daysOfWeek = 0, daysOfMonth = 0;
		
		if(args.length != 2)
		{
			System.out.println("변수가 맞지 않음");
			System.out.println("임의로 2015년 3월로 입력");
			return;
		}
		else
		{
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		}
		
		//전년 까지의 총 일수 계산
		totalDays = (year-1) * 365;
		totalDays += (year-1) / 4;
		totalDays -= (year-1) / 100;
		totalDays += (year-1) / 400;
		
		
		// 설정한 달의 바로전 달까지의 일수 합산
		for(int i = 1; i < month; i++)
		{
			// 윤달 계산해서 입력
			if (i == 2)
			{ 
				if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 
				{ 
		                monthDays=29; 
		        }
				else
				{ 
		               monthDays=28; 
		        } 
			}
			else
			{
				monthDays = days[i-1];
			}
			
			// 총 일수에 더함
			totalDays += monthDays;
		}
		
		
		// 다음달 1일이 시작일이므로 1을 더함
		
		totalDays =  totalDays + 1;
		
		System.out.println(" " + year + "년 " + month + "월"); 
	    System.out.println(" sun mon thu wed thr fri sat"); 
	    System.out.println("------------------------------"); 
	    
	    firstDay = totalDays % 7;
	    
   	  //해당의 월의 첫째 날 요일이 일요일이 아닌 경우 앞 부분을 공백으로 채운다.
	    for (int i = 0; i < firstDay; i++) 
	    {  
		    System.out.print("   *"); 
		    daysOfWeek++; 
	    } 
		   
	    // 지정한 달의 일수 확인해서 입력
	    if(month == 2) 
		{
			if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 
			{ 
//	                monthDays=29; 
				daysOfMonth = 29;
	        }
			else
			{ 
//	               monthDays=28; 
	               daysOfMonth = 28;
	        } 
		}
		else
		{
//			monthDays = days[month-1];
			daysOfMonth = days[month-1];
		}
	    
//	    daysOfMonth = monthDays;
	    
		for (int i = 1; i <= daysOfMonth; i++) 
		{ 
			if (i < 10) {
				System.out.print("   " + i);
			} else {
				System.out.print("  " + i);
			}
			daysOfWeek++;
			if (daysOfWeek % 7 == 0) {
				System.out.println();
				daysOfWeek = 0;
			}
		} // end for문
	    
	}
}
