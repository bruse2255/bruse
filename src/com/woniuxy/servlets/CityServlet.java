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
		//��������ò���
		String pid = request.getParameter("pid");
		//����Dao�����������
		CityDao cityDao = new CityDao();
		List<City> list = cityDao.getCityById(Integer.parseInt(pid));
		//�����ݷ���json������
		JSONArray cityArray = new JSONArray(list);
		//������Ӧ���ݸ�ʽ�ͱ����ʽ
		response.setContentType("text/html;charset=utf-8");
		//json����������ͻ��������
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
