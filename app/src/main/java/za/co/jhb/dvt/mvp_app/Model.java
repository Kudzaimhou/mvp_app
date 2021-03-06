package za.co.jhb.dvt.mvp_app;

/**
 * Created by Kudzaishe Mhou on 5/16/2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private List<Integer> mList;

    public Model(){
        mList = new ArrayList<Integer>(3);
        mList.add(0);
        mList.add(0);
        mList.add(0);
    }

    public int getValueIndex(final int the_index) throws IndexOutOfBoundsException{
       return mList.get(the_index);
    }
    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
       mList.set(the_index, mList.get(the_index)+1);
        setChanged();
        notifyObservers();
    }
}
