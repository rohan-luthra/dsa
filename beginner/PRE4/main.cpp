#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin >> n;
    
    int a[n];
    for(int i=0;i<n;i++)
        cin >> a[i];
    
    for(int i=0; i<n/2; i++){
        int v = a[i]+a[n-i-1];
        cout << (int )v/10 << " " << v%10 << endl;
    }
    
	return 0;
}
