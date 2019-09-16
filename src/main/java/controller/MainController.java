package controller;

import implementation.FileOperation;
import implementation.JsonDataStore;
import interfaces.IFileOperation;
import interfaces.IJsonDataStore;
import model.KeyValueModel;
import model.ValueModel;
import utility.Utility;

import java.io.IOException;
import java.nio.channels.FileLock;

public class MainController {

    public static void main(String[] args) throws IOException {
        new MainController().getFileConnection("hello.json", "/Users/karthiksm/Documents/key_value_store");
        ValueModel valueModel = new ValueModel("testvaluee", 100);
        KeyValueModel keyValueModel = new KeyValueModel("zz", valueModel);
        new MainController().createRecord("hello.json", "/Users/karthiksm/Documents/key_value_store", keyValueModel);
    }

    public boolean createFileUsingDefaultPath(String filename) {
        String systemFilePath = Utility.generateDefaultFilePath(filename);
        return MainController.createFile(systemFilePath);
    }

    public boolean createFileUsingCustomPath(String filename, String filePath) {
        String systemFilePath = Utility.generateFilePath(filename, filePath);
        return MainController.createFile(systemFilePath);
    }

    public FileLock getFileConnection(String filename, String filePath) {
        FileLock fileLock = null;
        try {
            String systemFilePath = Utility.generateFilePath(filename, filePath);
            IFileOperation iFileOperation = new FileOperation();
            fileLock = iFileOperation.getFileConnection(systemFilePath);
        } catch (Exception e) {
            System.out.println(e);
        }

        return fileLock;
    }

    public boolean createRecord(String filename, String filePath, KeyValueModel keyValueModel) {
        boolean isRecordCreated = false;
        try {
            String systemFilePath = Utility.generateFilePath(filename, filePath);
            IJsonDataStore iJsonDataStore = new JsonDataStore();
            isRecordCreated = iJsonDataStore.createRecord(systemFilePath, keyValueModel);

        } catch (Exception e) {
            System.out.println(e);
        }
        return isRecordCreated;
    }

    static boolean createFile(String filePath) {
        boolean isFileCreated = false;
        try {
            IFileOperation iFileOperation = new FileOperation();
            isFileCreated = iFileOperation.createFile(filePath);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isFileCreated;
    }


}
