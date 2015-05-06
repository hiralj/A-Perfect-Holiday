package holiday.servlet;

import holiday.dal.TravelDao;
import holiday.model.Travel;
import holiday.model.User;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserTravelHistory
 */
@WebServlet("/UserTravelHistory")
public class UserTravelHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected TravelDao reviewDao;

	@Override
	public void init() throws ServletException {
		reviewDao = TravelDao.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve and validate UserName.
		HttpSession session = req.getSession();
		Object mayBeUser = session.getAttribute("user");
		if (mayBeUser == null) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			User user = (User) mayBeUser;
			String userName = user.getUserName();
			if (userName == null || userName.trim().isEmpty()) {
				messages.put("title", "Invalid username.");
			} else {
				messages.put("title", "Travel History for " + userName);
			}

			// Retrieve User, and store in the request.
			List<Travel> blogPosts = new ArrayList<Travel>();
			try {
				User reviewer = new User(userName);
				blogPosts = reviewDao.getTravelByUser(reviewer);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			req.setAttribute("travels", blogPosts);
			req.getRequestDispatcher("/UserTravelHistory.jsp").forward(req,
					resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
