package holiday.servlet;

import holiday.dal.ReviewDao;
import holiday.model.Review;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityReview
 */
@WebServlet("/CityReview")
public class CityReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected ReviewDao reviewDao;
	
	@Override
	public void init() throws ServletException {
		reviewDao = ReviewDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
		
		// Retrieve and validate UserName.
        String cityName = req.getParameter("cityname");
        if (cityName == null || cityName.trim().isEmpty()) {
            messages.put("title", "Invalid city name.");
        } else {
        	messages.put("title", "Review for " + cityName);
        }
        
        // Retrieve User, and store in the request.
        List<Review> reviews = new ArrayList<Review>();
        try {
        	reviews = reviewDao.getReviewByCityName(cityName);
        } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
        }
        req.setAttribute("reviews", reviews);
        
        req.getRequestDispatcher("/CityReview.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
