#include <bits/stdc++.h>

#define MAX 1001
#define BUSMAX 100001
#define INF 987654321

using namespace std;

typedef struct Node { // 버스 도착 도시, 비용 정보
	int end;
	int cost;
};

int n, m;
int d[MAX]; // 최소비용
vector<Node> bus[BUSMAX]; // 버스정보
int start, dest;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		bus[a].push_back(Node{ b, c });
	}

	for (int i = 1; i <= n; i++) {
		d[i] = INF;
	}

	cin >> start >> dest;

	d[start] = 0; // 자기자신한테 가는 비용
	priority_queue<pair<int, int>> pq;
	pq.push(make_pair(0, start));
	while (!pq.empty()) {
		int cur = pq.top().second;
		int fee = -pq.top().first;
		pq.pop();
		if (d[cur] < fee) continue; // 저장된 최소 비용보다 비쌀때
		for (int i = 0; i < bus[cur].size(); i++) {
			int next = bus[cur][i].end;
			int nextfee = fee + bus[cur][i].cost;
			if (nextfee < d[next]) {
				d[next] = nextfee;
				pq.push(make_pair(-nextfee, next));
			}
		}
	}

	cout << d[dest];

	return 0;
}