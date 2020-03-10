package swu.xl.algorithm.code_03_10.experiment_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TrafficPlanner {
    public static LinkedList<LinkedList<String>> getTrafficGroups(HashMap<String, LinkedList<String>> traffic_conflict){
        //产生空白通行分组
        LinkedList<LinkedList<String>> groups = new LinkedList<>();

        //产生互不冲突且完全覆盖的通行分组
        LinkedList<String> roadSet = new LinkedList<>(traffic_conflict.keySet());
        while (roadSet.size() > 0){
            LinkedList<String> oneGroup = new LinkedList<>();
            String road = roadSet.get(0);
            oneGroup.add(road);
            roadSet.remove(road);

            Iterator<String> roadSetIterator = roadSet.iterator();
            while (roadSetIterator.hasNext()){
                String roadToAdd = roadSetIterator.next();

                if (checkNoConflict(roadToAdd, oneGroup, traffic_conflict)){
                    oneGroup.add(roadToAdd);

                    roadSetIterator.remove();
                }
            }
            groups.add(oneGroup);
        }

        //保证不冲突全覆盖后，将与每组不冲突的方向全部通行
        for (LinkedList<String> group : groups) {
            for (String road : traffic_conflict.keySet()) {
                if (checkNoConflict(road, group, traffic_conflict)){
                    group.add(road);
                }
            }
        }

        return groups;
    }

    /**
     * 判断新加的通行方向是否与本组已有方向冲突
     * @param roadToAdd
     * @param oneGroup
     * @param traffic_conflict
     * @return
     */
    private static boolean checkNoConflict(String roadToAdd, LinkedList<String> oneGroup, HashMap<String, LinkedList<String>> traffic_conflict){
        for (String road : oneGroup) {
            //是否和已存在的相冲突或者是否已存在
            if (traffic_conflict.get(road).contains(roadToAdd) || road.equals(roadToAdd)){
                return false;
            }
        }

        return true;
    }
}
