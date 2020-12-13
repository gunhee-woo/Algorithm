// bfs문제인데 인접리스트를 사용하지 않고 큐에 현재값에 더하거나 뺀 값을 넣어 값을 찾는 방식

#include <bits/stdc++.h>
#define MAX 1000001
using namespace std;

int f, s, g, u, d;
bool check[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> f >> s >> g >> u >> d;

	queue<pair<int, int>> q; // first 현재 층 second 버튼을 누른 수
	check[s] = true;
	q.push(make_pair(s, 0));
	while (!q.empty()) {
		int cur = q.front().first;
		int count = q.front().second;
		q.pop();
		if (cur == g) {
			cout << count;
			return 0;
		}
		else {
			int nextup = cur + u;
			int nextdown = cur - d;
			if (nextup <= f && check[nextup] == false) {
				q.push(make_pair(nextup, count + 1));
				check[nextup] = true;
			}
			if (nextdown >= 1 && check[nextdown] == false) {
				q.push(make_pair(nextdown, count + 1));
				check[nextdown] = true;
			}

		}
	}
	cout << "use the stairs";
	return 0;
}