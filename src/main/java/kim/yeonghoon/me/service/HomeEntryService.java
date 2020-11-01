package kim.yeonghoon.me.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kim.yeonghoon.me.dao.IHomeEntryDao;

@Service
public class HomeEntryService implements IHomeEntryService {

	@Autowired
	IHomeEntryDao iHomeEntryDao;

	@Override
	public int prevNo() throws Throwable {
		return iHomeEntryDao.prevNo();
	}

	@Override
	public int entryStatus(int prevNo) throws Throwable {
		return iHomeEntryDao.entryStatus(prevNo);
	}

	@Override
	public void insertEntry() throws Throwable {
		iHomeEntryDao.insertEntry();
	}

	@Override
	public void updateEntry(int prevNo) throws Throwable {
		iHomeEntryDao.updateEntry(prevNo);
	}

	@Override
	public int getNoCnt(HashMap<String, String> params) throws Throwable {
		return iHomeEntryDao.getNoCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getNoList(HashMap<String, String> params) throws Throwable {
		return iHomeEntryDao.getNoList(params);
	}
	
}
