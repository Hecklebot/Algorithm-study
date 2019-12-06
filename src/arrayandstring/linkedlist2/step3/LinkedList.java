//LinkedList : 목록으로 다루는 값을 특정 타입으로 제한하기 위해 제네릭 적용하기
package arrayandstring.linkedlist2.step3;

import java.lang.reflect.Array;

public class LinkedList<T> {
  Node<T> head;
  Node<T> tail;
  int size = 0;

  public LinkedList() {}

  public boolean add(T value) {
    Node<T> temp = new Node<>(value);
    if (head == null) {
      head = temp;
    }

    if (tail != null) {
      tail.next = temp;
    }
    tail = temp;
    size++;
    return true;

    // 결과 : head의 value는 null next는 다음 Node, tail에 head.next를 대입하고, tail.vaule에 입력받은 value,
    // tail.next은 null
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스가 유효하지 않습니다. length = %s", this.size));
    }

    Node<T> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node.value;
  }

  public T set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스가 유효하지 않습니다. length = %s", this.size));
    }

    Node<T> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    T oldValue = node.value; // 노드에 저장된 기존 값 백업
    node.value = value;
    return oldValue; // 기존 변경값 리턴
  }


  public int size() {
    return size;
  }

  // 특정 위치의 값을 삭제하는 remove 메서드
  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(String.format("인덱스가 유효하지 않습니다. length = %s", this.size));
    }
    Node<T> deletedNode = null;
    if (index == 0) {
      deletedNode = head;
      head = deletedNode.next;
    } else {
      Node<T> node = head;
      for (int i = 0; i < index - 1; i++) {
        // 삭제하려는 노드의 이전 노드까지 간다.
        node = node.next;
      }

      deletedNode = node.next; // 삭제될 노드를 임시 보관한다.
      node.next = deletedNode.next; // 삭제될 노드의 다음 노드를 가리킨다.

      if (deletedNode == tail) { // 삭제할 노드가 마지막 노드라면
        tail = node; // tail 노드를 변경한다.
      }
    }

    Object oldValue = deletedNode.value; // 삭제될 노드의 값을 보관한다.
    deletedNode.value = null; // 삭제될 노드가 다른 객체를 참조하지 않도록 초기화한다.
    deletedNode.next = null; // 이런 식으로 개발자가 메모리 관리에 기여할 수 있다.

    size--;
    return oldValue; // 기존 변경값 리턴
  }

  public void clear() {
    if(size == 0) {
      return;
    }
    
    //노드를 따라가면서 삭제하기
    while(head != null) {
      Node<T> deletedNode = head;
      head = head.next;
      deletedNode.value = null;
      deletedNode.next = null;
    }
    
    head = tail = null;
    size = 0;
  }

  public Object[] toArray() {
    //LinkedList에 있는 데이터를 저장할 배열을 준비한다.
    Object[] obj = new Object[size];
    
    //LinkedList의 head부터 tail까지 반복하면서 배열에 value를 리턴한다.
    Node<T> temp = head;
    for(int i=0; i<size ;i++) {
      obj[i] = temp.value;
      temp = temp.next;
    }
    
    return obj;
    
//    Node temp = head;
//    Object[] arr = new Object[size];
//    int i=0;
//    while(temp != null) {
//      arr[i++] = temp.value;
//      temp = temp.next;
//    }
//
//    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if (a.length < size) { //받은 배열 크기가 더 작으면? 새 배열 만들어서 리턴
      // 파라미터로 넘겨 받은 배열의 크기가 저장된 데이터의 갯수보다 작다면, 이 메서드에서 새 배열을 만든다.
      a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
    }
    
    Node<T> node = head;
    for(int i=0; i<size ;i++) {
      a[i] = node.value;
      node = node.next;
    }
    
    if (a.length > size) { //받은 배열 크기가 더 크다면? 받은 배열 남는 곳 잘라내고 리턴
      a[size] = null;
    }
    return a;
  
  }
  
  
  //Node 객체에 보관하는 데이터의 클래스 이름을 "타입 파라미터 T" 로 받는다.
  static class Node<T> { 
    T value; //저장할 값
    Node<T> next;    //다음 리스트의 주소
    
    public Node(T value) {
      this.value = value;
    }
    
    public Node() {

    }
  }  
}
