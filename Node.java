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
  public Node setNext(Node value) {
    Node middle = next;
    next = value;
    return middle;
  }

  public Node getPrev() {
    return prev;
  }
  public Node setPrev(Node value) {
    Node middle = prev;
    prev = value;
    return middle;
  }
}
