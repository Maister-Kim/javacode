package Ex1;

public class ReserveVo {
	private String reserveNumber;
	private String id;
	private String tourname;

	public ReserveVo() {}
	
	public String getReserveNumber() {
		return reserveNumber;
	}

	public void setReserveNumber(String reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTourname() {
		return tourname;
	}

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	@Override
	public String toString() {
		return "예약번호: " + reserveNumber + ", 투어명: " + tourname;
	}
	
}
