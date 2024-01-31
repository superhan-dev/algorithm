const iterariveBinarySearch = (list, target) => {
  let first = 0;
  let last = list.length;

  while (first <= last) {
    let midpoint = Math.floor((first + last) / 2);
    if (list[midpoint] === target) {
      return midpoint;
    } else if (list[midpoint] < target) {
      first = midpoint + 1;
    } else {
      last = midpoint - 1;
    }
  }

  return -1;
};

const recursiveBinarySearch = (list, target, start, end) => {
  if (start > end) {
    return -1;
  }

  let midpoint = Math.floor((start + end) / 2);

  if (target < list[midpoint]) {
    return recursiveBinarySearch(list, target, start, midpoint - 1);
  } else if (target > list[midpoint]) {
    return recursiveBinarySearch(list, target, midpoint + 1, end);
  } else {
    return midpoint;
  }
};

let list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];

// console.log(iterariveBinarySearch(list, 5));
console.log(recursiveBinarySearch(list, 12, 0, list.length - 1));
