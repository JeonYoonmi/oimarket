package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.NoticeVO;
import kr.co.oi.config.SqlMapClientFactory;

public class NoticeDAOImpl implements NoticeDAO {
	
	private SqlMapClient client;
	private static NoticeDAO dao;
	private NoticeDAOImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static NoticeDAO getInstance() {
		if(dao == null) dao = new NoticeDAOImpl();
		
		return dao;
	}

	@Override
	public List<NoticeVO> selectAll() {
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		try {
			list = client.queryForList("notice.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
