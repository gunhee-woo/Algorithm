// 전형적인 시뮬레이션 문제
// 시뮬레이션 문제는 하나하나 조건을 따라가면서 충족시키면됨

#include <bits/stdc++.h>
#define MAX 51
using namespace std;

typedef struct robot {
	int r;
	int c;
	int d;
};

int n, m;
robot rb;
int a[MAX][MAX];
queue<pair<int, int>> q;

int ax[] = { 0, -1, 0, 1 }; // 왼쪽방향부터 돌기 시작함
int ay[] = { -1, 0, 1, 0 };
int dx[] = { 3, 0, 1, 2}; // 로봇이 보고있는 방향에서 왼쪽에 위치한 방향 인덱스를 저장

// 로봇이 후진할 경우
int rx[] = { 1, 0, -1, 0 };
int ry[] = { 0, -1, 0, 1 };

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	cin >> rb.r >> rb.c >> rb.d;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}
	int count = 0; // 청소한 공간 개수
	q.push({ rb.r, rb.c });
	while (!q.empty()) {
		int curx = q.front().first;
		int cury = q.front().second;
		a[curx][cury] = 2; // 청소한 공간 표현
		count++;
		q.pop();
		int ct = 0; // 회전횟수 계산
		while (1) {
			if (ct == 4) { // 후진을 해야 되는 경우
				curx = curx + rx[rb.d];
				cury = cury + ry[rb.d];
				if (a[curx][cury] == 1) { // 후진해야하는 공간에 벽이 있을 경우 종료
					cout << count;
					return 0;
				}
				else {
					ct = 0;
				}
			}
			int nx = curx + ax[rb.d]; // 로봇이 보고있는 방향의 왼쪽 탐색
			int ny = cury + ay[rb.d];
			if (a[nx][ny] == 0) { // 왼쪽방향에 청소하지 않은 공간이 존재하면
				rb = { nx, ny, dx[rb.d] }; // 그 공간으로 이동
				q.push({ rb.r, rb.c });
				break;
			}
			else { // 왼쪽방향에 청소할 공간이 없다면
				rb.d = dx[rb.d];
				ct++;
			}
		}
	}
}