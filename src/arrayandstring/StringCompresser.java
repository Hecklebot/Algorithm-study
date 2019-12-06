package arrayandstring;

public class StringCompresser {
  
  String compressString(String str) {
    StringBuilder sb = new StringBuilder();
    int compressNum = 1;
    for(int i=0; i<str.length(); i++) {
      if(i == str.length()-1) {
        sb.append(str.charAt(i));
        sb.append(compressNum);
        break;
      }
      
      if(str.charAt(i) == str.charAt(i+1)) {
        compressNum++;
      } else {
        sb.append(str.charAt(i));
        sb.append(compressNum);
        compressNum = 1;
      }
    }
    
    if(sb.toString().length() > str.length()) {
      return str;
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(new StringCompresser().compressString("aaaccdddeegggggg"));
  }
}
