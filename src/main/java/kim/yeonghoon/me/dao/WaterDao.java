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
		// TODO Auto-generated method stub
		return sqlSession.update("Water.countUp", params);
	}
	
}
