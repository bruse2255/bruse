package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.woniuxy.Daos.CityDao;
import com.woniuxy.entitys.City;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/city.do")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收请求得参数
		String pid = request.getParameter("pid");
		//调用Dao方法获得数据
		CityDao cityDao = new CityDao();
		List<City> list = cityDao.getCityById(Integer.parseInt(pid));
		//将数据放入json数组中
		JSONArray cityArray = new JSONArray(list);
		//设置响应内容格式和编码格式
		response.setContentType("text/html;charset=utf-8");
		//json数组输出到客户端浏览器
		PrintWriter out = response.getWriter();
		out.print(cityArray);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
