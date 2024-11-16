import java.util.LinkedList;

public class SortedLinkedList<E extends Comparable<? super E>> extends LinkedList<E> {

    @Override
    public boolean add(E e) {
        if (isEmpty()) {
            return super.add(e);
        }

        int index = 0;
        for (E Object : this) {
            if (Object.compareTo(e) > 0) {
                break;
            }
            index++;
        }

        super.add(index, e);
        return true;
    }
}


