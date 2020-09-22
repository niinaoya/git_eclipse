package screen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/inse")
public class Mana2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mana2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Post> Postlist = new ArrayList<Post>();
//
//		request.setCharacterEncoding("UTF-8");
//		String key = request.getParameter("key");
//		Postlist = PostDao.searchDao(key);
//
//		request.setAttribute("list", Postlist);
//
//		String view = "/WEB-INF/view/mana.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		dispatcher.forward(request, response);
		request.setCharacterEncoding("UTF-8");

	    dto.Post p = new dto.Post(0, null, null);

	    p.setName(request.getParameter("name"));
	    p.setContent(request.getParameter("content"));

	    dao.PostDao postdao = new dao.PostDao();

	    postdao.insertDao(p);

	    response.sendRedirect(request.getContextPath() + "/menu");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
