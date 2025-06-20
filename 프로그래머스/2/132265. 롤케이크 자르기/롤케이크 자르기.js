function solution(toppings) {
    let answer = 0;
    
    const map = new Map();
    toppings.forEach((t) => {
        map.set(t, (map.get(t) || 0) + 1);
    });
    
    const set = new Set();
    toppings.forEach((t) => {
        set.add(t);
        
        map.set(t, map.get(t)-1);
        if(map.get(t)===0) map.delete(t);
        
        if(map.size === set.size) answer++;
    })
    
    return answer;
}