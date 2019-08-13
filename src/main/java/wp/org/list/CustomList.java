package wp.org.list;

public interface CustomList {

    void initList(int i);

    <E> void clearList(E list);

    <E> boolean listEmpty(E list);

    <E> int listLength(E list);

    <E> E getElem(E list, int i);

    <E> E priorElem(E list, E elem);

    <E> E nextElem(E list, E elem);

    <E> int listInsert(E list, int i, E elem);

    <E> E listDelete(E list, int i);

}
