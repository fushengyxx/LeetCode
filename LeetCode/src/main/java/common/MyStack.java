package common;

import java.util.Vector;

/**
 * Created by yixinxin on 17/3/8.
 */
public class MyStack<E> extends Vector<E>{
    public MyStack(){

    }

    private E head;
    private E tail;

    // push
    public E push(E item){
        addElement(item);
        return item;
    }

    public synchronized E pop() {
        E obj;
        int len = size();

        obj = peek();

        // delete the tail
        removeElementAt(len - 1);

        return obj;
    }

    // return the tail, but do not delete it
    public synchronized E peek() {
        int len = size();

        if(len == 0)
            return null;
            // throw new EmptyStackException
        return elementAt(len - 1);
    }

    public boolean empty(){
        return size() == 0;
    }

    // find the index: from the bottom to the top
    public synchronized int search(Object o){
        int i = lastIndexOf(o); // 从向量尾部开始逆向搜索obj,尾部是1

        if(i >= 0)
            return size() - i;

        return -1;
    }

}
