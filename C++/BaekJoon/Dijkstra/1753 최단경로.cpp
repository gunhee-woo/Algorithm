// 다익스트라 알고리즘 => 최단경로
#include <bits/stdc++.h>

#define INF 987654321
#define MAX 20001

using namespace std;
int v, e, start;
vector<pair<int, int>> a[MAX];
int d[MAX]; // 최단거리(비용)*/

// *** priority_queue에서 pair를 사용하지 않을 경우 ***
// 구조체를 선언하여 사용해야 함
typedef struct NODE {
	int end;
	int value;
};

void dijkstra() {
	d[start] = 0; // start = 1
	// *** 만약 큐에서 pair를 사용할 경우 항상 가중치를 first에 위치할 것!!! ****
	priority_queue<pair<int, int>> pq; // 가까운순서대로 처리 => O(ElogV)의 시간복잡도를 가짐
	pq.push(make_pair(0, start)); //	 second(도착정점)
	while (!pq.empty()) {
		int cur = pq.top().second; // 정점	
		int dist = -pq.top().first; // 정점과의 거리, 짧은것이 먼저 오도록 함 => 우선순위큐가 값이 높은것부터 내보내기 때문
		pq.pop();
		if (d[cur] < dist) continue; // 최단거리가 아닌 경우 스킵
		for (int i = 0; i < a[cur].size(); i++) {
			int next = a[cur][i].first; // 다음 정점, 선택된 노드의 인접 노드
			int nextdist = dist + a[cur][i].second; // 다음 정점과의 거리, 인접노드를 거쳐서 가는 비용
			if (nextdist < d[next]) { // 기존 거리 보다 더 가까우면 교체
				d[next] = nextdist;
				pq.push(make_pair(-nextdist, next));
			}
		}
	}
}

void init() {
	cin >> v >> e >> start;
	for (int i = 1; i <= v; i++) {
		d[i] = INF; // INF초기화 => 문제에서 가중치는 10이하의 자연수이므로
	}
	for (int i = 0; i < e; i++) {
		int u, vv, w;
		cin >> u >> vv >> w;
		a[u].push_back(make_pair(vv, w));
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	init();
	dijkstra();
	
	// 값 출력
	for (int i = 1; i <= v; i++) {
		if (d[i] == INF)
			cout << "INF" << "\n";
		else
			cout << d[i] << "\n";
	}
	return 0;
}