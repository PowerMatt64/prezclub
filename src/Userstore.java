import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Userstore {
	private final Map<String, String> store = new ConcurrentHashMap<>();
	private final Map<String, String> discrim = new ConcurrentHashMap<>();
	private static Userstore instance = new Userstore();
	
	public static Userstore getinstance() {
		return instance;
	}
	
	private Userstore() {
		
	}
	public void adduser(String id, String name, String discrimid) {
		store.put(id, name);
		discrim.put("discrim", discrimid);
	}
	public Set<Entry<String, String>> listUsers(){
		return store.entrySet();
	}
}
