package programmers;

public class ExpressNumber {
  public int solution(int n) {
    int sum=0;
    int answer = 0;
    
    for(int i = 1; i <= n; i++) {
      sum = 0;
      for(int j=i; j<=n; j++) {
          sum += j;
          if(sum > n) {
            break;
          }
          if(sum == n) {
            answer += 1;
          }
        }
      }
    return answer;
  }
  
  public static void main(String[] args) {
    System.out.println(new ExpressNumber().solution(7));
  }
}
