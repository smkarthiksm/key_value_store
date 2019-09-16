package interfaces;

import exception.ExceptionHandler;

import java.nio.channels.FileLock;

public interface IFileOperation {
    boolean createFile(String filePath) throws ExceptionHandler;

    FileLock getFileConnection(String fileName) throws ExceptionHandler;
}
