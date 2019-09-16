package implementation;

import exception.ExceptionHandler;
import interfaces.IJsonDataStore;
import model.KeyValueModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

public class JsonDataStore implements IJsonDataStore {
    @Override
    public boolean createRecord(String filePath, KeyValueModel keyValueModel) throws ExceptionHandler {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject = (JSONObject) obj;

            System.out.println(jsonObject);

        }
        catch (Exception e) {

        }
        return false;
    }
}
