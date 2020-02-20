#include <iostream>
using namespace std;

/*
QUESTION

ginven n,d 
print a & b such that a*d +b = n
*/

int main(){

 int n;
 cin>>n;
 int d;
 cin>>d;

 int a = n/d;
 int b = n%d;

 if(b != 0){
    cout<<a<<" "<<b;
 }else{
    cout<<a;
 }

}