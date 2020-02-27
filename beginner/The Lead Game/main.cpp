#include<iostream>
using namespace std;

int main(){

    int n;
    int cs1 = 0, cs2 = 0;
    int max_lead = 0, max_lead_player = 1;

    cin>>n;
    while(n--){
        int s1, s2;
        cin>>s1>>s2;

        cs1+=s1;
        cs2+=s2;

        int lead = cs1 - cs2;
        if(lead<0){
            lead = lead * -1;
            if(lead > max_lead){
                max_lead = lead;
                max_lead_player = 2;
            }
        }else{
            if(lead > max_lead){
                max_lead = lead;
                max_lead_player = 1;
            }
        }
        
    }

    cout << max_lead_player<< " "<< max_lead;
    return 0;
}
