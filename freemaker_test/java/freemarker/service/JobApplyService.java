package freemarker.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.dao.IJobApplyDao;

@Service
public class JobApplyService implements IJobApplyService {
	
	@Autowired
	IJobApplyDao iJobApplyDao;

	@Override
	public List<HashMap<String, String>> list() throws Throwable {
		return iJobApplyDao.list();
	}

}
