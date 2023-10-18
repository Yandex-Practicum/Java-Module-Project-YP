package alexey.gritsenko.application.repository.impl;

import alexey.gritsenko.application.models.InvoiceItem;
import alexey.gritsenko.application.repository.RepositoryEngine;



public class RepositoryEngineImpl implements RepositoryEngine {
    private int size;
    private Node first;
    private Node last;
    private static class Node{
        public InvoiceItem item;
        public Node next;
        public Node prev;
    }

    public void add(InvoiceItem item){
        Node node = new Node();
        node.item = item;
        if(this.first==null){
            this.first = node;
            this.last = node;
            this.size =1;
            return;
        }
        Node oldLast  = this.last;
        oldLast.next = node;
        node.prev = oldLast;
        this.size++;
    }

    public InvoiceItem[] getArray(){
        InvoiceItem[] array = new InvoiceItem[this.size];
        int i = 0;
        for (Node x = first; x != null; x = x.next)
            array[i++] = x.item;
        return array;
    }
}
