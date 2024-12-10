/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let num = x ^ y
    let cnt = 0
    while (num) {
        cnt++;
        num = num & (num - 1)
    }
    return cnt
};