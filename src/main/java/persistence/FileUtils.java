package persistence;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public abstract class FileUtils {
    protected Path path;
    protected File file;
    protected String nameFile;
    protected char delimiter;
    protected String pathnameFile;
    protected char separator = ','; // Delimitador por defecto

    public FileUtils() {
        this.pathnameFile = "";
        this.nameFile = "";
    }

    public void setPathFile(String path) {
        this.pathnameFile = path;
        this.path = Paths.get(path);
    }

    public void setNameFile(String name) {
        this.nameFile = name;
    }

    public String getPathFile() {
        return path != null ? path.toString() : null;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setSeparator(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getSeparator() {
        return delimiter;
    }

    public void openFile() {
        file = new File(pathnameFile + nameFile);
    }

    public void openFileWithPath() {
        path = Paths.get(pathnameFile + nameFile);
    }

    public String readFile() throws IOException {
        try (BufferedReader input = Files.newBufferedReader(path, Charset.defaultCharset())) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = input.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
        }
    }

    public void writeFile(String content) throws IOException {
        Files.write(path, content.getBytes(Charset.defaultCharset()), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public Object readObject() {
        return null;
    }

    public void writeObject(Object object) {
    }
}