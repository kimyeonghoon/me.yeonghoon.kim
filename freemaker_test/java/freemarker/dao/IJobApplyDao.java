package freemarker.dao;

import java.util.HashMap;
import java.util.List;

public interface IJobApplyDao {

	public List<HashMap<String, String>> list() throws Throwable;

}
