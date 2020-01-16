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
	//��ȡ��������
	public List<Province> getAllProvince() {
		List<Province> list = new ArrayList<>();
		//������Ӷ���
		Connection conn = DriverManage.getConnection();
		//���PreparedStatement����
		String sql = "select * from province";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//���Ͳ�ѯ���
			ResultSet re = ps.executeQuery();
			while(re.next()) {
				//����Ϊ������е�����
				int pid = re.getInt("pid");
				String pname = re.getString("pname");
				//�����Է�װ�ɶ���
				Province province = new Province(pid, pname);
				//����ѯ�����ݷ�װ�ɶ�����뼯����
				list.add(province);
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
