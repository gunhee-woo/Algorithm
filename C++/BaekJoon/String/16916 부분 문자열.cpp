#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("Text.txt", "r", stdin);
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> a >> b;
    if (strstr((char*)a.c_str(), (char*)b.c_str()) == NULL)
    	cout << 0;
    else
    	cout << 1;
}