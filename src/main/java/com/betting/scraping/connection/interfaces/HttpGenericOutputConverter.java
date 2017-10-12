package betting.scraping.connection.interfaces;

public interface HttpGenericOutputConverter<T> {
	
	public T convertObject(String outputData);

}
