package kim.yeonghoon.me.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeEntryDao implements IHomeEntryDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int prevNo() throws Throwable {
		return sqlSession.selectOne("HomeEntry.prevNo");
	}

	@Override
	public int entryStatus(int prevNo) throws Throwable {
		return sqlSession.selectOne("HomeEntry.entryStatus", prevNo);
	}

	@Override
	public void insertEntry() throws Throwable {
		sqlSession.insert("HomeEntry.insertEntry");
	}

	@Override
	public void updateEntry(int prevNo) throws Throwable {
		sqlSession.insert("HomeEntry.updateEntry", prevNo);
	}

	@Override
	public int getNoCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("HomeEntry.getNoCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getNoList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("HomeEntry.getNoList", params);
	}
	

}
