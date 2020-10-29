package kim.yeonghoon.me.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WaterDao implements IWaterDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<HashMap<String, String>> selectList() throws Throwable {
		return sqlSession.selectList("Water.selectList");
	}

	@Override
	public int countUp(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("Water.countUp", params);
	}

	@Override
	public void countTime(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("Water.countTime", params);
	}

	@Override
	public HashMap<String, String> selectFilter(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("Water.selectFilter", params);
	}

	@Override
	public List<HashMap<String, String>> timeFilter(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("Water.timeFilter", params);
	}

	@Override
	public int filterEnd(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("Water.filterEnd", params);
	}

	@Override
	public int filterReplace(HashMap<String, String> params) throws Throwable {
		return sqlSession.insert("Water.filterReplace", params);
	}
	
}
