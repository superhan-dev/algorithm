function solution(k, dungeons) {
    var answer = -1;
    
    const stage = dungeons.length;
    
    const visited = Array(stage).fill(false);
    
    function dfs(curK, cnt, dungeons, visited){
        let max = cnt;
        for(let i=0;i<stage;i++){
            if(curK >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
             
                max = Math.max(max, dfs(curK-dungeons[i][1], cnt+1, dungeons, visited));
                visited[i] = false;
            }
        }
        
        return max;
    }
    
    answer = dfs(k,0,dungeons,visited);
    
    return answer;
}