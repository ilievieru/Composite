package base;

import java.util.ArrayList;

/**
 * Created by V3790149 on 5/5/2016.
 */
public class ID {
    public static  ArrayList<Integer> idList = new ArrayList<Integer>();
    public static boolean testId(int id) {
        for (int i : idList)
            if (id ==  i)
                return false;
        return true;
    }
    public static void addIdList(int id){
        idList.add(id);
    }

}
