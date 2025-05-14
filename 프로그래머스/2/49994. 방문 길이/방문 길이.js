function solution(dirs) {
   
    const visited = new Set();
    let answer = 0;
    
    const step = {'L': [0,-1],'R':[0,1],'U':[-1,0],'D':[1,0]};
    let x=0;
    let y=0;
    
    for(let i=0;i<dirs.length;i++){
        const dir = dirs[i];
        
        const [dx,dy] = step[dir];
        const nx = x+dx;
        const ny = y+dy;
        
        if(nx < -5 || nx > 5 || ny < -5 || ny > 5){
            continue;
        }
        
        const path = `${x},${y}-${nx},${ny}`;
        const reverse = `${nx},${ny}-${x},${y}`;
        
        if(!visited.has(path)){
            visited.add(path);
            visited.add(reverse);
            answer++;
        }
        
        x=nx;
        y=ny;
        
    }
    
    
    return answer;
}