package com.woniuxy.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.City;
import com.woniuxy.tools.DriverManage;

public class CityDao {
	//��ѯĳ������
	public List<City> getCityById(int CityPid) {
		List<City> list = new ArrayList<City>();
		Connection conn = DriverManage.getConnection();
		City city = null;
		
		//�õ�PreparedStatement����
		String sql = "select * from city where pid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, CityPid);
			//���Ͳ�ѯ���
			ResultSet re = ps.executeQuery();
			//ѭ��������ʾ����
			while(re.next()) {
				//����Ϊ������е�����
				int cid = re.getInt("cid");
				int pid = re.getInt("pid");
				String cname = re.getString("cname");
				city = new City(cid, cname, pid);
				list.add(city);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			//�ر����Ӷ���
			DriverManage.closeConnection(conn);
		}
	}
}
