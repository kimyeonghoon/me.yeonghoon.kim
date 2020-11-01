package kim.yeonghoon.me.service;

import java.util.HashMap;
import java.util.List;

public interface IHomeEntryService {

	public int prevNo() throws Throwable;

	public int entryStatus(int prevNo) throws Throwable;

	public void insertEntry() throws Throwable;

	public void updateEntry(int prevNo) throws Throwable;

	public int getNoCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getNoList(HashMap<String, String> params) throws Throwable;

}
