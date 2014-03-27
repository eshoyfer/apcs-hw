import java.io.*;
import java.util.*;

public class MyLinkedList<E> implements Iterable<E>{
	private Node<E> head;
	private Node<E> tail;

	public MyLinkedList(){
		head = null;
		tail = null;
	}

	public void add(E d){
		Node<E> tmp = head;
		Node<E> addNode = new Node<E>(d);
		if(tmp==null){
			head = addNode;
		}
		else {
			while(tmp.getNext()!=null){
				tmp = tmp.getNext();
			}
			tmp.setNext(addNode); //must do this first
			this.tail = addNode;
		}
	}

	public MyLLIterator<E> iterator(){
		return new MyLLIterator<E>(head);
	}

	public String toString(){
		Node<E> tmp = head;
		String s = "" + head;
		while(tmp!=null){
			s = s + tmp.getNext();
			tmp = tmp.getNext();
		}
		return s;
	}

	public void add(int i, E s){
		Node<E> tmp = head;
		for(int k = 0; k < i-1; k++){
			tmp = tmp.getNext();
		}
		Node<E> n = new Node<E>(s);
		n.setNext(tmp.getNext());
		tmp.setNext(n);

	}
	

	public E get(int i){
		Node<E> tmp = head;
		for(int k = 0;k<i;k++){
			tmp = tmp.getNext();
		}
		return tmp.getData();
	}

	public E set(int i, E s){
		Node<E> tmp = head;
		for(int k = 0; k < i; k++){
			tmp = tmp.getNext();
		}
		E original = tmp.getData();
		tmp.setData(s);
		return original;
	}

	public E remove(int i){
		Node<E> tmp = head;
		for(int k = 0; k < i; k++){
			tmp = tmp.getNext();
		}
		E s=tmp.getNext().getData();
		Node<E> n =tmp.getNext().getNext();
		tmp.setNext(n);
		return s;
	}

	public int find(E s){
		int i = 0;
		Node<E> tmp = head;
		while(tmp!=null){
			if(tmp.getData().equals(s)){
				return i;
			}
			tmp = tmp.getNext();
			i++;
		}
		return -1;
	}

	public int length(){
		int i = 0;
		Node<E> tmp = head;
		while(tmp!=null){
			tmp = tmp.getNext();
			i++;
		}
		return i;
	}

	public static void main(String[] args){
		MyLinkedList L = new MyLinkedList();
		System.out.println(L);
		L.add("Sully ");
		L.add("Mike ");
		L.add("LOL ");
		L.add(1,"Heh ");
		L.set(2,"Hi ");
		System.out.println(L);
		L.remove(1);
		System.out.println(L.length());
		System.out.println(L);		
	}
}
