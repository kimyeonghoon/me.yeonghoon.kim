package kim.yeonghoon.me.dao;

public interface IHomeEntryDao {

	public int prevNo() throws Throwable;

	public int entryStatus(int prevNo) throws Throwable;

	public void insertEntry() throws Throwable;

	public void updateEntry(int prevNo) throws Throwable;

}
