function solution(maps) {
    const n = maps.length;
    const m = maps[0].length;
    
    const dist = Array.from({length: n}, () => Array(m).fill(-1));
    
    const dirc = [[-1,0],[1,0],[0,-1],[0,1]];
    
    const visited = new Set();
    
    function bfs(start){
        const q = [];
        dist[start[0]][start[1]] = 1;
        
        q.push([...start]);
        
        while(q.length > 0){
            const [x,y] = q.shift();
            
            
            for(const [dx,dy] of dirc){
                let nx = dx + x;
                let ny = dy + y;
      
                if(visited.has(`${nx}${ny}${x}${y}`)) continue;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] === 0) continue;
                
                if(!visited.has(`${nx}${ny}${x}${y}`) && dist[nx][ny] <= -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push([nx,ny]);
                    
                    visited.add(`${nx}${ny}${x}${y}`)
                    visited.add(`${x}${y}${nx}${ny}`)
                }
            }
        }
        return dist;
    }
    
    bfs([0,0]);
    
    return dist[n-1][m-1];
}