package programming.code;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("java", "Java");
        languages.put("php", "PHP");
        languages.put("python", "Python");
        languages.put("c", "C");

        if (languages.containsKey("java")) {
            System.out.println(languages.get("java"));
        }

        for (String key : languages.keySet()) {
            System.out.println(key + " " + languages.get(key));
        }
    }
}
