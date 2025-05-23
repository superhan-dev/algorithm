function solution(participant, completion) {
    const map = {};
    
    for(const p of participant) {
        if(map[p]) {
            map[p] += 1;
        } else {
            map[p] = 1;
        }
    }
    
    for(const c of completion) {
        map[c] -= 1;
    }
    
    for(const m in map) {
        if(map[m] > 0){
            return m;
        }
    }
}