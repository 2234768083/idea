package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.rowset.CachedRowSetImpl;

import javabean.Conn;
import javabean.MessageBoardData;
import javabean.recentProductData;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CachedRowSetImpl rowSet=null;//CachedRowSetImpl对象
	Conn conn = new Conn();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at(get): ").append(request.getContextPath());
				Connection con=null;
				Statement sql=null;
				ResultSet rs=null;
				recentProductData dataBean=null;
				//HttpSession session=request.getSession(true);//创造一个新session，我们确认session一定存在或者sesson不存在时明确有创建session的需要才用，否则尽量使用request.getSession(false)。
				ServletContext application = null;//创造一个新application，作为留言板是全局共享的
				application = request.getSession().getServletContext();
				/*创建javaBean对象*/
				try {
					//dataBean= (MessageBoardData)session.getAttribute("dataBean");
					dataBean=(recentProductData) application.getAttribute("recentProductData");
					if(dataBean==null) {
						dataBean=new recentProductData();
						//session.setAttribute("dataBean", dataBean);	
						application.setAttribute("recentProductData", dataBean);
					}
				}catch(Exception e) {
					dataBean=new recentProductData();
					//session.setAttribute("dataBean", dataBean);	
					application.setAttribute("recentProductData", dataBean);
				}
				try {
					con=conn.getConnection();//获取Conn类的函数返回已经初始化好的的Connection对象
					sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//声明sql语句对象，并使type取值。
					rs=sql.executeQuery("Select * from product Where pname='天目小香薯' order by pupdatetime DESC;");//留言相关信息存在messageboard表中

					while(rs.next()){
						// 通过字段检索
						int MBnum  = rs.getInt("Pnum");

						// 输出数据
						System.out.print("MBnum: " + MBnum);
						System.out.print("\n");
					}
					rowSet=new CachedRowSetImpl();//创造行集对象
					rowSet.populate(rs);
					dataBean.setRowSearchrowSet(rowSet);;//行集数据存储到dataBean
					con.close();//关闭连接
					}catch(SQLException e) {    
				}
				response.sendRedirect("SearchProduct.jsp");
				//RequestDispatcher dispatcher=request.getRequestDispatcher("Message-board.jsp");
				//重定向和跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection con=null;
		Statement sql=null;
		ResultSet rs=null;
		String condition="";
		
		request.setCharacterEncoding("UTF-8");//这里编码设为大写的UTF-8即可
		String Search=request.getParameter("Search").trim();//只能输入产品名字 trim()去掉获取中的多余的空格
		recentProductData dataBean=null;
		//HttpSession session=request.getSession(true);//创造一个新session，我们确认session一定存在或者sesson不存在时明确有创建session的需要才用，否则尽量使用request.getSession(false)。
		ServletContext application = null;//创造一个新application，作为留言板是全局共享的
		application = request.getSession().getServletContext();
		/*创建javaBean对象*/
		try {
			//dataBean= (MessageBoardData)session.getAttribute("dataBean");
			dataBean=(recentProductData) application.getAttribute("recentProductData");
			if(dataBean==null) {
				dataBean=new recentProductData();
				//session.setAttribute("dataBean", dataBean);	
				application.setAttribute("recentProductData", dataBean);
			}
		}catch(Exception e) {
			dataBean=new recentProductData();
			//session.setAttribute("dataBean", dataBean);	
			application.setAttribute("recentProductData", dataBean);
		}
		try {
			condition="Select * from Product where Pname LIKE '%"+Search+"%';";
			con=conn.getConnection();//获取Conn类的函数返回已经初始化好的的Connection对象
			sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//声明sql语句对象，并使type取值。
			rs=sql.executeQuery(condition);//留言相关信息存在messageboard表中
			
			rowSet=new CachedRowSetImpl();//创造行集对象
			rowSet.populate(rs);
			dataBean.setRowSearchrowSet(rowSet);;//行集数据存储到dataBean
			
			con.close();//关闭连接
			}catch(SQLException e) {    
		}
		response.sendRedirect("SearchProduct.jsp");
	}

}
