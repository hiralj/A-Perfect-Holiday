package holiday.dal;

import holiday.model.City;
import holiday.model.Travel;
import holiday.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Data access object (DAO) class to interact with the underlying Travel table
 * in your MySQL instance. This is used to store {@link Travel} into your MySQL
 * instance and retrieve {@link Travel} from MySQL instance.
 */
public class TravelDao {
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static TravelDao instance = null;

	protected TravelDao() {
		connectionManager = new ConnectionManager();
	}

	public static TravelDao getInstance() {
		if (instance == null) {
			instance = new TravelDao();
		}
		return instance;
	}

	public Travel create(Travel travel) throws SQLException {

		String createTravel = "INSERT into Travel (Username, CityName, TravelDate) VALUES (?, ?, ?);";
		Connection connection = null;
		PreparedStatement createStmt = null;
		connection = connectionManager.getConnection();

		createStmt = connection.prepareStatement(createTravel,
				Statement.RETURN_GENERATED_KEYS);
		createStmt.setString(1, travel.getUserName().getUserName());
		createStmt.setString(2, travel.getCityName().getCityName());

		createStmt.setTimestamp(3, new Timestamp(travel.getTravelDate()
				.getTime()));

		createStmt.executeUpdate();

		ResultSet resultKeys = createStmt.getGeneratedKeys();
		int travelId = -1;

		if (resultKeys.next()) {
			travelId = resultKeys.getInt(1);
		} else {
			throw new SQLException("Unable to retrieve auto-generated key.");
		}
		travel.setTravelId(travelId);

		return travel;
	}

	/**
	 * Delete the Travel instance. This runs a DELETE statement.
	 */
	public Travel delete(Travel travel) throws SQLException {
		String deleteTravel = "DELETE FROM Travel WHERE TravelId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteTravel);
			deleteStmt.setInt(1, travel.getTravelId());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Travel
			// instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	/**
	 * @param userName
	 * @return List of Travel instance
	 * @throws SQLException
	 */
	public List<Travel> getTravelByUser(User user) throws SQLException {
		List<Travel> travels = new ArrayList<Travel>();
		String selectTravel = "SELECT TravelId,CityName,UserName, TravelDate  FROM Travel WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		CityDao citydao = CityDao.getInstance();
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTravel);
			selectStmt.setString(1, user.getUserName());

			results = selectStmt.executeQuery();

			while (results.next()) {
				int travelId = results.getInt("TravelId");
				String cityName = results.getString("CityName");
				City city = citydao.getCityByCityName(cityName);
				Date date = results.getDate("TravelDate");
				Travel travel = new Travel(travelId, user, city, date);
				travels.add(travel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return travels;
	}

}
