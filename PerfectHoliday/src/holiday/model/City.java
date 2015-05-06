package holiday.model;

import holiday.model.Enumerations.Region;

import java.util.Date;

public class City {
	private String cityName;
	private String description;
	private String photo;
	private Enumerations.Region region;
	private Admin admin;
	private Date timestamp;
	private double interestRating;
	private double companionRating;

	public City(String cityName, String description, String photo,
			Region region, Admin admin, Date timestamp) {
		super();
		this.cityName = cityName;
		this.description = description;
		this.photo = photo;
		this.region = region;
		this.admin = admin;
		this.timestamp = timestamp;
	}

	public City(String cityName, String description, String photo,
			Region region, Admin admin) {
		super();
		this.cityName = cityName;
		this.description = description;
		this.photo = photo;
		this.region = region;
		this.admin = admin;
	}

	public City(String cityName, String description, String photo,
			double interestRating, double companionRating) {
		super();
		this.cityName = cityName;
		this.description = description;
		this.photo = photo;
		this.interestRating = interestRating;
		this.companionRating = companionRating;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Enumerations.Region getRegion() {
		return region;
	}

	public void setRegion(Enumerations.Region region) {
		this.region = region;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getInterestRating() {
		return interestRating;
	}

	public void setInterestRating(double interestRating) {
		this.interestRating = interestRating;
	}

	public double getCompanionRating() {
		return companionRating;
	}

	public void setCompanionRating(double companionRating) {
		this.companionRating = companionRating;
	}

}
