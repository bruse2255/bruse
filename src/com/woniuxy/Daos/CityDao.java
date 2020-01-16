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
	//查询某条数据
	public List<City> getCityById(int CityPid) {
		List<City> list = new ArrayList<City>();
		Connection conn = DriverManage.getConnection();
		City city = null;
		
		//得到PreparedStatement对象
		String sql = "select * from city where pid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, CityPid);
			//发送查询语句
			ResultSet re = ps.executeQuery();
			//循环遍历显示数据
			while(re.next()) {
				//参数为结果集中的列名
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
			//关闭连接对象
			DriverManage.closeConnection(conn);
		}
	}
}
