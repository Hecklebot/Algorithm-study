package arrayandstring;

public class URLMaker {
  
  String makeUrl(String str) {
    StringBuilder sb = new StringBuilder();
    String[] strArr = str.split("");
    for (String s : strArr) {
      if(s.equals(" ")) {
        s="%20";
      }
      sb.append(s);
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(new URLMaker().makeUrl("dasd dsadsa aaa"));
  }
  
}
