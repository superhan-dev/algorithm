function solution(l, r) {
    let answer = [];
    
    for(let num=l;num<=r;num++){
        let count=0;
        let strNum = String(num);
        strNum.split("").forEach(digit => {
          if(digit == "5" || digit == "0") count++;
        });
        
        if(count === strNum.length) answer.push(num);
    }
    
    console.log(answer.length === 0);
    
    answer.length === 0 ? answer.push(-1) : null;
  
    return answer;
}