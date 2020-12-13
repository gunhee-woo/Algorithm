ctrl + k + c 주석처리
ctrl + k + u 주석해제

#include <bits/stdc++.h>
using namespace std;

int n, m;
int mp[9][9]; // 원본 지도
int cp[9][9]; // 지도 복사
//bool check[9][9];
queue<pair<int, int>> q; // 원본 큐
queue<pair<int, int>> cpq; // 복사 큐

vector<pair<int, int>> wall;

int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

int answer = -1;

void init() {
	//memset(check, false, sizeof(check));
	cpq = q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cp[i][j] = mp[i][j];
		}
	}
	for (int k = 0; k < wall.size(); k++) {
		cp[wall[k].first][wall[k].second] = 3;
	}
}

void search() {
	int count = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (cp[i][j] == 0) {
				count++;
			}
		}
	}
	answer = max(answer, count);
}

void birus() {
	while (!cpq.empty()) {
		int cx = cpq.front().first;
		int cy = cpq.front().second;
		cpq.pop();
		for (int i = 0; i < 4; i++) {
			int nx = cx + ax[i];
			int ny = cy + ay[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			/*if (check[nx][ny] == false && cp[nx][ny] == 0) {
				check[nx][ny] = true;
				cp[nx][ny] = 2;
				cpq.push(make_pair(nx, ny));
			}*/
			if (cp[nx][ny] == 0) {
				cp[nx][ny] = 2;
				cpq.push(make_pair(nx, ny));
			}
		}
	}
	search();
}

void dfs2(int i, int j, int w) {
	if (w == 3) {

	}

}

void dfs(int x, int y, int w) {
	for (int i = x; i < n; i++) {
		for (int j = y; j < m; j++) {
			/*if (w == 3) { // 이미 벽을 다 세웠을 경우
				// cp에 벽에 세개 세워짐
				// 바이러스 퍼지기 시작
			}
			else {
				if (cp[i][j] == 0) {
					cp[i][j] = 3; // 벽세움
					dfs(i, j, w + 1);
				}
			}*/
			if (cp[i][j] == 0) {
				cp[i][j] = 3;
				wall.push_back(make_pair(i, j));
				if(w + 1 == 3) {
					// 바이러스 퍼지기 시작
					/*for (int k = 0; k < wall.size(); k++) {
						cp[wall[k].first][wall[k].second] = 3;
					}*/
					birus();
					//cp[i][j] = 0;
					wall.pop_back();
					init();
					//check[i][j] = false;
					return; // 함수 종료 w가 2였던 때로 돌아가서 다시 반복문 실행
				}
				else {
					dfs(i, j, w + 1);
					//wall.pop_back();
				}
			}
		}
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> mp[i][j];
			if (mp[i][j] == 2) {
				q.push(make_pair(i, j));
			}
		}
	}
	init();

	/*for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (mp[i][j] == 0) {
				dfs2(i, j, 0);
			}

		}
	}*/

	dfs(0,0,0);
	cout << answer;
}