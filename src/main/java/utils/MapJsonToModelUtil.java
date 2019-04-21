package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class MapJsonToModelUtil {
    private String value;

    public MapJsonToModelUtil(String value){
        this.value = value;
    }

    public static MapJsonToModelUtil of(BufferedReader reader){
        StringBuilder json = new StringBuilder();
        String line;

        try{
            while ((line = reader.readLine()) != null){
                json.append(line);
            }
        }catch (IOException e){
            e.getMessage();
        }

        return new MapJsonToModelUtil(json.toString());
    }

    public <T> T toModel(Class<T> tClass){

        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            return null;
        }
    }
}
