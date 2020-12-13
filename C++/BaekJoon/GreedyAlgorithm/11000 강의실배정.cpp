#include <bits/stdc++.h>
#define MAX 200002
using namespace std;

typedef struct p {
	int start;
	int end;
};

int n;
p a[MAX];

bool compare(p x, p y) {
	if (x.start == y.start) {
		return x.end < y.end;
	}
	else {
		return x.start < y.start;
	}
}

int main() {
	//freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i].start >> a[i].end;
	}
	sort(a, a + n, compare);

	int answer = 0;
	priority_queue<int> q;
	for (int i = 0; i < n; i++) {
		if (q.empty()) {
			q.push(-a[i].end);
		}
		else {
			int k = -q.top();
			if (a[i].start >= k) {
				q.pop();
			}
			q.push(-a[i].end);
		}
	}
	cout << q.size();
}