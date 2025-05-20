function solution(board, moves) {
    var answer = 0;
    
    const stacks = Array.from({length:board.length}, () => []);
    
    for(let i=board.length-1;i>=0;i--) {
        for(let j=0;j<board[0].length;j++){
            if(board[i][j] > 0){
                stacks[j].push(board[i][j]);    
            }
        }
    }
    const temp = [];
    
    for(const m of moves){
        if(stacks[m-1].length > 0){
            const d = stacks[m-1].pop();

            if(temp.length > 0 && d === temp[temp.length-1]){
                temp.pop();
                answer += 2;
            } else {
                temp.push(d);
            }
        }
        
    }
    
    return answer;
}