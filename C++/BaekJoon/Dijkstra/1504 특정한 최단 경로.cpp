// 방향성이 없는 그래프일 경우, 특정한 두점을 항상 지나쳐야하는 조건
// 네비게이션 경유지 추가할 때 알고리즘 v1, v2는 경유지임
#include <bits/stdc++.h>

#define E_MAX 200001
#define N_MAX 801
#define INF 987654321

using namespace std;

int n, e;
vector<pair<int, int>> v[E_MAX];
int d[N_MAX];
int v1, v2;

void dijkstra(int start) {
	d[start] = 0; // 자기자신
	priority_queue<pair<int, int>> pq; // first 거리 second 도착정점
	pq.push(make_pair(0, start));
	while (!pq.empty()) {
		int cur = pq.top().second;
		int dist = -pq.top().first;
		pq.pop();
		if (d[cur] < dist) continue;

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i].first;
			int nextdist = dist + v[cur][i].second;
			if (nextdist < d[next]) {
				d[next] = nextdist;
				pq.push(make_pair(-nextdist, next));
			}
		}
	}
}

void input() {
	cin >> n >> e;
	for (int i = 0; i < e; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back(make_pair(b, c));
		v[b].push_back(make_pair(a, c)); // 양방향 그래프 이므로
	}
	cin >> v1 >> v2;
}

void init() {
	for (int i = 1; i <= n; i++) {
		d[i] = INF;
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	input();
	init();
	dijkstra(1); // 시작점 1부터 각 정점의 최단거리 계산
	
	bool flag1, flag2; // 정점까지 갈 수 있는지 판단
	flag1 = flag2 = true;

	// route1 => 시작점으로부터 v1을 먼저 지나고 v2를 거쳐 목적지로 가는 루트
	// route2 => 시작점으로부터 v2를 먼저 지나고 v1을 거쳐 목적지로 가는 루트

	int route1 = d[v1]; // 시작점 1부터 v1까지의 최단거리
	int route2 = d[v2]; // 시작점 1부터 v2까지의 최단거리
	if (route1 == INF)
		flag1 = false;
	if (route2 == INF)
		flag2 = false;
	
	init(); // 최단거리 초기화
	dijkstra(v1); // 시작점 v1으로부터 v2까지의 최단거리 계산을 위함 => 양방향그래프이므로 시작점 v2는 계산X
	if (flag1 == true)
		route1 = route1 + d[v2];
	if (flag2 == true)
		route2 = route2 + d[v2];

	init();
	dijkstra(v2); // v2부터 목적지(N)까지의 최단거리 계산
	if (flag1 == true)
		route1 = route1 + d[n];

	init();
	dijkstra(v1); // v1부터 목적지(N)까지의 최단거리 계산
	if (flag2 == true)
		route2 = route2 + d[n];

	if (flag1 == false && flag2 == false)
		cout << -1;
	else {
		if (min(route1, route2) == INF)
			cout << -1;
		else
			cout << min(route1, route2);
	}
}