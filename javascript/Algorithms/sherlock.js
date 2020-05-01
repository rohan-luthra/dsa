function processData(input) {
    let str = String(input).trim().split("");
    console.log(isValid(str))
} 

function isValid(str){

    let arr = Array(26).fill(0);
    // a-z
    // getting count for each character
    // storing it in an array - arr
    str.forEach(c => {
        console.log(c);
        arr[ c.charCodeAt(0) - 97 ]++;
    });

    // console.log(arr)


    // maximum count in the array
    let max = -1;

    // flag to check if anomaly has occured before of not
    let encounter = 0;

    for(let i=0; i<26;i++){
        // skip if the character doesnt exists
        if(arr[i]==0) continue;
        // setting max, if its not initialized
        // and skip this iteration
        if(max == -1) { max = arr[i]; continue; }
        // skip if count is equal to max
        if(max == arr[i]) continue;
        // checing anomaly 
        // if 1 then return "NO"
        if(encounter == 1) return "NO";
        // anomaly detected
        // check if count is 1 OR count is 1 greater then the max (so that we can remove it, and set encounter to 1)
        if(arr[i] ==1 || arr[i] == max+1) encounter++;
        // cannot remove this anomaly, return "NO"
        else return "NO";

    }
    return "YES";

}


process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input.split("\n"));
});
