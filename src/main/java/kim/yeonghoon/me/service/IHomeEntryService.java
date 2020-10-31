package kim.yeonghoon.me.service;

public interface IHomeEntryService {

	public int prevNo() throws Throwable;

	public int entryStatus(int prevNo) throws Throwable;

	public void insertEntry() throws Throwable;

	public void updateEntry(int prevNo) throws Throwable;

}
