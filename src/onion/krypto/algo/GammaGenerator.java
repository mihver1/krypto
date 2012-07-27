package onion.krypto.algo;

import java.awt.*;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 27.07.12
 * Time: 15:34
 * GNU GPLv3
 */
public class GammaGenerator {
    public GammaGenerator() {
    }

    ;

    public char getGammaByte() throws InterruptedException {
        System.out.println("Move your mouse!");
        int random = MouseInfo.getPointerInfo().getLocation().x + MouseInfo.getPointerInfo().getLocation().y;
        Thread.sleep(300);
        return (char) (random % 256);
    }
}
