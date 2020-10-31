package kim.yeonghoon.me.dao;

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
	

}
