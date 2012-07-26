package onion.krypto.algo;

import onion.krypto.data.Storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 24.07.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */

public class Encryptor {
    private int[] gamma;

    public void genGamma(int n) {
        //TODO: remove random function and add user interactions
        Random rand = new Random();
        gamma = new int[n];
        for (int i = 0; i < n; ++i) {
            gamma[i] = rand.nextInt() % 256 - 128;
        }
        System.out.println("Gamma generated");
    }

    public void saveGamma() throws FileNotFoundException, IOException {
        int l = gamma.length;
        FileWriter pr = new FileWriter("/home/michael/IdeaProjects/krypto/data/cryptHello.key");
        for (int aGamma : gamma) {
            char c = (char) aGamma;
            System.out.print(c);
            pr.write(c);
        }
        pr.close();
        System.out.println("Gamma saved");
    }

    public void readGamma() throws IOException {
        FileInputStream in = null;
        try {
            gamma = new int[1000];
            in = new FileInputStream("/home/michael/IdeaProjects/krypto/data/cryptHello.key");
            int c;
            int i = 0;
            while ((c = in.read()) != -1) {
                gamma[i++] = c;
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

    public void gammaficate(Storage st) throws FileNotFoundException, IOException {
        ArrayList<Integer> lst = st.getBlock();
        int i = 0;
        FileWriter pr = new FileWriter("/home/michael/IdeaProjects/krypto/data/cryptHello.cry");
        for (Integer aLst : lst) {
            char c = (char) ((aLst + gamma[i++] + 128) % 256 - 128);
            System.out.print(c);
            pr.write(c);
        }
        pr.close();
        System.out.println("Gammaficated");
    }

    public void deGammaficate(Storage st) throws FileNotFoundException, IOException {
        ArrayList<Integer> lst = st.getBlock();
        int i = 0;
        FileWriter pr = new FileWriter("/home/michael/IdeaProjects/krypto/data/cryptHello.cry");
        for (Integer aLst : lst) {
            char c = (char) ((aLst - gamma[i++] + 128) % 256 - 128);
            System.out.print(c);
            pr.write(c);
        }
        pr.close();
        System.out.println("Degammaficated");
    }

}
