package freemarker.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplyDao implements IJobApplyDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<HashMap<String, String>> list() throws Throwable {
		return sqlSession.selectList("jobApply.list");
	}

	@Override
	public void jobAdd(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("jobApply.jobAdd", params);
	}

}
