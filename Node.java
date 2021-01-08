public class Node {
  //private variables
  private String data;
  private Node next, prev;
  //constructor
  public Node(String value) {
    data = value;
  }
  //methods
  public String getData() {
    return data;
  }
  public String setData(String value) {
    String middle = data;
    data = value;
    return middle;
  }

  public Node getNext() {
    return next;
  }
  public void setNext(Node n) {
    next = n;
  }

  public Node getPrev() {
    return prev;
  }
  public void setPrev(Node n) {
    prev = n;
  }
}
