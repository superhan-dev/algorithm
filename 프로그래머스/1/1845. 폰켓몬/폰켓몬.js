function solution(nums) {
    let answer = -1;
    const set = new Set();
    nums.forEach((num) => {
        set.add(num);
        
        if(set.size <= nums.length / 2){
            answer = set.size;
            return;
        }
    })
    
    return answer;
}