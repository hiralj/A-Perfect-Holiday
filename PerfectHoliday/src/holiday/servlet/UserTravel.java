package holiday.servlet;

import holiday.dal.CityDao;
import holiday.dal.TravelDao;
import holiday.model.City;
import holiday.model.Travel;
import holiday.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserTravel
 */
@WebServlet("/UserTravel")
public class UserTravel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserTravel() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object mayBeUser = session.getAttribute("user");

		if (mayBeUser == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}

		String cityName = request.getParameter("cityname");
		request.setAttribute("cityName", cityName);
		String success = "";
		request.setAttribute("success", success);
		request.getRequestDispatcher("/UserTravel.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object mayBeUser = session.getAttribute("user");

		if (mayBeUser == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}

		User user = (User) mayBeUser;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date travelDate = null;
		try {
			travelDate = sdf.parse(request.getParameter("travelDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String cityName = request.getParameter("cityName");
		City city = null;
		try {
			city = CityDao.getInstance().getCityByCityName(cityName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Travel travel = new Travel(user, city, travelDate);

		try {
			TravelDao.getInstance().create(travel);
		} catch (SQLException e) {
			e.printStackTrace();
			String success = "Exception occured";
			request.setAttribute("success", success);
			request.getRequestDispatcher("/UserTravel.jsp").forward(request,
					response);
		}
		String success = "Thank you. Let us know your review about the place when you return :-)";
		request.setAttribute("success", success);
		request.getRequestDispatcher("/UserTravel.jsp").forward(request,
				response);
	}

}
