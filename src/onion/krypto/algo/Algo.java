package onion.krypto.Algo;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:23
 * GNU GPLv3
 */

import java.io.FileReader;
import java.io.IOException;

public class Algo {
    public static int mod=Character.MAX_VALUE;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        String filename="data/t.txt";
        FileReader rd = new FileReader(filename);
        GammaGenerator gm = new GammaGenerator();
        Encrypter enc = new Encrypter(rd, gm, filename);
        enc.crypt();
        System.out.println("Done encryption");
        rd = new FileReader(filename.concat(".kry"));
        Decrypter dec = new Decrypter(rd, filename);
        dec.decrypt();
        System.out.println("Done decryption");
    }
}
