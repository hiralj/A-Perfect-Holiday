package holiday.model;
/**
 * 
 */

import java.util.Date;

public class Travel {
	private int travelId;
	private User userName;
	private City cityName;
	private Date travelDate;

	/**
	 * @param travelId
	 * @param userName
	 * @param cityName
	 * @param hotelId
	 * @param travelDate
	 */
	public Travel(int travelId, User userName, City cityName, Date travelDate) {
		super();
		this.travelId = travelId;
		this.userName = userName;
		this.cityName = cityName;
		this.travelDate = travelDate;
	}
		

	public Travel(User userName, City cityName, Date travelDate) {
		super();
		this.userName = userName;
		this.cityName = cityName;
		this.travelDate = travelDate;
	}



	/**
	 * Getters and Setters
	 */
	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}

	public City getCityName() {
		return cityName;
	}

	public void setCityName(City cityName) {
		this.cityName = cityName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

}
