package userRegistration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userRegistration.dao.UserDAO;
import userRegistration.model.User;

/**
 * Servlet implementation class GetUser
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get user start..");
		Connection con = null;
		PreparedStatement pstmt = null;
		User u = null;

		try {
			con = UserDAO.getConnection();
			System.out.println("Connection succes..");
			pstmt = con.prepareStatement("select * from APP.UserData where id=?");
			System.out.println("Statemet created..");
			pstmt.setInt(1,Integer.parseInt(request.getParameter("id").toString()));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
					int Id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phonenum = rs.getString("phonenum");
					String country = rs.getString("country");
					u = new User(Id, name, email, phonenum, country);
					System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("user", u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditUser.jsp");
		dispatcher.forward(request, response);
		System.out.println("get user end");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
