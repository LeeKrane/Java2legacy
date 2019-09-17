package school.chif2.linkedListsOLD.linkedListSCRE;

public class LinkedList {
	
	private ListNode head, tail;
	private int size;
	
	public static void main (String[] args)
	{
		String[] names = {"Albert", "Bernd", "Caligula", "Daniela", "Emil", "Frieda", "Gerhard"};
		LinkedList list = new LinkedList();
		
		for (int i = 0; i < names.length; i++)
		{
			list.add(names[i]);
		}
		
		System.out.println(list);
		
		int sprungKommando = 3;
		int sprungKommandoIndex = 0;
		
		while (list.size > 1)
		{
			sprungKommandoIndex += sprungKommando;
			
			if (sprungKommandoIndex > list.size)
				sprungKommandoIndex = list.size - sprungKommandoIndex - 1;
			
			if (sprungKommandoIndex == list.size)
				list.delTail();
			else
				list.del(sprungKommandoIndex-1);
			
			System.out.println(list);
		}
		
		System.out.println(list);
	}
	
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void add(Object data) {
		ListNode neu = new ListNode(data);
		if (size == 0) {  //wenn Liste leer
			head = tail = neu;
		} else {
			tail.setNext(neu);  //neues Element ist Nachfolger des alten tail
			neu.setPrevious(tail);
			tail = neu;
			tail.setNext(head);
			head.setPrevious(tail);
		}
		size++;
	}
	
	public void add(Object data, int idx) {
		if (idx > size || idx < 0) {
			System.out.println("Index illegal: " + idx);
			return;
		}
		ListNode neu = new ListNode(data);
		if (size == 0) {  //wenn Liste leer
			head = tail = neu;
		} else if (idx == 0) {  //Liste nicht leer, einfügen am Anfang
			neu.setNext(head); //alter Head ist Nachfolger von Neuem
			head.setPrevious(neu);
			head = neu;
		} else if (idx == size) {
			tail.setNext(neu);
			neu.setPrevious(tail);
			tail = neu;
		} else {
			ListNode akt = head;
			for (int i = 0; i < idx - 1; i++) {
				akt = akt.getNext();
			}
			//akt ist jetzt Knoten direkt vor Einfügeposition
			neu.setNext(akt.getNext()); //alter Nachfolger von akt = Nachfolger von neu
			akt.getNext().setPrevious(neu);
			akt.setNext(neu);
			neu.setPrevious(akt);
		}
		size++;
	}
	
	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		ListNode akt = head;
		for (int i = 0; i < size; i++) {
			sb.append(akt);
			sb.append(", ");
			if (akt.getNext() != null)
				akt = akt.getNext();
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(']');
		return sb.toString();
	}
	
	public Object del(int idx) {
		if (size == 0 || idx < 0 || idx >= size) {
			return null;
		}
		if (size == 1 || idx == 0) {
			if (size == 1)
				return delHead();
			
			ListNode headOld = head;
			head = head.getNext();
			head.setPrevious(tail);
			tail.setNext(head);
			return headOld;
			//return delHead();
		}
		if (idx == size - 1) {
			ListNode tailOld = tail;
			tail = tail.getPrevious();
			tail.setNext(head);
			head.setPrevious(tail);
			return tailOld;
			//return delTail();
		}
		ListNode akt = head;
		for (int i = 0; i < idx - 1; i++) {
			akt = akt.getNext();
		}
		//akt ist Knoten vor dem zu löschendem
		ListNode toDel = akt.getNext();
		akt.setNext(toDel.getNext());
		toDel.getNext().setPrevious(akt);
		//akt.setNext(akt.getNext().getNext());
		size--;
		return toDel.getData();
	}
	
	public void delTail() {
		if (size == 0) {
			return;
		}
		if (size == 1) {
			delHead();
			return;
		}
		ListNode akt = tail.getPrevious();
		//akt ist Knoten vor tail ==> neuer tail
		tail = akt;
		tail.setNext(head);
		size--;
	}
	
	public void delAll(Object data) {
		if (size == 0) {
			return;
		}
		ListNode akt = head;
		while (akt != null && akt.getData().equals(data)) {
			delHead();
			akt = head;
		}
		while (akt != null && akt.getNext() != tail && akt != tail) {
			if (akt.getNext().getData().equals(data)) {
				akt.setNext(akt.getNext().getNext());
				size--;
			} else {
				akt = akt.getNext();
			}
		}
		if (tail != null && tail.getData().equals(data)) {
			tail = akt;
			tail.setNext(null);
			size--;
		}
	}
	
	private Object delHead() {
		if (size == 0) {
			return null;
		}
		Object ret = head.getData();
		if (size == 1) {
			head = tail = null;
			size = 0;
			return ret;
		}
		head.getNext().setPrevious(tail);
		head = head.getNext();
		tail.setNext(head);
		size--;
		return ret;
	}
	
	public Object get(int idx) {
		if (idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException("Index: " + idx);
		}
		ListNode akt = head;
		for (int i = 0; i < idx; i++) {
			akt = akt.getNext();
		}
		return akt.getData();
	}
}
