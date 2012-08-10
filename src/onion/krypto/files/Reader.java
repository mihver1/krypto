package onion.krypto.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:55
 * GNU GPLv3
 */
// TODO: that's fucking bug here :(
public class Reader {
    private File file = null;
    private FileInputStream fl = null;
    private boolean available = false;
    private String fileName = null;

    public Reader() {
    }

    public Reader(String fileName) throws FileNotFoundException {
        openFile(fileName);
    }

    public byte readByte() throws IOException {
        byte b = 0;
        if ((b = (byte) fl.read()) != -1) {
            System.out.println(b);
            assert (-128 <= b) && (b <= 127);
            return (byte) (b);
        } else {
            available = false;
            return 0;
        }
    }

    public boolean ifAvailable() {
        return available;
    }

    public void openFile(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        fl = new FileInputStream(file);
        available = true;
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
