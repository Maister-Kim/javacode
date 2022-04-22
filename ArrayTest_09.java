package array;

import java.util.Scanner;

public class ArrayTest_09 {
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
				System.out.printf("%5d", 100);
		}
		
	}
}
