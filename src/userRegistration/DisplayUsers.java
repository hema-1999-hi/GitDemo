package userRegistration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userRegistration.dao.UserDAO;
import userRegistration.model.User;
import userRegistration.service.UserService;

/**
 * Servlet implementation class DisplayUsers
 */
@WebServlet("/displayusers")
public class DisplayUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUsers() {
        super();
        // TODO Auto-generated constructor stub 
    }

	/**
	 * This is the starting point of the application.
	 * Will display list of users on the page
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Display user start");
		//2. should call service for DB data 
		UserService service = new UserService();
		List<User> userList = service.getAllUsers();

		request.setAttribute("userlist", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayUser.jsp");
		dispatcher.forward(request, response);

		/*		Connection con = null;
		Statement stmt = null;
		List<User> userlist = new ArrayList<>();
		
		try {
			con = UserDAO.getConnection();
             System.out.println("connection sucess..");
			stmt = con.createStatement();
			String listuser = "select id,Name,Email,Phonenum,Country from APP.UserData";
			ResultSet rs = stmt.executeQuery(listuser);
			while (rs.next()) {
				User u = new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phonenum"),rs.getString("country"));
				userlist.add(u);
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
*/		System.out.println("Display user end ...");
		
	}

	private void getAllUsers() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
