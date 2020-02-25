#include<bits/stdc++.h>
using namespace std;
int main() {

	// Write your code here
    int n;
    cin >> n;
    
    int tg;
    cin >> tg;
    
    int a[n];
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    int ansI = -1, ansJ = -1;
    bool answer = false;
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int sum = 0;
            for(int k=i;k<=j;k++){
                sum+=a[k];
            }
            // cout << i << " " << j << " " << sum <<  endl;
            if(sum == tg){
                ansI = i;
                ansJ = j;
                answer = true;
                break;
            }
        }
        if(ansI != -1 && ansJ !=-1) break; 
    }
    
    if(answer) {
        cout << "true" << endl;
        for(int i=ansI;i<=ansJ;i++){
            cout<< a[i]<< " ";
        }
    }
    else cout << "false";
}