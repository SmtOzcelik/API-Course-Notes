package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {
    //new ObjectMapper().readValue(jsonInString, HashMap.class); her seferinde hata vermemesi icin method yapalim

    private static ObjectMapper mapper;

    static {
        mapper=new ObjectMapper();
    }
    public static <T> T convertJsonToJava(String  json,Class<T>cls){

        T javeResult=null;
        try {
            javeResult=mapper.readValue(json,cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return javeResult;
    }
}
