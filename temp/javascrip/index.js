let arr = ["h", "e", "l", "l", "o"];

var reverse = (arr) => {
  let temp;
  let tail = arr.length - 1;

  for (let i = 0; i < arr.length; i++) {
    if (i === tail) break;
    if (i !== tail) {
      temp = arr[tail];
      arr[tail] = arr[i];
      arr[i] = temp;
    }

    console.log(arr);
    tail--;
  }

  return arr;
};

console.log(reverse(arr));
console.log('commit test')
