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
	//��ѯĳ������
	public List<District> getDistrictById(int districtCid) {
		List<District> list = new ArrayList<District>();
		Connection conn = DriverManage.getConnection();
		District district = null;
		
		//�õ�PreparedStatement����
		String sql = "select * from district where cid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, districtCid);
			//���Ͳ�ѯ���
			ResultSet re = ps.executeQuery();
			//ѭ��������ʾ����
			while(re.next()) {
				//����Ϊ������е�����
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
			//�ر����Ӷ���
			DriverManage.closeConnection(conn);
		}
	}
}
