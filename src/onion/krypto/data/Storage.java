package onion.krypto.data;

import java.util.ArrayList;

/**
 * User: Michael Verkhovykh <mihver1@gmail.com>
 * Date: 24.07.12
 * Time: 20:29
 * GNU GPLv3
 */
public class Storage {
    private ArrayList<Integer> _data;
    private int cnt, cur;

    public Storage(ArrayList<Integer> data) {
        _data = data;
        cur = 0;
        cnt = _data.size();
    }

    public void addBlock(int a) {
        _data.add(a);
        cnt = _data.size();
    }


    public ArrayList<Integer> getBlock() {
        /*ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < 4; ++i) {
            if (cur + i < cnt) {
                temp.add(_data.get(cur + i));
            } else {
                temp.add(0);
            }
        }
        cur += 4;
        return temp;*/
        return _data;
    }

    public int getSize() {
        return _data.size();
    }
}
