package com.woniuxy.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Province;
import com.woniuxy.tools.DriverManage;

public class ProvinceDas {
	//获取所有数据
	public List<Province> getAllProvince() {
		List<Province> list = new ArrayList<>();
		//获得连接对象
		Connection conn = DriverManage.getConnection();
		//获得PreparedStatement对象
		String sql = "select * from province";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//发送查询语句
			ResultSet re = ps.executeQuery();
			while(re.next()) {
				//参数为结果集中的列名
				int pid = re.getInt("pid");
				String pname = re.getString("pname");
				//将属性封装成对象
				Province province = new Province(pid, pname);
				//将查询的数据封装成对象放入集合中
				list.add(province);
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
