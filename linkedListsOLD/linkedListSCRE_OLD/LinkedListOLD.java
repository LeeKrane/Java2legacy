package school.chif2.linkedListsOLD.linkedListSCRE_OLD;

public class LinkedListOLD
{
  private ListNodeOLD head, tail;
  private int size;
  
  public static void main (String[] args)
  {
  
  }
  
  public LinkedListOLD ()
  {
    head = tail = null;
    size = 0;
  }

  public int size ()
  {
    return size;
  }

  public void add (Object data)
  {
    ListNodeOLD neu = new ListNodeOLD(data);
    if (size == 0)
    {  //wenn Liste leer
      head = tail = neu;
    }
    else
    {
      tail.setNext(neu);  //neues Element ist Nachfolger des alten tail
      neu.setPrevious(tail);
      tail = neu;
    }
    size++;
  }

  public void add (Object data, int idx)
  {
    if (idx > size || idx < 0)
    {
      System.out.println("Index illegal: " + idx);
      return;
    }
    ListNodeOLD neu = new ListNodeOLD(data);
    if (size == 0)
    {  //wenn Liste leer
      head = tail = neu;
    }
    else if (idx == 0)
    {  //Liste nicht leer, einfügen am Anfang
      neu.setNext(head); //alter Head ist Nachfolger von Neuem
      head.setPrevious(neu);
      head = neu;
    }
    else if (idx == size)
    {
      tail.setNext(neu);
      neu.setPrevious(tail);
      tail = neu;
    }
    else
    {
      ListNodeOLD akt = head;
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
  public String toString ()
  {
    if (size == 0)
    {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    ListNodeOLD akt = head;
    for (int i = 0; i < size; i++)
    {
      sb.append(akt);
      sb.append(", ");
      akt = akt.getNext();
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append(']');
    return sb.toString();
  }

  public Object del (int idx)
  {
    if (size == 0 || idx < 0 || idx >= size)
    {
      return null;
    }
    if (size == 1 || idx == 0)
    {
      return delHead();
    }
    if (idx == size - 1)
    {
      return delTail();
    }
    ListNodeOLD akt = head;
    for (int i = 0; i < idx - 1; i++)
    {
      akt = akt.getNext();
    }
    //akt ist Knoten vor dem zu löschendem
    ListNodeOLD toDel = akt.getNext();
    akt.setNext(toDel.getNext());
    toDel.getNext().setPrevious(akt);
    //akt.setNext(akt.getNext().getNext());
    size--;
    return toDel.getData();
  }

  public Object delTail ()
  {
    if (size == 0)
    {
      return null;
    }
    if (size == 1)
    {
      return delHead();
    }
    ListNodeOLD akt = tail.getPrevious();
    //akt ist Knoten vor tail ==> neuer tail
    Object oldTail = tail.getData();
    tail = akt;
    tail.setNext(null);
    size--;
    return oldTail;
  }

  public void delAll (Object data)
  {
    if (size == 0)
    {
      return;
    }
    ListNodeOLD akt = head;
    while (akt != null && akt.getData().equals(data))
    {
      delHead();
      akt = head;
    }
    while (akt != null && akt.getNext() != tail && akt != tail)
    {
      if (akt.getNext().getData().equals(data))
      {
        akt.setNext(akt.getNext().getNext());
        size--;
      } else {
        akt = akt.getNext();
      }
    }
    if (tail != null && tail.getData().equals(data))
    {
      tail = akt;
      tail.setNext(null);
      size--;
    }
  }

  private Object delHead ()
  {
    if (size == 0)
    {
      return null;
    }
    Object ret = head.getData();
    if (size == 1)
    {
      head = tail = null;
      size = 0;
      return ret;
    }
    head.getNext().setPrevious(null);
    head = head.getNext();
    size--;
    return ret;
  }

  public Object get (int idx) {
    if (idx < 0 || idx > size - 1)
    {
      throw new IndexOutOfBoundsException("Index: " + idx);
    }
    ListNodeOLD akt = head;
    for (int i = 0; i < idx; i++)
    {
      akt = akt.getNext();
    }
    return akt.getData();
  }
}
