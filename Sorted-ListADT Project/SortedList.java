
import java.util.AbstractList;
public class SortedList<E extends Comparable<? super E>>  extends AbstractList<E>{
    private Node<E> head;

    private static class Node <E>{
        E data;
        Node <E> next;

        Node(E data){
            this.data = data;
        }
    }
private void insert(Node<E> previous, Node<E> current, Node <E> node){
    if(current == null || node.data.compareTo(current.data) < 0){
        if(previous == null){
            node.next = head;
            head = node;
        }
        else{
            node.next = previous.next;
            previous.next = node;
        }
    }else{
        insert(current,current.next, node);
    }
}

public void insert(E value){
    Node <E> temp = new Node<E>(value);
    insert(null, head, temp);

}


private void remove(Node <E> previous, Node<E> current, E value){
    if(current == null){
    return;
    }
    if(current.data.compareTo(value) == 0){
        if(previous == null){
        head = current.next;
        }else{

    previous.next = current.next;
}

}else if(current.data.compareTo(value) > 0){
    return;
}else{ 
remove(current, current.next, value);
}
}

public void remove(E value){
    remove(null, head, value);
}

public E retrieve(int index){
    Node <E> current = head;
    for(int position = 0; current != null && position < index; position++){
        current = current.next;
    }
    if(current == null)
        return null;
    else
        return current.data;
}

private boolean search(Node<E> node, E value){
    if(node == null){
        return false;
    }
    if(node.data.equals(value))
    return true;
    else
    return search(node.next, value);
}
public boolean search(E value){
    return search(head,value);
}
public java.util.Iterator<E> iterator(){
    return new Iterator();
}
class Iterator implements java.util.Iterator <E>{
    Node<E> current = head;
    public boolean hasNext(){
        return current != null;
    }
    public E next(){
        E value = current.data;
        current = current.next;
        return value;
    }
}
@Override
public int size() {
    int count = 0; 
    Node<E> current = head;
    while (current != null){
        count++;
        current = current.next;
    }
    return count;
}

@Override
public E get(int index) {
   return retrieve(index);
}

public boolean remove(Object o) {
    if (o == null || !(o instanceof Comparable)) {
        return false; // Cannot remove a null or non-comparable object
    }
    @SuppressWarnings("unchecked")
    E value = (E) o;
    int oldSize = size();
    remove(value);
    return size() < oldSize; // Return true if an element was removed
}
}



