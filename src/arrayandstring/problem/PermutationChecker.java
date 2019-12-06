package arrayandstring.problem;

import java.util.Arrays;

public class PermutationChecker {
  
  String sort(String str) { // 문자열을 받아서 정렬해 리턴하는 메서드
    String[] strArr = str.split("");
    Arrays.sort(strArr);
    StringBuilder sb = new StringBuilder();
    for (String string : strArr) {
      sb.append(string);
    }
    return sb.toString();
  }
  
  boolean isPermutation(String str, String str2) {
    if(str.length() != str2.length()) { // 길이가 다르면 순열이 아니므로 false
      return false;
    }
    
    if(!sort(str).equals(sort(str2))) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    String str = "abcdaaa";
    String str2 = "aaadcba";
    System.out.println(new PermutationChecker().isPermutation(str, str2));
  }
}
