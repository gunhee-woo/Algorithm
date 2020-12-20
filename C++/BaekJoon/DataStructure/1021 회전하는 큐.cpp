#include <bits/stdc++.h>
using namespace std;

int n, m;
deque<int> dq;

int left(int k, deque<int> &q) {
	int count = 0;
	while (q.front() != k) {
		int f = q.front();
		q.pop_front();
		q.push_back(f);
		count++;
	}
	q.pop_front();
	return count;
}

int right(int k, deque<int> &q) {
	int count = 0;
	while (q.front() != k) {
		int f = q.back();
		q.pop_back();
		q.push_front(f);
		count++;
	}
	q.pop_front();
	return count;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	int result = 0;
	for (int i = 1; i <= n; i++) 
		dq.push_back(i);
	for (int i = 0; i < m; i++) {
		int k;
		cin >> k;
		if (dq.front() == k) {
			dq.pop_front(); 
			continue;
		}

		deque<int> ldq = dq;
		deque<int> rdq = dq;
		int l = left(k, ldq);
		int r = right(k, rdq);
		if (l < r) {
			result += l;
			dq = ldq;
		}
		else {
			result += r;
			dq = rdq;
		}
	}
	cout << result;
}