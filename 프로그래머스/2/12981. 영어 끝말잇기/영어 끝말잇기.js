function solution(n, words) {
    let answer = [0,0];
    const set = new Set();

    for(let i=0;i<words.length;i++){
        const curr = words[i];
        const prev = words[i-1];
        
        if(prev) {
            const number = (i % n) + 1;
            const order = Math.floor(i/n) + 1;

            const isWrong = prev[prev.length-1] !== curr[0] || set.has(curr) || curr.length <= 0;
            
            if(isWrong) {
                answer = [number,order];
                break;
            }
        }
        set.add(curr);

    }
    
  
    return answer;
}