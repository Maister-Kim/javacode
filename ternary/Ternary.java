package Level1.ternary;

import java.util.ArrayList;

public class Ternary {
    public static int solution(int n) {
    	int answer = 0;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	while(true)
    	{
    		list.add(n%3);
    		n = n/3;
    		if(n ==0)
    			break;
    	}
    	
    	System.out.println(list.size());
    	
    	for(Integer i : list)
    	{
    		System.out.println(i);
    	}
        
    	int result = 0;
    	int count = list.size();
    	
    	for(int i = 1; i <count; i++)
    	{
    		int temp = 1;
    		for(int j = 1; j<i;j++)
    		{
    			temp += temp * 3;
    		}
    		result += temp * list.get(i);
    	}
    	
    	System.out.println(result);
    	
	    return answer;
	}
	public static void main(String[] args) {
		solution(45);
	}
}


/*3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
입출력 예 설명
입출력 예 #1

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45	1200	0021	7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현*/