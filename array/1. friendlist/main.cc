#include<iostream>
using namespace std;

int main(){

    int n;
    cin>>n;

    int a[1001];

    // set all 0
    for(int i=0; i<1001; i++){
        a[i]=0;
    }

    // increment friend list
    for(int i=0;i<n;i++){
        int p1, p2;
        cin>>p1>>p2;
        a[p1]++;
        a[p2]++;
    }

    // getting the max friend list 
    int max = 0;
    for(int i=0;i<1001;i++){
        if(a[i]>max){
            max = a[i];
        }
    }

    // printing i with max friend list in asc. ord
    for(int i=0; i<1001; i++){
        if(a[i]==max){
            cout<< i << endl;
        }
    }

    return 0;
}