/**
 * 
 * QUESTION - 
 * 
 * Given an 2d array  n*m
 * find the minimum cost required to react (n-1,m-1) from (0,0)
 * only direction one can move is - right, down, down-right(vertical)
 * 
 * 
 * 
 */


process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input.split("\n"));
});

function processData(input) {
    let n = parseInt(input[0]);
    let m = parseInt(input[1]);
    let str = input[2].split(" ");
    let arr = new Array(n)
    for (let i = 0 ; i < n ; i++) {
        arr[i] = [];
        for(let j = 0; j < m; j++){
            arr[i].push(parseInt(str[i*n + j]));
        }
    }

    console.log(minCostDp_iter(arr, n, m));
} 

/**
 * MINIMUM COST 
 * finding minimum cost from (0,0) to (n-1,m-1)
 * This is the dynamic programming approach
 * Soultion - at any instnce (i,j) represent the minimum cost to reach (n-1, m-1)
 *            So the lowest cost at (i,j)= MINIMUM of all possible routes ie.
 *                 { (i+1, j) , (i,j+1), (i+1, j+1)}  + current_cost  
 * 1. create a 2-d array dp[n][m]
 * 2. fill basecases - i.e last colum and last row
 * 3. keep filling the array bottom of manner until (0,0)
 * 4. return dp[0][0]
 */

function minCostDp_iter(arr, n, m){

    let dp = new Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = new Array(m).fill(0);
    }

    // console.log(dp);
    dp[n-1][m-1] = arr[n-1][m-1];
    for(let i=n-2; i>=0; i--){
        dp[i][m-1] = arr[i][m-1] + dp[i+1][m-1];
    }
    for(let j=m-2; j>=0; j--){
        dp[n-1][j] = arr[n-1][j] + dp[n-1][j+1];
    }

    for(let i=n-2; i>=0; i--){
        for(let j=m-2; j>=0; j--){
            console.log(arr[i][j],i, j);
            dp[i][j] = arr[i][j] + Math.min( dp[i+1][j], dp[i][j+1], dp[i+1][j+1] ); 
        }
    }

    // console.log(dp)
    return dp[0][0];

}

