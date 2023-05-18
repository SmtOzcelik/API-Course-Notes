package test_data;

import java.util.HashMap;
import java.util.Map;

public class GorestTestData {
    public Map<String,String> dataKeyMapMetod(String message){ // ic map
        Map<String,String>dataKeyMap=new HashMap<>();
        dataKeyMap.put("message",message);

        return dataKeyMap;
    }

    public Map<String,Object>expectedDataMetodu(Object meta,Map<String,String> data){
        Map<String,Object>expectedDataMap=new HashMap<>();
        expectedDataMap.put("meta",meta);
        expectedDataMap.put("data",data);

        return expectedDataMap;
    }
}
