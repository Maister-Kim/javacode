package array;

import java.util.Scanner;

public class ArrayTest_09 {
	
	public static void starprint(int count)
	{
		for(int i=0;i<count;i++)
		{
			System.out.print('*');
		}
	}
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("학생수 입력");
//		int num = sc.nextInt();
		
		int[] gradeArr = {87,68,94,100,83,78,85,91,76,87};
		
		int sum = 0, minNum = 9999, maxNum = 0;
		
		for(int i=0;i<gradeArr.length;i++)
		{
			System.out.printf("Student %2d:%3d\n",i+1, gradeArr[i]);
			if(gradeArr[i] > maxNum)
				maxNum = gradeArr[i];
			if(gradeArr[i] < minNum)
				minNum = gradeArr[i];
			sum += gradeArr[i];
		}
//		System.out.println(arr[1]);
		System.out.println();
		
		System.out.printf("평균 : %.2f\n\n", ((double)sum / gradeArr.length));
		System.out.printf("최대점수: %d\n최소점수: %d\n", maxNum, minNum);
		
		System.out.println("------점수분포도------");
		int[] frequency = new int[11];
		
		for(int grade : gradeArr)
		{
			++frequency[grade/10];
		}
		
		for(int count=0;count<frequency.length;count++)
		{
			if(count == 10)
			{
				System.out.printf("\n%5d: ", 100);
				starprint(frequency[count]);
			}
			else if(count == 9)
			{
				System.out.printf("\n%5d ~ %5d: ", 90, 99);
				starprint(frequency[count]);
			}
			else if(count == 8)
			{
				System.out.printf("\n%5d ~ %5d: ", 80, 89);
				starprint(frequency[count]);
			}
			else if(count == 7)
			{
				System.out.printf("\n%5d ~ %5d: ", 70, 79);
				starprint(frequency[count]);
			}
			else if(count == 6)
			{
				System.out.printf("\n%5d ~ %5d: ", 60, 69);
				starprint(frequency[count]);
			}
			else if(count == 5)
			{
				System.out.printf("\n%5d ~ %5d: ", 50, 59);
				starprint(frequency[count]);
			}
			else if(count == 4)
			{
				System.out.printf("\n%5d ~ %5d: ", 40, 49);
				starprint(frequency[count]);
			}
			else if(count == 3)
			{
				System.out.printf("\n%5d ~ %5d: ", 30, 39);
				starprint(frequency[count]);
			}
			else if(count == 2)
			{
				System.out.printf("\n%5d ~ %5d: ", 20, 29);
				starprint(frequency[count]);
			}
			else if(count == 1)
			{
				System.out.printf("\n%5d ~ %5d: ", 10, 19);
				starprint(frequency[count]);
			}
			else if(count == 0)
			{
				System.out.printf("\n%5d ~ %5d: ", 0, 9);
				starprint(frequency[count]);
			}
		}
		
	}
}
