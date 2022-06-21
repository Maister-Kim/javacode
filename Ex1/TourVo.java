package Ex1;

import java.sql.Date;
//import java.util.*;


public class TourVo {
	private String tourName;
	private String departure;
	private String arrival;
	private Date deptDate;
	private Date arrivDate;
	
	public TourVo() {}

	public TourVo(String tourName, String departure, String arrival, Date deptDate, Date arrivDate) {
		this.tourName = tourName;
		this.departure = departure;
		this.arrival = arrival;
		this.deptDate = deptDate;
		this.arrivDate = arrivDate;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Date getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(Date deptDate) {
		this.deptDate = deptDate;
	}

	public Date getArrivDate() {
		return arrivDate;
	}

	public void setArrivDate(Date arrivDate) {
		this.arrivDate = arrivDate;
	}

	@Override
	public String toString() {
		return "투어명: " + tourName + ", 출발지: " + departure + ", 도착지: " + arrival + ","
				+ " 출발일: " + deptDate + ", 도착일: " + arrivDate;
	}
	
	
}
