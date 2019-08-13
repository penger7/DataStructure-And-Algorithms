package wp.org.list;

import java.util.ArrayList;
import java.util.List;

public class SequenceList<E> {
    private List<E> sqList;

    SequenceList(){
        initList(-1);
    }

    SequenceList(int i){
        initList(i);
    }

    private void initList(int i){
        if(null == sqList) {
            if (i < 0) {
                sqList = new ArrayList<E>();
            } else {
                sqList = new ArrayList<E>(i);
            }
        }else {
            System.out.println(sqList);
        }
    }

    public void clearList() {
        sqList = new ArrayList<E>();
    }

    public boolean listEmpty() {
        return sqList.isEmpty();
    }

    public int listLength() {
        return sqList.size();
    }

    public E getElem(int i) {
        return sqList.get(i);
    }

    public void setElem(E elem){
        sqList.add(elem);
    }

    public int listInsert(int i, E elem) {
        if(i < 0 || i > sqList.size()){
            return -1;
        }
        for(int k=sqList.size();k>=i;k--){
            if(k != 0) {
                E tmp = sqList.get(k - 1);
                if(k == sqList.size()){
                    sqList.add(k,tmp);
                }else {
                    sqList.set(k, tmp);
                }
            }
        }
        sqList.set(i,elem);
        return 0;
    }

    public E listDelete(int i) {
        if(i < 0 || i >= sqList.size()){
            return null;
        }
        E tmp = sqList.get(i);
        for(int k=i;k<sqList.size()-1;k++){
                E a = sqList.get(k + 1);
                sqList.set(k, a);
        }
        sqList.remove(sqList.size()-1);
        return tmp;
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "sqList=" + sqList.toString() +
                '}';
    }

    public static void main(String[] args){
        SequenceList<Integer> sl = new SequenceList<>(10);
        System.out.println(sl.listLength());
        sl.setElem(1);
        sl.setElem(2);
        sl.setElem(3);
        System.out.println(sl.toString());
        sl.listInsert(3, 4);
        System.out.println(sl.toString());
        System.out.println(sl.listDelete(1));
        System.out.println(sl.toString());
    }
}
