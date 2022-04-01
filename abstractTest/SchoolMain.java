package abstractTest;

public class SchoolMain {

	public static void main(String[] args) {
		DataManager dm = new DataManager();
		
		boolean bool = false;
		int input = 0;
		
		while(true)
		{
			do {
				try{
					Menu.mainMenu();
					input = inputData.inputInt();
					bool = false;
				}catch(Exception e){
					inputData.inputString();
					System.out.println("잘못입력");
					bool = true;
				}
			}while(bool);
			
			switch(input)
			{
				case 1:
					System.out.println("등록");
					dm.register();
					break;
				case 2:
					System.out.println("검색");
					dm.search();
					break;
				case 3:
					System.out.println("삭제");
					dm.delete();
					break;
				case 4:
					System.out.println("출력");
					dm.print();
					break;
				case 5:
					System.out.println("종료");
					System.exit(0); // 무한루프 종료
				default:
					System.out.println("잘못입력");
			}
		}
	}
}
