package kim.yeonghoon.me.dao;

import java.util.HashMap;
import java.util.List;

public interface IWaterDao {

	public List<HashMap<String, String>> selectList() throws Throwable;

	public int countUp(HashMap<String, String> params) throws Throwable;

}
