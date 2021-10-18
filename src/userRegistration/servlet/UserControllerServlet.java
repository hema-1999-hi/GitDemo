package userRegistration.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userRegistration.dao.UserDAO;
import userRegistration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userreg")
public class UserControllerServlet extends HttpServlet {
//	private static Logger log = LogManager.getLogger(UserControllerServlet.class);
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init(){
		userDAO = new UserDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doget()....");
		String action = request.getParameter("action");
		// to make sure not null
		action = (null==action )?"default":action;
		System.out.println("action : "+action);
		try{
			switch (action) {
			case "add" :
				showAddUserForm(request, response);
				break;
			case "/insert" :
				insertUser(request, response);
				break;
			case "/delete" :
				deleteUser(request, response);
				break;
			case "/edit" :
				editUser(request, response);
				break;
			case "/update" :
				updateUser(request, response);
				break;
			default :
				listUser(request,response);
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("Name").toString();
		String email = request.getParameter("Email").toString();
		String Phonenum =request.getParameter("Phonenum").toString();
		String country =request.getParameter("Country").toString();
		User user = new User(id,name,email,Phonenum,country);
		userDAO.updateUser(user);
		response.sendRedirect("list");
	}
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayUser.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
		
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("Name").toString();
		String email = request.getParameter("Email").toString();
		String Phonenum =request.getParameter("Phonenum").toString();
		String country =request.getParameter("Country").toString();
		User newUser = new User(id,name,email,Phonenum,country);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listUser()....");

		List<User> listUser = userDAO.selectAllUsers();
		
		request.setAttribute("listUsers", listUser);
		System.out.println("forwarding to display user jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayUser.jsp");
		dispatcher.forward(request, response);
	}
	private void showAddUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto generated rollnum
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerUser.jsp");
		dispatcher.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
