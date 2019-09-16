package utility;

public class Utility {
    public static String fileSeparator = System.getProperty("file.separator");

    public static String generateFilePath(String fileName, String filePath) {
        return filePath + Utility.fileSeparator + fileName;
    }

    public static String generateDefaultFilePath(String fileName) {
        return fileSeparator + "Users" + fileSeparator + "karthiksm" + fileSeparator + "Documents" + fileSeparator + "key_value_store" + fileSeparator + fileName;
    }
}
