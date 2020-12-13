#include <bits/stdc++.h>
using namespace std;
int n, k;
string r;
int main() {
	cin >> n >> k >> r;
	deque<char> dq;
	for (int i = 0; i < r.size(); i++) {
		while (k && !dq.empty() && dq.back() < r[i]) {
			dq.pop_back();
			k--;
		}
		dq.push_back(r[i]);
	}
	for (int i = 0; i < dq.size() - k; i++) {
		cout << dq[i];
	}
	return 0;
}