// 불, 사람이 동시에 이동하는데 불이 붙은 자리는 사람이 이동할 수 없음
// 따라서 먼저 각 인덱스에 불이 붙는 시간을 bfs를 이용하여 배열에 저장
// 그리고나서 사람이 bfs를 이용하여 이동하며 시간을 잼
// 어떤 인덱스에 사람이 이동한 시간이 불이 붙은 시간보다 이전일 경우 사람은 그 인덱스로 이동할 수 있음
// 이렇게 이동하며 끝으로 이동할때 까지 계산
// 가장 먼저 끝으로 이동할 떄가 최소 시간을 소요한 것이므로 그때의 값이 정답
// bfs를 두 번 사용하여 푸는 문제
// ****

#include <bits/stdc++.h>
#define MAX 1001
#define INF 987654321
using namespace std;

int t, w, h;
char m[MAX][MAX]; // 지도
bool check[MAX][MAX]; // 사람이 그 인덱스에 이동했는지 확인
int fire[MAX][MAX]; // 불이 붙는 시간

int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

typedef struct person{
	int x;
	int y;
	int time; // 사람이 이동한 시간
};

void init(int w, int h) {
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			fire[i][j] = INF;
		}
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	while (t--) {
		cin >> w >> h;
		pair<int, int> start; // 시작점
		queue<pair<int, int>> q; // 불의 위치
		memset(check, false, sizeof(check));
		init(w, h); 
		int answer = -1; // 초기화

		for (int i = 0; i < h; i++) { // input
			for (int j = 0; j < w; j++) {
				cin >> m[i][j];
				if (m[i][j] == '@') { // 사람의 시작점을 얻어냄
					start.first = i;
					start.second = j;
				}
				if (m[i][j] == '*') { // 각 불의 처음 시작점을 얻어냄
					q.push(make_pair(i, j)); 
					fire[i][j] = 0;
				}
			}
		}
		
		while (!q.empty()) { // bfs
			int curx = q.front().first;
			int cury = q.front().second;
			q.pop();
			for (int i = 0; i < 4; i++) {
				int nx = curx + ax[i];
				int ny = cury + ay[i];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (m[nx][ny] != '#') {
					if (fire[nx][ny] > fire[curx][cury] + 1) {
						fire[nx][ny] = fire[curx][cury] + 1;
						q.push(make_pair(nx, ny));
					}
				}
			}
		}

		check[start.first][start.second] = true; // 시작점값 초기화
		queue<person> pq;
		pq.push({ start.first, start.second, 0 });
		while (!pq.empty()) { // bfs
			int cx = pq.front().x;
			int cy = pq.front().y;
			int ct = pq.front().time;
			pq.pop();

			if (cx == 0 || cy == 0 || cx == h - 1 || cy == w - 1) { // 마지막 인덱스에 도착했을 경우 
				answer = ct + 1;
				break;
			}	

			for (int i = 0; i < 4; i++) {
				int nx = cx + ax[i];
				int ny = cy + ay[i];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (m[nx][ny] == '.' && check[nx][ny] == false) {
					if (fire[nx][ny] > ct + 1) { // 사람이 불보다 그 위치에 더 일찍 도착했을 때 => 이동가능
						check[nx][ny] = true;
						pq.push({ nx, ny, ct + 1 });
					}
				}	
			}
		}
		if (answer == -1)
			cout << "IMPOSSIBLE" << "\n";
		else
			cout << answer << "\n";
	}
}