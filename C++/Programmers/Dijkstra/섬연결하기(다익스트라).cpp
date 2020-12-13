// 다익스트라 알고리즘을 사용하여 최소비용을 구함
// 하지만 전형적인 크루스칼 알고리즘 문제

#include <bits/stdc++.h>
#define INF 987654321
#define MAX 101
using namespace std;

typedef struct Node {
	int end;
	int cost;
};

int n;
vector<vector<int>> v(5, vector<int>(3, 0));
bool check[MAX];
long d[MAX];
vector<Node> a[MAX];

int solution(int n, vector<vector<int>> costs) {
	int start = 0, mc = INF;
	for (int i = 0; i < costs.size(); i++) { // 인접리스트 생성 
		a[costs[i][0]].push_back(Node{ costs[i][1], costs[i][2] });
		a[costs[i][1]].push_back(Node{ costs[i][0], costs[i][2] }); // 방향성이 없으므로 양방향으로 저장
		if (mc > costs[i][2]) {
			mc = costs[i][2];
			start = costs[i][0];
		}
	}
	memset(check, false, sizeof(check));
	for (int i = 0; i < n; i++) {
		d[i] = INF;
	}
	d[start] = 0;
	priority_queue<pair<int, int>> pq; // first 비용 => 정렬을 위해, second 도착점
	pq.push(make_pair(mc, start));
	while (!pq.empty()) {
		int cur = pq.top().second;
		int cost = -pq.top().first;
		pq.pop();
		if (check[cur]) continue;
		check[cur] = true;	
		for (int j = 0; j < a[cur].size(); j++) {
			int next = a[cur][j].end;
			int nextcost = a[cur][j].cost;
			if (!check[next] && nextcost < d[next]) {
				d[next] = nextcost;
				pq.push(make_pair(-nextcost, next));
			}
		}
	}
	int sum = 0;
	for (int j = 0; j < n; j++) {
		cout << d[j] << endl;
		sum += d[j];
	}
	return sum;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> v[i][j];
		}
	}
	cout << solution(n, v);
}