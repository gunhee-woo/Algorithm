#include <bits/stdc++.h>
using namespace std;

int n;
queue<int> q;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		string order;
		cin >> order;
		if (order == "push") {
			int x;
			cin >> x;
			q.push(x);
		}
		else if (order == "front") {
			if (q.empty()) cout << -1 << "\n";
			else cout << q.front() << "\n";
		}
		else if (order == "back") {
			if (q.empty()) cout << -1 << "\n";
			else cout << q.back() << "\n";
		}
		else if (order == "size") {
			cout << q.size() << "\n";
		}
		else if (order == "empty") {
			if (q.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (order == "pop") {
			if (q.empty()) cout << -1 << "\n";
			else {
				cout << q.front() << "\n";
				q.pop();
			}
		}
	}
}