package implementation;

import exception.ExceptionHandler;
import interfaces.IFileOperation;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileOperation implements IFileOperation {

    @Override
    public boolean createFile(String filePath) throws ExceptionHandler {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdir();
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new ExceptionHandler(e.getMessage());
        }
    }

    @Override
    public FileLock getFileConnection(String fileName) throws ExceptionHandler {
        FileLock lock = null;
        try {
            File file = new File(fileName);
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
            lock = channel.lock();
        } catch (Exception e) {
            System.out.println("I/O Error: " + e);
            throw new ExceptionHandler(e.getMessage());
        }
        return lock;
    }
}
