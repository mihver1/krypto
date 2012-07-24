package onion.krypto.algo;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 24.07.12
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */

import onion.krypto.data.Storage;
import onion.krypto.files.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Morph {
    //placeholder
    public static void main(String args[]) throws IOException {
        System.out.println("Hello World!");
        Reader rd = new Reader("/home/michael/Projects/krypto/data/cryptHello");
        Storage st = rd.getStorageData();
        try {
            //TODO: fix this bug
            ArrayList<Integer> ali = new ArrayList<Integer>(st.getBlock());  // BUG: Here is a bug
            System.out.print(ali.toString());
        } finally {
            //
        }

    }
}
