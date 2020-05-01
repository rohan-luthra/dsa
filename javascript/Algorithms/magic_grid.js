process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input.trim().split("\n"));
});

function processData(input) {
    let t = parseInt(input[0]);
    let prev = 1;
    for(let i = 0; i< t; i++){
        const nm = input[prev].split(" ");
        const n = parseInt(nm[0]);
        const m = parseInt(nm[1]);
        // console.log(n,m, input);
        let arr = new Array(n);
        for( let j=prev+1; j<(n+prev+1); j++ ){
            const str = String(input[j]).split(" ");
            arr[j-prev-1] = [];
            str.forEach(s=>arr[j-prev-1].push(parseInt(s)));
        }
        // console.log(arr);
        console.log(magicGrid_dp_iter(arr, n, m))
        prev+=n+1;
    }
} 

/**
 * MAGIC GRIP
 * Finding minmum healt required to reach (n-1, m-1) from (0,0)
 * Solution - 
 * 1. at any (i,j) --> two path to go right and down
 * 2. at any (i,j) --> health dp[][] - arr[][] 
 *                      if this is less than 0 then = 1 (sice health cant be 0) 
 * 
 * 3. Base cases - dp[n-2][m-1] = dp[n-1][m-2] = 1 Since they only need min stamina to reach (n-1, m-1) which is 1
 * 4. Filling up array bottom up apprach uptil (0,0)
 * 5, return dp[0][0]
 */

function magicGrid_dp_iter(arr, n, m){

    let dp = new Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = new Array(m).fill(0);
    }

    dp[n-1][m-1] = 1;
    for(let i=n-2; i>=0; i--){
        dp[i][m-1] = dp[i+1][m-1] - arr[i+1][m-1];
        if(dp[i][m-1]<1) dp[i][m-1]=1;
    }
    for(let i=m-2; i>=0; i--){
        dp[n-1][i] = dp[n-1][i+1] - arr[n-1][i+1];
        if(dp[n-1][i]<1) dp[n-1][i]=1;
    }

    // console.log(dp)
    for(let i=n-2; i>=0; i--){
        for(let j=m-2; j>=0; j--){
            let opt1 = dp[i+1][j] - arr[i+1][j];
            if(opt1 < 1) opt1 = 1;
            let opt2 = dp[i][j+1] - arr[i][j+1];
            if(opt2 < 1) opt2 = 1;
            dp[i][j] = Math.min(opt1, opt2);
        }
    }

    // console.log(dp)
    return dp[0][0];

}

