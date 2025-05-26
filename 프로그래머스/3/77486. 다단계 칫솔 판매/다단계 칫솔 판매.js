function solution(enroll, referral, seller, amount) {
    const parent = {};
    
    for(let i=0;i<enroll.length;i++){
        parent[enroll[i]] = referral[i];
    }
    
    const total = {};
    enroll.forEach(name => {
        total[name] = 0;
    })
    
    for(let i=0;i<seller.length;i++){
        let money = amount[i] * 100;
        let curr = seller[i];

        while(money > 0 && curr != '-'){
            const tenPercent =  Math.floor(money / 10);
            total[curr] += money - tenPercent;

            curr = parent[curr];
            money = tenPercent;
        }
    }
    
    return enroll.map(name => total[name]);
}