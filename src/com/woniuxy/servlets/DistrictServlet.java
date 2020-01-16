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
		//����������
		String cid = request.getParameter("cid");
		//����Dao�㷽��
		DistrictDao districtDao = new DistrictDao();
		List<District> list = districtDao.getDistrictById(Integer.parseInt(cid));
		//�����ݷ���json������
		JSONArray districtArray = new JSONArray(list);
		//������Ӧ���ݸ�ʽ�ͱ����ʽ
		response.setContentType("text/html;charset=utf-8");
		//json����������ͻ��������
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
