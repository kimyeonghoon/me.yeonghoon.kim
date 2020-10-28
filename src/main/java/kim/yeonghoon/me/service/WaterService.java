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

}
