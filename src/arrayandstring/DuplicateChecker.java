package arrayandstring;

import java.util.HashMap;

public class DuplicateChecker {
  
  boolean isDuplicated(String str) {
    HashMap<Character, Integer> check = new HashMap<>(); // char를 담는 HashMap를 만들고 
    for (int i = 0; i < str.length(); i++) { // 문자열을 잘라 각 글자를 key로 Map에 담는다.
      check.put(str.charAt(i), i);
    }
    
    if(!(check.size() == str.length())) { // key는 중복될 수 없으므로, 중복문자가 있다면 Map과 문자열의 길이는 다르다.
      return false;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    String str = "dsabdjascbkajcbadjlcbalk";
    System.out.println(new DuplicateChecker().isDuplicated(str));
    str = "abcdefghijklmnopqrst";
    System.out.println(new DuplicateChecker().isDuplicated(str));
    str = "cda56";
    System.out.println(new DuplicateChecker().isDuplicated(str));
  }
}
