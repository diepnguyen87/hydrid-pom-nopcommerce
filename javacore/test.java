import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		String input = "toi la chinh toi";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i < input.length(); ++i) {
			if(map.containsKey(input.charAt(i))) {
				int temp = map.get(input.charAt(i));
				map.put(input.charAt(i), ++temp);
			}else {
				map.put(input.charAt(i), 1);
			}
		}
		System.out.println(map);
	}
}
