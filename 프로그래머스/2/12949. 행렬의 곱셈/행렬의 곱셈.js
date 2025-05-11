function solution(a, b) {
    const r1 = a.length;
    const c1 = a[0].length;

    const r2 = b.length;
    const c2 = b[0].length;
    
    const answer = Array.from({length: r1}, () => new Array(c2).fill(0));

    for(let i=0;i<r1;i++){
        for(let j=0;j<c2;j++){
            for(let k=0;k<c1;k++){
                answer[i][j] += a[i][k]*b[k][j];
            }
        }
    }
    
    return answer;
}