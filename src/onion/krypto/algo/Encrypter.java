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
        byte gammaByte = 0, srcByte = 0, kryByte = 0;
        do {
            gammaByte = (byte) gmg.getGammaByte();
            if (!rd.ifAvailable()) {
                cry.close();
                key.close();
                return;
            }
            srcByte = (byte) rd.readByte();
            kryByte = (byte) ((byte) (((int) gammaByte + (int) srcByte) % 256) - (byte) 128);
            //cry.write((int)kryByte);
            //key.write((int)gammaByte);
            cry.flush();
            key.flush();
        } while (rd.ifAvailable());
    }

}
