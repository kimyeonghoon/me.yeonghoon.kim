package kim.yeonghoon.me.dao;

import java.util.HashMap;
import java.util.List;

public interface IWaterDao {

	public List<HashMap<String, String>> selectList() throws Throwable;

	public int countUp(HashMap<String, String> params) throws Throwable;

	public void countTime(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> selectFilter(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> timeFilter(HashMap<String, String> params) throws Throwable;

	public int filterEnd(HashMap<String, String> params) throws Throwable;

	public int filterReplace(HashMap<String, String> params) throws Throwable;

}
