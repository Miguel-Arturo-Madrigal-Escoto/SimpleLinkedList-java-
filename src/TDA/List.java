package TDA;

import domain.Song;
import exceptions.ListException;

public class List<T> {

    public class Node<T> {

        private T data;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T e) {
            this.data = e;
            this.next = null;
        }

        public void setNext(Node e) {
            this.next = e;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

    }

    private Node anchor;

    public List() {
        this.anchor = null;
    }

    public boolean isEmpty() {
        return anchor == null;
    }

    public boolean isValidPos(List.Node p) {

        Node aux = anchor;

        while (aux != null) {
            if (aux == p) {
                return true;
            }

            aux = aux.getNext();
        }

        return false;
    }

    public Node getFirstPos() {
        return anchor;
    }

    public Node getLastPos() {
        if(isEmpty()){
            return null;
        }
        
        Node aux = anchor;

        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        return aux;
    }

    public Node getPrevPos(Node p) {
        if(p == anchor){
            return null;
        }
        
        Node aux = anchor;

        while (aux != null && aux.getNext() != p) {
            aux = aux.getNext();
        }

        return aux;
    }

    public Node getNextPos(List.Node p) {
        return (!isValidPos(p)) ? null : p.getNext();
    }

    public void insertData(List.Node p, T e) throws ListException {
        if (p != null && !isValidPos(p)) {
            throw new ListException("Posicion invalida, insertData");
        }

        Node aux = new Node(e);

        if (aux == null) {
            throw new ListException("Memoria NO disponible, insertData");
        }

        if (p == null) {
            aux.setNext(anchor);
            this.anchor = aux;
        } else {
            aux.setNext(p.getNext());
            p.setNext(aux);
        }
    }

    public void deleteData(List.Node p) throws ListException {
        if (!isValidPos(p)) {
            throw new ListException("Posicion invalida, deleteData");
        }

        // eliminar el primero
        if (p == anchor) {
            this.anchor = anchor.getNext();
        } else {
            getPrevPos(p).setNext(p.getNext());
        }
        //eliminar en cualquier otro caso

        p = null;
        System.gc();
    }

    public Node findData(T e) throws ListException {
        Node aux = anchor;
        while (aux != null && !Song.compare((Song) aux.getData(), (Song) e)) {
            aux = aux.getNext();
        }

        return aux;

    }

    public T retrieve(List.Node p) throws ListException {
        if (!isValidPos(p)) {
            throw new ListException("Posicion invalida, retrieve");
        }

        return (T) p.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node aux = anchor;

        while (aux != null) {
            sb.append(aux.getData()).append("\n");
            aux = aux.getNext();
        }

        return sb.toString();
    }

    private void deleteAll() {

        Node aux;

        while (anchor != null) {
            aux = anchor;
            anchor = anchor.getNext();

            aux = null;
            System.gc();
        }
    }
    
    @Override
    public void finalize() throws Throwable{
        try {
            deleteAll();
        } finally {
            super.finalize();
        }
    }
}
