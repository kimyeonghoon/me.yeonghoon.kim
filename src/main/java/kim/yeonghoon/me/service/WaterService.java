package kim.yeonghoon.me.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kim.yeonghoon.me.dao.IWaterDao;

@Service
public class WaterService implements IWaterService {

	@Autowired
	IWaterDao iWaterDao;

	@Override
	public List<HashMap<String, String>> selectList() throws Throwable {
		return iWaterDao.selectList();
	}

	@Override
	public int countUp(HashMap<String, String> params) throws Throwable {
		return iWaterDao.countUp(params);
	}

	@Override
	public void countTime(HashMap<String, String> params) throws Throwable {
		iWaterDao.countTime(params);		
	}

	@Override
	public HashMap<String, String> selectFilter(HashMap<String, String> params) throws Throwable {
		return iWaterDao.selectFilter(params);
	}

	@Override
	public List<HashMap<String, String>> timeFilter(HashMap<String, String> params) throws Throwable {
		return iWaterDao.timeFilter(params);
	}

	@Override
	public int filterEnd(HashMap<String, String> params) throws Throwable {
		return iWaterDao.filterEnd(params);
	}

	@Override
	public int filterReplace(HashMap<String, String> params) throws Throwable {
		return iWaterDao.filterReplace(params);
	}

}
