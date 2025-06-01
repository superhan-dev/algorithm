function solution(phone_book) {
    let answer = true;
    phone_book.sort();
    const set = new Set();
    for(const pb of phone_book){
        let str = ''
 
        for(let i=0;i<pb.length;i++){
            if(set.has(str)){
                return false;
            }    
            str += pb[i];
        }
        set.add(pb);
    }
    
    return answer;
}