
#include <bits/stdc++.h>
#define MAX 10001
using namespace std;

int n;
vector<pair<int, int>> v[MAX];
bool check[MAX];
int answer;
int d[MAX]; // 시작점으로 부터 인덱스 노드까지의 거리

int end_point;
int maxlen;

void dfs(int u) {
	if (check[u]) return;
	check[u] = true;
	if (maxlen < d[u]) {
		maxlen = d[u];
		end_point = u;
	}
	for (int i = 0; i < v[u].size(); i++) {
		if (check[v[u][i].first]) continue;
		d[v[u][i].first] = d[u] + v[u][i].second;
		dfs(v[u][i].first);
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ b, c });
		v[b].push_back({ a, c });
	}
	dfs(1);
	maxlen = 0;
	memset(d, 0, sizeof(d));
	memset(check, false, sizeof(check));
	dfs(end_point);
	cout << maxlen;
}