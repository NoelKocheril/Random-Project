import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Grades {
	private Map<String, String> grades;
	public Grades() {
		grades = new TreeMap<String, String>();
	}
	public void put(String key, String value) {
		grades.put(key, value);
	}
	public String get(String key) {
		return grades.get(key);
	}
	
	@Override
	public String toString() {
		String output = "";
		Set<String> names = grades.keySet();
		for(String name : names) {
			output += name.toString() + ":" + grades.get(name) + "\n";
		}
		return output;
	}
}
