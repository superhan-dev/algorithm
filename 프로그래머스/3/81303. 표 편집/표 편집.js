function solution(n, k, cmd) {
    const up = [...new Array(n+2)].map((_,i) => i-1);
    const down = [...new Array(n+1)].map((_,i) => i+1);
    
    k += 1;
    
    const deleted = [];
    
    for(const c of cmd){
        if(c[0] === 'C'){
            deleted.push(k);
            up[down[k]] = up[k];
            down[up[k]] = down[k];
            k = n < down[k] ? up[k] : down[k];
        } 
        
        else if(c[0] === 'Z'){
            const restore = deleted.pop();
            up[down[restore]] = restore;
            down[up[restore]] = restore;
        }
        
        else {
            const [act, num] = c.split(' ');
            if(act === 'U'){
                for(let i=0;i<num;i++){
                    k = up[k];
                }
            } else { 
                for(let i=0;i<num;i++){
                    k = down[k];
                }
            }    
        } 
        
    }
   
    const answer = new Array(n).fill('O');
    // answer의 값을 삭제되지 않은 행은 0 삭제된 행은 X
    for(const del of deleted){
       answer[del-1] = 'X' 
    }
    
    console.log(answer)
    return answer.join('');
}



