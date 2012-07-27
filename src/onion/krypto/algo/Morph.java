package onion.krypto.algo;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:23
 * GNU GPLv3
 */

import onion.krypto.data.Storage;
import onion.krypto.files.Reader;

import java.io.IOException;

public class Morph {
    public static void main(String args[]) throws IOException {
        System.out.println("Hello World!");
        Reader rd = new Reader("/home/michael/IdeaProjects/krypto/data/cryptHello");
        Storage st = rd.getStorageData();
        Encryptor enc = new Encryptor();
        enc.genGamma(st.getSize());
        enc.saveGamma();
        enc.gammaficate(st);
        enc.readGamma();
        rd = new Reader("/home/michael/IdeaProjects/krypto/data/cryptHello.cry");
        st = rd.getStorageData();
        enc.deGammaficate(st);
    }
}
