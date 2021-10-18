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
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		System.out.println("do post start ...");
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = UserDAO.getConnection();
            System.out.println("connection sucess");
			pstmt = con.prepareStatement("insert into APP.UserData (id,Name,Email,Phonenum,Country) values(?, ?, ?, ?, ?)");
			System.out.println("statement created");
			pstmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			pstmt.setString(2, request.getParameter("Name").toString());
			pstmt.setString(3, request.getParameter("Email").toString());
			pstmt.setString(4, request.getParameter("Phonenum").toString());
			pstmt.setString(5, request.getParameter("Country").toString());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			request.setAttribute("UserAddMsg", "User added succesfully....");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayUsers");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
