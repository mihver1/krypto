package onion.krypto.data;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:29
 * GNU GPLv3
 */
public class Storage {
    private ArrayList<Integer> _data;
    private ListIterator<Integer> iter;

    public Storage(ArrayList<Integer> data) {
        _data = data;
        iter = _data.listIterator(0);
    }

    public void addBlock(int a) {
        _data.add(a);
    }

    public ArrayList<Integer> getBlock() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < 4; ++i) {
            if (iter.hasNext()) {
                temp.add(iter.next());
            } else {
                for (int j = i + 1; j < 4; ++j) {
                    temp.add(0);
                }
                break;
            }
        }
        return temp;
    }
}
