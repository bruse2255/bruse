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
		
		System.out.println("�ѵ��������");
		
		//����dao�㷽����ʾ��������
		ProvinceDas provinceDas = new ProvinceDas();
		List<Province> list = provinceDas.getAllProvince();
		//�����ݷ���json������
		JSONArray provinceArray = new JSONArray(list);
		//������Ӧ���ݸ�ʽ�ͱ����ʽ
		response.setContentType("text/html;charset=utf-8");
		//json����������ͻ��������
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
