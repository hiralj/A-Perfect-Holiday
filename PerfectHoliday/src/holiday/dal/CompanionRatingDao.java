/**
 * 
 */
package holiday.dal;

import holiday.model.CompanionRating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Admin
 *
 */
public class CompanionRatingDao {
	protected ConnectionManager connectionManager;

	private static CompanionRatingDao instance = null;

	protected CompanionRatingDao() {
		connectionManager = new ConnectionManager();
	}

	public static CompanionRatingDao getInstance() {
		if (instance == null) {
			instance = new CompanionRatingDao();
		}
		return instance;
	}

	public CompanionRating create(CompanionRating companionRating)
			throws SQLException {
		String insertCompanionRating = "INSERT INTO CompanionRating (Username, CityName, Companion, Rating) VALUES (?, ?, ?, ?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertCompanionRating,
					Statement.RETURN_GENERATED_KEYS);

			insertStmt.setString(1, companionRating.getUser().getUserName());
			insertStmt.setString(2, companionRating.getCity().getCityName());
			insertStmt.setString(3, companionRating.getCompanion().toString());
			insertStmt.setDouble(4, companionRating.getRating());

			insertStmt.executeUpdate();

			ResultSet resultKey = insertStmt.getGeneratedKeys();
			int ratingId = -1;
			if (resultKey.next()) {
				ratingId = resultKey.getInt(1);
			} else {
				throw new SQLException(
						"Companion Rating ID could not be fetched");
			}

			companionRating.setCompanionRatingId(ratingId);

			return companionRating;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
		}
	}
}
