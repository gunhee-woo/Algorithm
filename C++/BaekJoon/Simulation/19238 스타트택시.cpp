#include <bits/stdc++.h>
#define MAX 21
using namespace std;

int n, m, f, st, ed;
int a[MAX][MAX];
bool check[MAX][MAX];
vector<pair<int, int>> p; // 승객위치
vector<pair<int, int>> pd; // 승객 목적지 위치
int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

int search(int start, int end, int c, int dis, int val) {
	memset(check, false, sizeof(check));
	pair<int, int> ps = { n + 1, n + 1 };
	int k = -1;
	queue<pair<pair<int, int>, int>> q;
	int fuel = -1;
	bool arrive = false;
	q.push({ { start, end }, c });
	check[start][end] = true;
	while (!q.empty()) {
		int cx = q.front().first.first;
		int cy = q.front().first.second;
		int usage = q.front().second;
		q.pop();
		if (arrive) break;
		if (fuel != -1 && usage > fuel) break;
		for (int i = 0; i < 4; i++) {
			int nx = cx + ax[i];
			int ny = cy + ay[i];
			if (nx < 1 || ny < 1 || nx > n || ny > n || a[nx][ny] == 1 || check[nx][ny] == true) continue;
			if (dis == 0) { // 승객을 찾을 때
				if (a[nx][ny] > 1) {
					if (ps.first > nx) { // 승객의 행이 더 작은 것을 선택
						ps = { nx, ny };
						k = a[ps.first][ps.second];
					}
					else if (ps.first == nx) { // 승객의 행이 같은 것 중 열이 더 작은 것을 선택
						if (ps.second > ny) {
							ps = { nx, ny };
							k = a[ps.first][ps.second];
						}
					}
					fuel = usage;
				}
			}
			else { // 승객의 목적지로 찾아갈 때
				if (pd[val - 2] == make_pair(nx, ny)) {
					fuel = usage;
					arrive = true;
					break;
				}
			}
			q.push({ {nx, ny}, usage + 1 });
			check[nx][ny] = true;
		}
	}
	if (f < fuel + 1) {
		return -1;
	}
	if (dis == 0) {
		f -= fuel + 1; // 승객을 찾을 때
	}
	else {
		f += fuel + 1; // 목적지를 찾을 때
		return val;
	}
	return k;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int answer = -1;
	cin >> n >> m >> f;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> a[i][j];
		}
	}
	cin >> st >> ed;
	for (int i = 0; i < m; i++) {
		int px, py, dx, dy;
		cin >> px >> py >> dx >> dy;
		p.push_back({ px, py });
		pd.push_back({ dx, dy });
		a[px][py] = i + 2; // 승객 위치
		//a[dx][dy] = -(i + 2); // 승객 목적지 위치
	}
	while (m--) {
		int val = search(st, ed, 0, 0, 0); // 승객 찾을 때
		if (val == -1){
			cout << -1;
			return 0;
		}
		st = p[val - 2].first;
		ed = p[val - 2].second;
		a[st][ed] = 0;

		val = search(st, ed, 0, 1, val); // 승객의 목적지로 갈 때
		if (val == -1) {
			cout << -1;
			return 0;
		}
		st = pd[val - 2].first;
		ed = pd[val - 2].second;
	}
	cout << f;
	return 0;
}