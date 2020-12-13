// 전형적인 bfs 문제

#include <bits/stdc++.h>
#define MAX 301
using namespace std;

int n, m;
int a[MAX][MAX];
int cp[MAX][MAX];
bool check[MAX][MAX];
int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

int bfs() {
	queue<pair<int, int>> q;
	int answer = 0; // 빙산 덩어리 개수
	for (int i = 1; i < n - 1; i++) {
		for (int j = 1; j < m - 1; j++) {
			if (cp[i][j] != 0 && check[i][j] == false) {
				answer++;	
				q.push(make_pair(i, j));
				check[i][j] = true;
				while (!q.empty()) {
					int curx = q.front().first;
					int cury = q.front().second;
					q.pop();
					int count = 0;
					for (int i = 0; i < 4; i++) {
						int nx = curx + ax[i];
						int ny = cury + ay[i];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (cp[nx][ny] == 0) {
							count++;
						}
						else {
							if (check[nx][ny] == false) {
								check[nx][ny] = true;
								q.push(make_pair(nx, ny));
							}
						}
					}
					if (cp[curx][cury] - count < 0) {
						a[curx][cury] = 0;
					}
					else {
						a[curx][cury] -= count;
					}
				}
			}
			
		}
	}
	return answer;
}

void init() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			check[i][j] = false;
			cp[i][j] = a[i][j];
		}
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}

	int result = 0;
	while (1) {
		init();
		int k = bfs();
		if (k == 0) {
			cout << 0;
			break;
		}
		if (k >= 2) {
			cout << result;
			break;
		}
		result++;
	}
}