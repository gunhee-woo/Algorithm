// 전형적인 dfs 문제 
// dfs를 사용하여 최대한 많은 수를 조합함

#include <bits/stdc++.h>
using namespace std;

int t;
int a[4][4];

int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

set<int> st; // 일곱자리수를 담는 자료구조, set은 중복을 허용하지 않고 자동으로 정렬됨

void dfs(int i, int j, int depth, int n) {
	if (depth == 7) {
		st.insert(n);
		return;
	}
	n = n * 10;
	n += a[i][j]; // 새로운 숫자를 일의자리수에 집어넣음

	if (i - 1 >= 0) // dfs로 어떤 좌표에서 4가지 방향으로 이동하는 방법
		dfs(i - 1, j, depth + 1, n);
	if (i + 1 < 4)
		dfs(i + 1, j, depth + 1, n);
	if (j - 1 >= 0)
		dfs(i, j - 1, depth + 1, n);
	if (j + 1 < 4)
		dfs(i, j + 1, depth + 1, n);
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for(int k = 1; k <= t; k++) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cin >> a[i][j];
			}
		}
		st.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				dfs(i, j, 0, 0);
			}
		}
		cout << "#" << k << " " << st.size() << "\n";

	}
	return 0;
}