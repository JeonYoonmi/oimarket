package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.MpostImgVO;
import kr.co.oi.VO.MpostVO;
import kr.co.oi.config.SqlMapClientFactory;

public class MpostDAOImpl implements MpostDAO {

	private SqlMapClient client;
	private static MpostDAO dao;
	
	private MpostDAOImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static MpostDAO getInstance() {
		if(dao==null) dao = new MpostDAOImpl();
		
		return dao;
	}
	
	@Override
	public List<Map<String, Object>> mpostList(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			list = client.queryForList("mpost.mpostList", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectMpost(String mpost_code) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			list = client.queryForList("mpost.selectMpost", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addHit(String mpost_code) {
		int res = 0;
		try {
			res = client.update("mpost.addHit", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int zzimCount(String mpost_code) {
		int cnt = 0;
		
		try {
			cnt = (int) client.queryForObject("mpost.zzimCount", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int chatCount(String mpost_code) {
		int cnt = 0;
		
		try {
			cnt = (int) client.queryForObject("mpost.chatCount", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MpostImgVO> selectMpostImg(String mpost_code) {
		List<MpostImgVO> list = new ArrayList<MpostImgVO>();
		try {
			list = client.queryForList("mpost.selectMpostImg", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertMpost(Map<String, String> map) {
		int res = 0;
		try {
			res = client.update("mpost.insertMpost", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int modifyMpost(Map<String, String> map) {
		int res = 0;
		try {
			res = client.update("mpost.modifyMpost", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteMpost(String mpost_code) {
		int res = 0;
		
		try {
			res = client.delete("mpost.deleteMpost", mpost_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
