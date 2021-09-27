
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPTracker {

    private static Map<String, Integer> ipFrequency = new HashMap<>();

    public static void request_handled(String ipAddress) {
        int currentIpFrequency;
        if (ipFrequency.containsKey(ipAddress)) {
            currentIpFrequency = ipFrequency.get(ipAddress);
            ipFrequency.put(ipAddress, ++currentIpFrequency);
        } else {
            currentIpFrequency = 1;
            ipFrequency.put(ipAddress, currentIpFrequency);
        }
    }

    public static List<String> top100() {
        return ipFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(100)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public void clear() {
        ipFrequency.clear();
    }

    public static void main(String[] args) {
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.109");
        request_handled("145.87.2.108");

        System.out.println(top100());
    }
}
