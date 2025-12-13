const fs = require("fs");
function main() {
  const input = fs.readFileSync(0, "utf-8").trimEnd().split("\n");

  const map = {
    "-": 0,
    "\\": 1,
    "(": 2,
    "@": 3,
    "?": 4,
    ">": 5,
    "&": 6,
    "%": 7,
    "/": -1,
  };

  for (let i = 0; i < input.length; i++) {
    const line = input[i].trim();
    if (line === "#") break;

    const letters = line.split("");
    let sum = 0;
    for (let j = 0; j < letters.length; j++) {
      const letter = letters[j];
      const power = letters.length - 1 - j;
      sum += map[letter] * Math.pow(8, power);
    }

    console.log(sum);
  }
}

main();
