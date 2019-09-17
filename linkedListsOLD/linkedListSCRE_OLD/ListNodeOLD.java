package school.chif2.linkedListsOLD.linkedListSCRE_OLD;

public class ListNodeOLD
{

  private Object data;  //zu kapselnde Daten
  private ListNodeOLD next, previous;  //nächster Eintrag in der Liste

  public ListNodeOLD getPrevious() {
    return previous;
  }

  public void setPrevious(ListNodeOLD previous) {
    this.previous = previous;
  }

  public ListNodeOLD (Object data) {
    this.data = data;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ListNodeOLD getNext() {
    return next;
  }

  public void setNext(ListNodeOLD next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
