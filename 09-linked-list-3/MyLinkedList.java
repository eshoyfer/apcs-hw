import java.io.*;
import java.util.*;

public class MyLinkedList{
	private Node head;
	private Node tail;

	public MyLinkedList(){
		head = null;
		tail = null;
	}

	public void add(String d){
		Node tmp = head;
		Node addNode = new Node(d);
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

	public String toString(){
		Node tmp = head;
		String s = "" + head;
		while(tmp!=null){
			s = s + tmp.getNext();
			tmp = tmp.getNext();
		}
		return s;
	}

	public void add(int i, String s){
		Node tmp = head;
		for(int k = 0; k < i-1; k++){
			tmp = tmp.getNext();
		}
		Node n = new Node(s);
		n.setNext(tmp.getNext());
		tmp.setNext(n);

	}
	

	public String get(int i){
		Node tmp = head;
		for(int k = 0;k<i;k++){
			tmp = tmp.getNext();
		}
		return "" + tmp;
	}

	public String set(int i, String s){
		Node tmp = head;
		for(int k = 0; k < i; k++){
			tmp = tmp.getNext();
		}
		String original = tmp.getData();
		tmp.setData(s);
		return original;
	}

	public String remove(int i){
		Node tmp = head;
		for(int k = 0; k < i; k++){
			tmp = tmp.getNext();
		}
		String s=tmp.getNext().getData();
		Node n =tmp.getNext().getNext();
		tmp.setNext(n);
		return s;
	}

	public int find(String s){
		int i = 0;
		Node tmp = head;
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
		Node tmp = head;
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