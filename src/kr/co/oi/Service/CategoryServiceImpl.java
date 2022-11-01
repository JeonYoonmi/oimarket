package kr.co.oi.Service;

import java.util.List;
import java.util.Map;

import kr.co.oi.DAO.CategoryDAOImpl;
import kr.co.oi.DAO.ICategoryDAO;
import kr.co.oi.VO.CategoryVO;

public class CategoryServiceImpl implements ICategoryService {

	private static ICategoryService instance;
	private CategoryServiceImpl() {}
	public static ICategoryService getInstance() {
		if(instance == null) instance = new CategoryServiceImpl();
		return instance;
	}
	
	private ICategoryDAO dao = CategoryDAOImpl.getInstance();
	
	@Override
	public int insertInterestCtg(Map<String, Object> map) {
		
		int count = 0;
		
		count = dao.insertInterestCtg(map);
		
		return count;
	}
	@Override
	public int cntInterestCtg(String mem_id) {
		
		int count = 0;
		
		count = dao.cntInterestCtg(mem_id);
		
		return count;
	}
	@Override
	public List<CategoryVO> selectInterestCtg(String mem_id) {
		
		List<CategoryVO> list = null;
		
		list = dao.selectInterestCtg(mem_id);
		
		return list;
	}
	@Override
	public int deleteInterestCtg(String mem_id) {
		
		int count = 0;
		
		count = dao.deleteInterestCtg(mem_id);
		
		return count;
	}

}
