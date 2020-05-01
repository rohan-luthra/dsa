// dynamic programming
process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});


/**
 * Dynamic Programming problem
 * In each case we either include the coin or we dont
 * then add both
 * Base case : 1. N<=0 ---> res=1
 *             2. n<=0 ---> res=0
 * we will take up a dp[][] array
 * at any value dp[i][j] -> represents the total number of ways i can be made with arr[0...j] coins
 */
function processData(input){

    let str = String(input).trim().split('\n');;
    let n = parseInt(str[0]);
    let arr = str[1].split(" ");
    let N = parseInt(str[2]);

    console.log(coinChange(n, arr, N));
}

function coinChange(n, arr, N){


    // init a dp 2-d array
    // N+1 * n
    // row represents the total value
    // column represents the current coin 

    let dp = new Array(N+1);
    for (let i = 0; i <= N; i++) {
        dp[i] = new Array(n).fill(0);
      }

    // init base case
    dp[0]=Array(n).fill(1);

    for(let i=1; i<=N; i++){
        for(let j=0; j<n; j++){
            // check if current value <= current coin
            // if yes we can include that coin and reduce value
            // return 0
            let x = ( i - arr[j]>=0 )? dp[i - arr[j]][j] : 0;

            // not including the coin
            // return same value but diffent coin if exists
            let y = ( j>0 ) ? dp[i][j-1]: 0;
            dp[i][j] = x+y;
        }
    }
    // console.log(dp)
    return dp[N][n-1];
}