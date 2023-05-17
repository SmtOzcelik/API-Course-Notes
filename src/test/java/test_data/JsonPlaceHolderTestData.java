package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object>expectedDataMetodu(Integer userId,String title,Boolean completed){
        Map<String, Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("userId",userId);

        expectedDataMap.put("title",title);
        expectedDataMap.put("completed",completed);
        System.out.println("expectedDataMap : "+expectedDataMap);

        return expectedDataMap;
    }
}
