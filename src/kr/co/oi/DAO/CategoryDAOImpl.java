package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.CategoryVO;
import kr.co.oi.config.SqlMapClientFactory;

public class CategoryDAOImpl implements ICategoryDAO {
	private static ICategoryDAO instance;
	private CategoryDAOImpl() {}
	public static ICategoryDAO getInstance() {
		if(instance == null) instance = new CategoryDAOImpl();
		return instance;
	}
	
	SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();

	@Override
	public int insertInterestCtg(Map<String, Object> map) {
		int count = 0;
		try {
			count = (int)smc.insert("ctg.insertInterestCtg", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public int cntInterestCtg(String mem_id) {
		// TODO Auto-generated method stub
		int count = 0;
		
		try {
			count = (int)smc.queryForObject("ctg.cntInterestCtg", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public List<CategoryVO> selectInterestCtg(String mem_id) {
		
		List<CategoryVO> list = null;
		
		try {
			list = (List<CategoryVO>) smc.queryForList("ctg.selectInterestCtg", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int deleteInterestCtg(String mem_id) {
		
		int count = 0;
		
		try {
			count = (int)smc.delete("ctg.deleteInterestCtg", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}


}
