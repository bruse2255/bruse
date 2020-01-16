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

import com.woniuxy.Daos.DistrictDao;
import com.woniuxy.entitys.District;

/**
 * Servlet implementation class DistrictServlet
 */
@WebServlet("/district.do")
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistrictServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得请求参数
		String cid = request.getParameter("cid");
		//调用Dao层方法
		DistrictDao districtDao = new DistrictDao();
		List<District> list = districtDao.getDistrictById(Integer.parseInt(cid));
		//将数据放入json数组中
		JSONArray districtArray = new JSONArray(list);
		//设置响应内容格式和编码格式
		response.setContentType("text/html;charset=utf-8");
		//json数组输出到客户端浏览器
		PrintWriter out = response.getWriter();
		out.print(districtArray);
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
