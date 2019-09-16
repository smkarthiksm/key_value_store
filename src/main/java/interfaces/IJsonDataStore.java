package interfaces;

import exception.ExceptionHandler;
import model.KeyValueModel;

public interface IJsonDataStore {

    boolean createRecord(String filePath, KeyValueModel keyValueModel) throws ExceptionHandler;

}
