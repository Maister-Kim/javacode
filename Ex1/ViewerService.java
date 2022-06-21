package Ex1;

import java.util.List;
import java.util.Vector;

public class ViewerService {
	Dao dao;
	
	public ViewerService() {
		dao = new Dao();
	}
	
	public void viewAllTourList()
	{
		List<TourVo> list = new Vector<TourVo>(); 
		list = dao.allTourlist();
		
		System.out.println(list.size());
		for(TourVo tv : list)
		{
			System.out.println(tv);
		}
	}
	
	public TourVo viewSelectList(String name)
	{
		List<TourVo> list = new Vector<TourVo>();
		TourVo tvo = null;
		list = dao.findTour(name);
		
		System.out.println(list.size());
		for(TourVo tv : list)
		{
			System.out.println(tv);
			tvo = tv;
		}
		return tvo;
	}
	
	public ReserveVo viewReserveList(MemeberVo vo)
	{
		List<ReserveVo> list = new Vector<ReserveVo>();
		ReserveVo rvo = null;
		list = dao.reservationList(vo);
		
		System.out.println(list.size());
		for(ReserveVo rvo1 : list)
		{
			System.out.println(rvo1);
			rvo = rvo1;
		}
		return rvo;
	}
	
}
