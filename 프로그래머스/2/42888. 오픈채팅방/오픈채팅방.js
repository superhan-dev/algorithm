

function solution(record) {
    const user = {}   
    
    for(const r of record) {
        const curr = r.split(' ');
        
        const id = curr[1];
        const name = curr[2];
        user[id] = {
          name: name ? name : user[id].name,
        }  
    }
    
    const answer = [];
    for(const r of record) {
        const curr = r.split(' ');
        
        const cmd = curr[0];
        const id = curr[1];
        const name = curr[2];
        
        if(cmd === 'Enter') {
            answer.push(`${user[id].name}님이 들어왔습니다.`)
        } 
        if(cmd === 'Leave') {
            answer.push(`${user[id].name}님이 나갔습니다.`);
        }
    }
    
    return answer;
}