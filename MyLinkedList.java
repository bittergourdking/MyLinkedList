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
   if (size == 0) {
     start = end = newNode;
     start.setPrev(null);
     end.setNext(null);
   } else {
     end.setNext(newNode);
     newNode.setPrev(end);
     newNode.setNext(null);
     end = newNode;
   }
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
   if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("Invalid index!");
   }
   Node newNode = new Node(value);
   if (size == 0) {
     start = end = newNode;
     start.setPrev(null);
     end.setNext(null);
   } else if (index == 0) {
     newNode.setNext(start);
     newNode.setPrev(null);
     start.setPrev(newNode);
     start = newNode;
   } else if (index == size) {
     newNode.setPrev(start);
     newNode.setNext(null);
     end.setNext(newNode);
     end = newNode;
   } else {
     newNode.setNext(findIndex(index));
     newNode.setPrev(findIndex(index).getPrev());
     findIndex(index - 1).setNext(newNode);
     findIndex(index).setPrev(newNode);
   }
   size++;
 }

 public String get(int index) {
   if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("Invalid index!");
   }
   return findIndex(index).getData();
 }

 public String set(int index, String value) {
   if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("Invalid index!");
   }
   return findIndex(index).setData(value);
 }

 public String toString() {
   Node current = start;
   String answer = "[";
   while (current != null) {
     answer += current.getData() + ", ";
     current = current.getNext();
    }
   return answer.substring(0, answer.length() - 2) + "]";
 }

 public String toStringReversed() {
   Node current = end;
   String answer = "[";
   while (current != null) {
     answer += current.getData() + ", ";
     current = current.getPrev();
    }
   return answer.substring(0, answer.length() - 2) + "]";
 }

 //Any helper method that returns a Node object MUST BE PRIVATE!
}
