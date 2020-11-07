package kim.yeonghoon.me.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplyDao implements IJobApplyDao {
	
	@Autowired
	SqlSession sqlSession;

}
