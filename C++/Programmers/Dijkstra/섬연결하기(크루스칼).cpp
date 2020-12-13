// 크루스칼 알고리즘을 사용하여 풀이
// 크루스칼 알고리즘 : 가장 적은 비용으로 모든 노드를 연결
// 최소 비용 신장 트리를 만들기 위한 대표적인 알고리즘
// 여러개의 도시를 도로로 연결할 때 비용을 최소한으로 하고자 할 때 사용
// 목표는 최대한 적은 비용으로 노드를 연결만 시키면 됨
// 노드의 개수 만큼의 노드의 부모를 담는 배열이 필요 => 처음에 각 노드로 초기화
// 주어진 모든 간선 정보를 오름차순으로 정렬
// 정보를 바탕으로 그래프 연결 => 최소 비용 신장 트리가 만들어짐
// 포함시키기 전에는 사이클을 확인 => 사이클을 형성하는 경우 간선을 포함하지 않음

#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int n;
vector<vector<int>> a(5, vector<int>(3, 0));

// 부모노드를 가지고 옴
int getParent(int x) {
	if (v[x] == x) return x;
	return v[x] = getParent(v[x]);
}

// 같은 부모를 가지는지 확인
int find(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a == b) return 1; // 사이클이 존재한다.
	else return 0;
}

// 부모 노드를 병합
void unionParent(int a, int b) { 
	a = getParent(a);
	b = getParent(b);
	if (a < b) v[b] = a;
	else v[a] = b;
}

bool compare(vector<int> a, vector<int> b) {
	return a[2] < b[2];
}

int solution(int n, vector<vector<int>> costs) {
	int answer = 0;

	// 간선의 비용으로 오름차순 정렬
	sort(costs.begin(), costs.end(), compare);

	// 각 정점이 포함된 그래프가 어디인지 저장, 각 노드의 부모노드를 저장
	for (int i = 0; i < n; i++) {
		v.push_back(i);
	}
	for (int i = 0; i < costs.size(); i++) {
		// 동일한 부모를 가지지 않는 경우 => 즉, 사이클이 발생하지 않을때 선택
		if (!find(costs[i][0], costs[i][1])) {
			answer += costs[i][2];
			unionParent(costs[i][0], costs[i][1]);
		}
	}
	return answer;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> a[i][j];
		}
	}
	cout << solution(n, a);
}