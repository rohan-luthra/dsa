function processData(input) {
    let t = parseInt(input[0]);
    for (let i = 0 ; i < t ; ++i) {
    	let values = input[i * 2 + 2].trim().split(" ")
    		.map(function(str) { return parseInt(str); });
    	console.log(InversionCount(values));
    	//console.log(values)
    }
} 

/**
 * 
 * @param {*} values 
 * Basic modification of MERGE SORT
 * 1. split the array into 2 parts
 * 2. Sort both individually - and count no of inversion counts - sum1 and sum2
 * 3. merge both the arrays and count no of inversion counts - sum3
 * 4. total inversion counts = sum1 + sum2+ sum3
 */


function InversionCount(values) {
	return InversionSort(0, values.length - 1);

	function InversionSort(start, end) {
		
		let res = 0;
		if(start<end){
			let middle = Math.floor((start + end) / 2);
			res += InversionSort(start, middle);
			res += InversionSort(middle + 1, end);
			res += merge(values, start, middle+1, end);
		}
		return res;
	}

	function merge(values, start, middle, end) {
		let t = [],
			k = 0;
			i = start,
			j = middle,
			count = 0;

		while(i < middle && j <= end) {
			if (values[i] <= values[j]) {
				t[k++] = values[i++];
			} else {
				count += (middle-i);
				t[k++] = values[j++];
			}
		}
		while(i < middle) t[k++] = values[i++];
		while(j <= end) t[k++] = values[j++];


		for (i = middle, k=0 ; i < end ; i++, k++) {
			values[i] = t[k];
		}

		return count;
	}
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
