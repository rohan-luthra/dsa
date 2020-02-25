#include<bits/stdc++.h>
using namespace std;
int main() {

	// Write your code here
    int n;
    cin >> n;
    
    int a[n];
    for(int i=0; i<n; i++){
        cin >> a[i];
    }
    int max = 0;
    int minIndex = 0;
    for(int i=1; i<n ;i++){
        if(a[i] < a[minIndex]) minIndex = i;
        if( (a[i] - a[minIndex]) > max ) max = a[i] - a[minIndex];
    }
    cout << max;
}