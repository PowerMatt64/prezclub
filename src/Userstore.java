import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Userstore {
	private final Map<Long, String> store = new ConcurrentHashMap<>();
	private final Map<String, String> info = new ConcurrentHashMap<>();
	private static Userstore instance = new Userstore();
	
	public static Userstore getinstance() {
		return instance;
	}
	
	private Userstore() {
		
	}
	public void adduser(Long id, String name) {
		
		store.put(id, name);
		
	}
	public Set<Entry<Long, String>> listUsers(){
		return store.entrySet();
	}
}
