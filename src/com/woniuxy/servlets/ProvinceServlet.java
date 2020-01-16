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

import com.woniuxy.Daos.ProvinceDas;
import com.woniuxy.entitys.Province;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/province.do")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("已到达服务器");
		
		//调用dao层方法显示所有数据
		ProvinceDas provinceDas = new ProvinceDas();
		List<Province> list = provinceDas.getAllProvince();
		//将数据放入json数组中
		JSONArray provinceArray = new JSONArray(list);
		//设置响应内容格式和编码格式
		response.setContentType("text/html;charset=utf-8");
		//json数组输出到客户端浏览器
		PrintWriter out = response.getWriter();
		out.print(provinceArray);
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
