package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.ZzimVO;
import kr.co.oi.config.SqlMapClientFactory;

public class ZzimDAOImpl implements ZzimDAO {
	private SqlMapClient client;
	private static ZzimDAO dao;
	
	private ZzimDAOImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ZzimDAO getInstance() {
		if(dao==null) dao = new ZzimDAOImpl();
		
		return dao;
	}

	@Override
	public int insertZzim(Map<String, String> map) {
		int res = 0;
		try {
			res = client.update("zzim.insertZzim", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteZzim(Map<String, String> map) {
		int res = 0;
		try {
			res = client.delete("zzim.deleteZzim", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ZzimVO checkZzim(Map<String, String> map) {
		ZzimVO vo = new ZzimVO();
		try {
			vo = (ZzimVO) client.queryForObject("zzim.checkZzim", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
