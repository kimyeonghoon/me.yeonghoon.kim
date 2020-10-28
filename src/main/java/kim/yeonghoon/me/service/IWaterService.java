package kim.yeonghoon.me.service;

import java.util.HashMap;
import java.util.List;

public interface IWaterService {

	public List<HashMap<String, String>> selectList() throws Throwable;

	public int countUp(HashMap<String, String> params) throws Throwable;


}
