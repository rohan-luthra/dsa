#include<iostream>
using namespace std;

/*

Given n, and n numbers. Find out the whose are divisible by 3.
Print count and their index

*/


int main(){

    int n;
    cin>>n;
    int a[n];
    
    for(int i=0; i<n;i++){
        cin>>a[i];
    }

    int count  = 0;
    for(int i=0;i<n;i++){
        if(a[i]%3==0){
            count++;
            cout<< i << endl;
        }
    }
    cout<< count << endl;

    return 0;
}