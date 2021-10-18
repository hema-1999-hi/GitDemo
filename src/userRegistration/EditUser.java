package userRegistration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userRegistration.dao.UserDAO;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("EDit user start...");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = UserDAO.getConnection();
			System.out.println("Connction sucess..");
			pstmt = con.prepareStatement("UPDATE APP.UserData SET Name=?, Email=?, Phonenum=?, Country=? where id=?");
			System.out.println("statement created..");
			pstmt.setString(1, request.getParameter("Name").toString());
			pstmt.setString(2, request.getParameter("Email").toString());
			pstmt.setString(3, request.getParameter("Phonenum").toString());
			pstmt.setString(4, request.getParameter("Country").toString());
			pstmt.setInt(5, Integer.parseInt(request.getParameter("id")));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("UserUpdateMsg", "User updated successfullyy...");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayUsers");
		dispatcher.forward(request, response);
		System.out.println("Edit user end...");
	}

}
