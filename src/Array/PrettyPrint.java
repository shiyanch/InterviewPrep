package Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanch on 12/26/16.
 */
public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        if (a <= 1) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            if (a == 1) {
                list.add(1);
            }
            lists.add(list);
            return lists;
        }

        ArrayList<ArrayList<Integer>> lists = prettyPrint(a-1);
        ArrayList<Integer> header = new ArrayList<>(2*a-1);
        for (int i=0; i<2*a-1; i++) {
            header.add(a);
        }
        ArrayList<Integer> tailer = new ArrayList<>(header);
        for (ArrayList<Integer> list : lists) {
            list.add(0, a);
            list.add(a);
        }
        lists.add(0, header);
        lists.add(tailer);

        return lists;
    }
}
