

function solution(record) {
    const user = {}   
    const action = [];
    const stateMap = {
        'Enter': '들어왔습니다.',
        'Leave': '나갔습니다.',
    }
    
    record.forEach((r) => {
        const [state,id,name] = r.split(' ');
        
        if(state !== 'Change') {
            action.push([state,id]);
        } 
        
        if(name) {
            user[id] = {
                name:name
            };
        }
    });
    
    return action.map(([state,id]) => {
        return `${user[id].name}님이 ${stateMap[state]}`;
    })
    
}