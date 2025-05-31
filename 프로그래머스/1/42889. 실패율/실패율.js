function solution(N, stages){
	const challenger = new Array(N+2).fill(0);

	for(let i=0; i<stages.length;i++){
		challenger[stages[i]] += 1;
	}
	const fail = {};
	let total = stages.length;

	for(let i=1;i<N+1;i++){
		fail[i] = challenger[i] / total;
        total -= challenger[i];
    }    
    
    const result = Object.entries(fail).sort((a,b)=> b[1] - a[1]);
    return result.map(val => Number(val[0]));
}