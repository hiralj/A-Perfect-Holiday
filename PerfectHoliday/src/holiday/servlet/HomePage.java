package holiday.servlet;

import holiday.dal.AdminDao;
import holiday.dal.PersonDao;
import holiday.dal.TravelDao;
import holiday.dal.UserDao;
import holiday.model.Admin;
import holiday.model.Travel;
import holiday.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePage() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("failure", "");
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.setAttribute("admin", null);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || username.trim().equals("")) {
			request.setAttribute("failure", "Invalid Username");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}

		PersonDao personDao = PersonDao.getInstance();

		try {
			// Authenticate user
			if (!personDao.isAuthenticated(username, password)) {

				request.setAttribute("failure",
						"Username, password does not exist");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			}

			User user = null;
			Admin admin = null;

			HttpSession session = request.getSession();
			UserDao userDao = UserDao.getInstance();
			user = userDao.getUserByUserName(username);
			if (user == null) {
				admin = AdminDao.getInstance().getAdminByUserName(username);
				session.setAttribute("admin", admin);
				session.setAttribute("user", user);
				request.getRequestDispatcher("/AdminHome.jsp").forward(request,
						response);
			} else {
				session.setAttribute("user", user);
				session.setAttribute("admin", admin);

				String userName = user.getUserName();

				// Retrieve User, and store in the request.
				List<Travel> blogPosts = new ArrayList<Travel>();
				try {
					User reviewer = new User(userName);
					blogPosts = TravelDao.getInstance().getTravelByUser(
							reviewer);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
				request.setAttribute("travels", blogPosts);
				request.getRequestDispatcher("/UserTravelHistory.jsp").forward(
						request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
