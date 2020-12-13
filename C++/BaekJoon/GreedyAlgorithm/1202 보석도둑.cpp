#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<pair<int, int>> a;
vector<int> b;

int main() {
	//freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int m, v;
		cin >> m >> v;
		a.push_back(make_pair(m, v));
	}
	long answer = 0; // int 자료형의 최대 범위를 벗어나므로 long을 사용해야 함
	for (int i = 0; i < k; i++) {
		int c;
		cin >> c;
		b.push_back(c);
	}

	sort(a.begin(), a.end());
	sort(b.begin(), b.end());

	priority_queue<int> pq;

	int j = 0;
	for (int i = 0; i < k; i++) {
		while (j < n && b[i] >= a[j].first) {
			pq.push(a[j].second);
			j++;
		}

		if (!pq.empty()) {
			answer += pq.top();
			pq.pop();
		}
	}

	cout << answer;
}