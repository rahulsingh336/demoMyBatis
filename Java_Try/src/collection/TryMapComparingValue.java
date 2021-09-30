package collection;

import java.util.HashMap;
import java.util.Map;

public class TryMapComparingValue {

    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        //m.put("A", 1);
        m.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())..ifPresent(v -> {
                    System.out.println("v.getValue()");
                    System.out.println(v.getValue());
                });

    }
}
