#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    while(T--) {
        string str, answer;
        cin >> str;
        int cnt = 0;
        do {
            answer = str;
            if(++cnt == 2) break;
        } while(next_permutation(str.begin(), str.end()));
        cout << answer << "\n";
    }
}