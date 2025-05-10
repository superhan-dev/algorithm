function solution(answers) {
    var answer = [0,0,0];
    
    const patterns = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ];
    
   for(const [i,a] of answers.entries()){
       for(const [j,p] of patterns.entries()){
           if(a === p[i % p.length]){
               answer[j] += 1;
           }
       }
   }
    
    const maxScore = Math.max(...answer);
    
    const highestScore = [];
    for(let i=0;i<answer.length;i++) {
        if(answer[i] === maxScore){
            highestScore.push(i+1);
        }
    }

    return highestScore;
}