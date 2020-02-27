#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    
    int even =0, odd=0;
    for(int i=0;i<n;i++){
        int temp;
        cin >> temp;
        if(temp%2==0 && i%2==0){
            even+=temp;
        }else if(temp%2!=0 && i%2!=0){
            odd+=temp;
        }
    }
    cout<<even<<" "<<odd;
	return 0;
}
