function solution(n) {
  let answer = 0;
  if(n < 3) {
    answer = 1;
    return answer;
  }
  for(let i = 1; i < n ; i += 1) {
    let count;
    for(let j = 1; j < n; j += 1) {
      if(count <= n) {
        count += j;
      }
    }
  }
  return answer;
}

/*
10 1+2+3+4, 10
11 5+6, 11
12 3+4+5, 12
13 6+7, 13
14 2+3+4+5, 14
15 1+2+3+4+5, 4+5+6, 7+8, 15
16 16

*/