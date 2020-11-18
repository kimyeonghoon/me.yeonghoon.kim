package freemarker.service;

import java.util.HashMap;
import java.util.List;

public interface IJobApplyService {

	public List<HashMap<String, String>> list() throws Throwable;

	public void jobAdd(HashMap<String, String> params) throws Throwable;

}
