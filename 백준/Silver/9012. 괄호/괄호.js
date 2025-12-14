const fs = require("fs");
function main() {
  let input = fs.readFileSync(0, "utf-8").trim().split("\n");

  const n = input[0];
  const open = "(";
  const close = ")";
  for (let idx = 1; idx <= n; idx++) {
    let line = input[idx];
    const stack = [];
    let answer = "YES";
    let str = line.split("");
    for (let s of str) {
      const top = stack[stack.length - 1];

      if (s === open) {
        stack.push(s);
        continue;
      }

      if (s === close) {
        if (top === open) {
          stack.pop();
          continue;
        }

        stack.push(s);
      }
    }

    if (stack.length === 0) answer = "YES";
    else answer = "NO";
    console.log(answer);
  }
}

main();
