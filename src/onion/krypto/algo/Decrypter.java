package onion.krypto.algo;

import onion.krypto.files.Reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:26
 * GNU GPLv3
 */
public class Decrypter {
    private Reader rd = null;
    private Reader key = null;
    private PrintWriter orig = null;

    Decrypter() {
    }

    Decrypter(Reader readKry) throws IOException {
        rd = readKry;
        orig = new PrintWriter(new FileWriter(rd.getFileName() + ".dekry"));
        System.out.println(rd.getFileName().substring(0, rd.getFileName().length() - 4) + ".key");
        key = new Reader(rd.getFileName().substring(0, rd.getFileName().length() - 4) + ".key");
    }

    void decrypt() throws IOException, InterruptedException {
        char gammaByte = 0, kryByte = 0, decByte = 0;
        while (rd.ifAvailable()) {
            gammaByte = key.readByte();
            kryByte = rd.readByte();
            decByte = (char) (((int) gammaByte - (int) kryByte + 256) % 256);
            orig.write(decByte);
            orig.flush();
        }
    }
}
