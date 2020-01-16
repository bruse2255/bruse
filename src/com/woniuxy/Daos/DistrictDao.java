package com.woniuxy.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.woniuxy.entitys.District;
import com.woniuxy.tools.DriverManage;

public class DistrictDao {
	//查询某条数据
	public List<District> getDistrictById(int districtCid) {
		List<District> list = new ArrayList<District>();
		Connection conn = DriverManage.getConnection();
		District district = null;
		
		//得到PreparedStatement对象
		String sql = "select * from district where cid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, districtCid);
			//发送查询语句
			ResultSet re = ps.executeQuery();
			//循环遍历显示数据
			while(re.next()) {
				//参数为结果集中的列名
				int cid = re.getInt("cid");
				int pid = re.getInt("pid");
				int did = re.getInt("did");
				String dname = re.getString("dname");
				district = new District(did, dname, pid,cid);
				list.add(district);
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
