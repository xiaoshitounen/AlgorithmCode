package swu.xl.algorithm.code_03_10.experiment_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class TrafficTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<String, LinkedList<String>> traffic_conflict =
                new HashMap<String, LinkedList<String>>();

        traffic_conflict.put("AB",
                new LinkedList<String>(Arrays.asList("BC", "BD", "DA", "EA")));
        traffic_conflict.put("AC",
                new LinkedList<String>(Arrays.asList("BD", "DA", "DB", "EA", "EB")));
        traffic_conflict.put("AD",
                new LinkedList<String>(Arrays.asList("EA", "EB", "EC")));
        traffic_conflict.put("BA",
                new LinkedList<String>());
        traffic_conflict.put("BC",
                new LinkedList<String>(Arrays.asList("AB", "DB", "EB")));
        traffic_conflict.put("BD",
                new LinkedList<String>(Arrays.asList("AB", "AC", "DA", "EB", "EC")));
        traffic_conflict.put("DA",
                new LinkedList<String>(Arrays.asList("AB", "AC", "BD", "EB", "EC")));
        traffic_conflict.put("DB",
                new LinkedList<String>(Arrays.asList("AC", "BC", "EC")));
        traffic_conflict.put("DC",
                new LinkedList<String>());
        traffic_conflict.put("EA",
                new LinkedList<String>(Arrays.asList("AB", "AC", "AD")));
        traffic_conflict.put("EB",
                new LinkedList<String>(Arrays.asList("AC", "AD", "BC", "BD", "DA")));
        traffic_conflict.put("EC",
                new LinkedList<String>(Arrays.asList("AD", "BD", "DA", "DB")));
        traffic_conflict.put("ED",
                new LinkedList<String>());

        LinkedList<LinkedList<String>> trafficGroups = TrafficPlanner.getTrafficGroups(traffic_conflict);

        for (LinkedList<String> oneGroup : trafficGroups) {
            System.out.println(oneGroup.toString());
        }

    }
    //222017602053039许磊
}
