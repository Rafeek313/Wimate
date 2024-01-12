package ProjectLibrary;

public class PojoClass {
    String key;
    String request_type;
    String collection_name;
    int limit;
    String query;
    public PojoClass(String key,String request_type,String collection_name,int  limit,String query) {
    	super();
		this.key = key;
		this.request_type = request_type;
		this.collection_name = collection_name;
		this.limit = limit;
		this.query=query;
		
    }
	public String getKey() {
		return key;
	}
	public String getRequest_type() {
		return request_type;
	}
	public String getCollection_name() {
		return collection_name;
	}
	public int getLimit() {
		return limit;
	}
	public String getQuery() {
		return query;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public void setCollection_name(String collection_name) {
		this.collection_name = collection_name;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}
