package onion.krypto.algo;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:23
 * GNU GPLv3
 */

import onion.krypto.files.Reader;

import java.io.IOException;

public class Morph {
    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        Reader rd = new Reader("/home/michael/IdeaProjects/krypto/data/cryptEnum");
        GammaGenerator gm = new GammaGenerator();
        Encrypter enc = new Encrypter(rd, gm);
        enc.crypt();
        System.out.println("Done encryption");
        rd = new Reader("/home/michael/IdeaProjects/krypto/data/cryptEnum.kry");
        Decrypter dec = new Decrypter(rd);
        dec.decrypt();
        System.out.println("Done decryption");
    }
}
