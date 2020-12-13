// 조금 변형된 bfs문제

#include <bits/stdc++.h>
#define MAX 101
using namespace std;

int n, p1, p2, m;
vector<int> v[MAX];
bool check[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> p1 >> p2 >> m;
	for (int i = 0; i < m; i++) { // 인접리스트 생성
		int x, y;
		cin >> x >> y;
		v[x].push_back(y);
		v[y].push_back(x);
	}

	queue<pair<int, int>> q; // first 사람, second 시작점과의 촌수 관계
	q.push(make_pair(p1, 0));
	check[p1] = true;
	bool arrive = false;
	while (!q.empty()) {
		int cur = q.front().first;
		int count = q.front().second;
		q.pop();
		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i];
			if (check[next] == false) {
				if (next == p2) {
					arrive = true;
					count++;
					break;
				}
				check[next] = true;
				q.push(make_pair(next, count + 1));
			}
		}
		if (arrive) {
			cout << count;
			return 0;
		}
	}
	cout << -1;
	return 0;
}