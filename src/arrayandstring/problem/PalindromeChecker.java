package arrayandstring.problem;

public class PalindromeChecker {
  
  boolean isPalindrome(String str, String str2) {
    if(str.length() != str2.length()) {
      return false;
    }
    
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    if(!sb.toString().equals(str2)) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(new PalindromeChecker().isPalindrome("abcde", "edcba"));
  }

}
