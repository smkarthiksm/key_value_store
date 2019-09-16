package implementation;

import constants.ApplicationConstants;
import exception.ExceptionHandler;
import interfaces.IJsonDataStore;
import model.KeyValueModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonDataStore implements IJsonDataStore {

    /**
     * Check if key exists and appends to the json file.
     *
     * @param filePath
     * @param keyValueModel
     * @return
     * @throws ExceptionHandler
     */
    @Override
    public boolean createRecord(String filePath, KeyValueModel keyValueModel) throws ExceptionHandler {
        JSONParser jsonParser;
        FileReader reader = null;
        FileWriter writer = null;
        JSONObject fileData;
        try {
            reader = new FileReader(filePath);

            // Check if data exists in file
            if (reader.read() != -1) {
                jsonParser = new JSONParser();
                fileData = (JSONObject) jsonParser.parse(reader);
            } else {
                fileData = new JSONObject();
            }

            reader = new FileReader(filePath);
            if (!ifKeyExist(fileData, keyValueModel.getKey())) {
                writer = new FileWriter(filePath);
                fileData.put(keyValueModel.getKey(), keyValueModel.getValueModel());
                writer.append(fileData.toJSONString());
                writer.flush();
            } else {
                throw new ExceptionHandler(ApplicationConstants.KEY_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException ex) {
                throw new ExceptionHandler(ex.getMessage());
            }
        }
        return false;
    }


    boolean ifKeyExist(JSONObject fileData, String key) {
        return fileData.containsKey(key);
    }

}
