function solution(keyinput, board) {
    let x=0,y=0;
    
    const move = {
        'up':[0,1],
        'down':[0,-1],
        'left':[-1,0],
        'right':[1,0]
    };
    
    const width = Math.floor(board[0]/2);
    const height = Math.floor(board[1]/2);
    
    function isInBound(w,x,dx,h,y,dy){
        return -w <= x+dx && 
            w >= x+dx &&
            -h <= y+dy &&
            h >= y+dy;
    }
    
    for(const key of keyinput){
        const [dx,dy] = move[key];
        if(isInBound(width,x,dx,height,y,dy)) {
            x+=dx;
            y+=dy;
        }
    }
    
    return [x,y];
}