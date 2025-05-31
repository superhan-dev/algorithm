function addMinutes(time, minutesToAdd) {
  let hour = Math.floor(time / 100);
  let minute = time % 100;

  minute += minutesToAdd;
  if (minute >= 60) {
    hour += Math.floor(minute / 60);
    minute = minute % 60;
  }

  return hour * 100 + minute;
}

function solution(schedules, timelogs, startday) {
    const lateCheck = new Array(timelogs.length).fill(false);
    
    for(let i=0;i<timelogs.length;i++){
        let currday = startday;
        for(let j=0;j<7;j++){
            const day = currday % 7;
            if(day === 6 || day === 0){
                currday++;
                continue;
            }
            
            if(timelogs[i][j] > addMinutes(schedules[i],10)){
                lateCheck[i] = true;
            }
            currday++;
        }
    }
    
    return lateCheck.filter(item => !item).length;
}