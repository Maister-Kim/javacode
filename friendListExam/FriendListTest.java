package friendListExam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FriendListTest {
	public static void SaveFile()
	{
		// 종료시 파일로 출력
		ObjectOutputStream oos = null;
	    FileOutputStream fos = null;
	    Friend fr = new Friend();
	    
	    try {
			fos = new FileOutputStream("d:\\temp\\friend.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(fr);
			oos.flush();
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 시작시 파일에서 불러오기
	public static void ReadFromFile() {
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    File f1 = new File("d:\\temp\\friend.txt");
	    
	    if(f1.exists())
	    {
		    try {
				fis = new FileInputStream("d:\\temp\\friend.txt");
				ois = new ObjectInputStream(fis);
				
//				for(int i=0;i<fr.list.size();i++)
//				{
//					fr = (Friend)ois.readObject();
//					System.out.println(fr.getName() + fr.getTel() + fr.getAddress());
//				}
				Friend fr1 = (Friend)ois.readObject();
				System.out.println(fr1);
				
				
				ois.close();
				fis.close();
								
//				fr.Display();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	    else
	    	System.out.println("파일이 없습니다.");
	}
	
	public static void main(String[] args){
		Friend fr = new Friend();
		int input = 0;

		ReadFromFile();
		
		while(true)
		{
			System.out.println("1.등록: 2. 전체보기 3. 종료: ");
			input = InputM.IntData();
			InputM.StringData();
			
			switch(input)
			{
				case 1:
					fr.inputInfo();					
					break;
				case 2:
					fr.Display();
					break;
				case 3:
					SaveFile();
					System.exit(0);
			}
			
		}
	}
}
