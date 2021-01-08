public class MyLinkedList {
  //private variables
 private int size;
 private Node start, end;
 //constructor
 public MyLinkedList() {
   size = 0;
 }
 //methods
 public int size() {
   return size;
 }

 public boolean add(String value) {
   Node newNode = new Node(value);
   end.setNext(newNode);
   newNode.setPrev(end);
   end = newNode;
   size++;
   return true;
 }

 private Node findIndex(int index) {
   Node answer = start;
   for (int i = 0; i < index; i++) {
     answer = answer.getNext();
   }
   return answer;
 }

 public void add(int index, String value) {
   Node newNode = new Node(value);
   if (index != 0) {
     findIndex(index - 1).setNext(newNode);
     newNode.setPrev(findIndex(index - 1));
   }
   if (index != size) {
     findIndex(index).setPrev(newNode);
     newNode.setNext(findIndex(index));
   }
 }

 public String get(int index) {
   return findIndex(index).getData();
 }

 public String set(int index, String value) {
   return findIndex(index).setData(value);
 }

 public String toString() {
   //fix
   Node current = start;
   String answer = "[";
   while (current != null) {
     answer += current.getData() + ", ";
     current = current.getNext();
    }
   return answer.substring(0, answer.length() - 2);
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
