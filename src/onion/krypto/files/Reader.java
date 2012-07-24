package onion.krypto.files;

import onion.krypto.data.Storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 24.07.12
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */

// TODO: that's fucking bug here :(
public class Reader {
    private Storage data;

    public Reader() {
    }


    public Reader(String file) throws IOException {
        data = new Storage(new ArrayList<Integer>());
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            int c;

            while ((c = in.read()) != -1) {
                data.addBlock(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public Storage getStorageData() {
        return data;
    }
}
