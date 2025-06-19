function solution(s) {
    let zeroCount = 0;
    let transCount = 0;

    while (s !== "1") {
        const str = s.split("");

        zeroCount += str.filter((c) => c === "0").length;

        s = str.filter((c) => c === "1").length.toString(2);
        transCount++;
    }

    return [transCount,zeroCount];
}