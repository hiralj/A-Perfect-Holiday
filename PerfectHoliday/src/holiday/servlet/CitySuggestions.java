package holiday.servlet;

import holiday.dal.CityDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CitySuggestions
 */
@WebServlet("/CitySuggestions")
public class CitySuggestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CitySuggestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cityName = request.getParameter("cityName");
		CityDao cityDao = CityDao.getInstance();
		List<String> citySuggestions = null;
		try {
			citySuggestions = cityDao.getMatchingCities(cityName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cities", citySuggestions);
		request.getRequestDispatcher("/CitySuggestions.jsp").forward(request,
				response);
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
