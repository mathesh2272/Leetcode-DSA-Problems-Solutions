/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    let n = s1.length;
    let m = s2.length;
    if(n > m){
        return false;
    }
    let check = (arr1, arr2) => {
        for(let i = 0; i < 26; i++) {
            if(arr1[i] !== arr2[i]) {
                return false;
            }
        }
        return true;
    };
    let a = new Array(26).fill(0);
    let b = new Array(26).fill(0);
    for(let i = 0 ; i < n ; i++){
        a[s1.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        b[s2.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }
    if(check(a, b)){
        return true;
    }
    for(let i = 0 ; i < m - n ; i++){
        b[s2.charCodeAt(n + i) - 'a'.charCodeAt(0)]++;
        b[s2.charCodeAt(i) - 'a'.charCodeAt(0)]--;
        if(check(a, b)){
            return true;
        }
    }
    return false;
};