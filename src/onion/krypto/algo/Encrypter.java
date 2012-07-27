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
public class Encrypter {
    private Reader rd = null;
    private GammaGenerator gmg = null;
    private PrintWriter cry = null;
    private PrintWriter key = null;

    Encrypter() {
    }

    Encrypter(Reader read, GammaGenerator gamma) throws IOException {
        rd = read;
        gmg = gamma;
        cry = new PrintWriter(new FileWriter(rd.getFileName() + ".kry"));
        key = new PrintWriter(new FileWriter(rd.getFileName() + ".key"));
    }

    void crypt() throws IOException, InterruptedException {
        char gammaByte = 0, srcByte = 0, kryByte = 0;
        while (rd.ifAvailable()) {
            gammaByte = gmg.getGammaByte();
            srcByte = rd.readByte();
            kryByte = (char) (((int) gammaByte + (int) srcByte) % 256);
            cry.write(kryByte);
            key.write(gammaByte);
            cry.flush();
            key.flush();
        }
    }

}
