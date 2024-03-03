# Logic

Shift all values except the last value.
After shifting, put the last value to the first index of `arr`

# Code

```javascript
let arr = [1, 2, 3, 4, 5, 6];
let k = 3;

let temp;
for (let i = 0; i < k; i++) {
  temp = arr[arr.length - 1];

  for (let j = arr.length - 1; j >= 0; j--) {
    arr[j] = arr[j - 1];
  }
  arr[0] = temp;
}
```
