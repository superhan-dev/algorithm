function solution(k, m, score) {
    const boxCount = Math.floor(score.length / m);

    const boxs = Array.from({length: boxCount}, () => []);

    score.sort((a,b)=> b-a);

    let idx = 0;
    for(let i=0;i<boxs.length;i++) {
        while(boxs[i].length < m){
            boxs[i].push(score[idx]);
            idx++;
        }
    }
    
    let answer = 0;
    for(const box of boxs) {
        const min = box[m-1];
        answer += min * m
    }

    return answer;
}
