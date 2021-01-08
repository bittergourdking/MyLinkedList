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
     newNode.setPrev(end);
     newNode.setNext(null);
     end.setNext(newNode);
     end = newNode;
   } else {
     newNode.setNext(findIndex(index));
     newNode.setPrev(findIndex(index - 1));
     findIndex(index).setPrev(newNode);
     findIndex(index - 1).setNext(newNode);
   }
   size++;
 }

 public String remove(int index) {
   if (index < 0 || index > size || size == 0) {
     throw new IndexOutOfBoundsException("Invalid index!");
   }
   String answer = findIndex(index).getData();
   if (index == 0) {
     start = findIndex(1);
     start.setPrev(null);
   } else if (index == size) {
     end = findIndex(index - 1);
     end.setNext(null);
   } else {
     findIndex(index + 1).setPrev(findIndex(index - 1));
     findIndex(index - 1).setNext(findIndex(index + 1));
   }
   return answer;
 }

 public void extend(MyLinkedList other) {
   if (other.size() == 0) {
     //nothing
   } else if (size == 0) {
     start = other.start;
     end = other.end;
     size = other.size;
     other.start = other.end = null;
     other.size = 0;
   } else {
     end.setNext(other.start);
     other.start.setPrev(end);
     end = other.end;
     size = size + other.size;
     other.start = end = null;
     other.size = 0;
   }
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
   if (size == 0) {
     return "[]";
   }
   Node current = start;
   String answer = "[";
   while (current != null) {
     answer += current.getData() + ", ";
     current = current.getNext();
    }
   return answer.substring(0, answer.length() - 2) + "]";
 }

 public String toStringReversed() {
   if (size == 0) {
     return "[]";
   }
   Node current = end;
   String answer = "[";
   while (current != null) {
     answer += current.getData() + ", ";
     current = current.getPrev();
    }
   return answer.substring(0, answer.length() - 2) + "]";
 }
}
