#include<bits/stdc++.h>
using namespace std;
int main() {

	// Write your code here
    int n;
    cin >> n;
    
    int tg;
    cin >> tg;
    
    int a[n];
    for(int i=0; i<n; i++)
        cin >> a[i];
    
    int sum = a[0];
    int start = 0, end = 0;
    bool flag = false;
    while( start<n && end<n ){
        // cout << start << " " << end << " " << sum << endl;
        if(sum == tg){
            flag = true;
            cout << "true" << endl;
            for(int i=start; i<=end; i++)
                cout << a[i] << " ";
            break;
        }else if ( sum < tg ){
            end ++;
            sum += a[end];
        }else{
            sum -= a[start];
            start++;
        }
    }
    
    if(!flag) cout << "false"; 
}