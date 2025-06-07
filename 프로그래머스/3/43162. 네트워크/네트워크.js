function solution(n, computers) {
    let answer = 0;
    const visited = Array(computers.length).fill(false);
    
    function dfs(start){
        const stack = [start];
        while(stack.length > 0) {
            const curr = stack.pop();
            visited[curr] = true; 
            
            for(let i=0;i<computers[curr].length;i++){
                if(computers[curr][i] === 1 && !visited[i]){
                    stack.push(i);
                }
            }
        }
    }
    
    for(let i=0;i<computers.length;i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
    
    return answer;
}