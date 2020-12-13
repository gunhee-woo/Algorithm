// 대표적인 백트래킹 문제
// 백트래킹 문제는 바로 해결책을 생각하기는 쉽지 않음
// 따라서 DP처럼 많은 예시를 넣어보며 규칙을 찾아야 함
// 5 0
// -7 - 3 - 2 5 8


#include <bits/stdc++.h>
using namespace std;

int n, s;
int a[21];
int cnt;

void dfs(int i, int sum) {
	if (i == n)
		return;
	sum += a[i];

	if (sum == s) {
		cnt++;
	}
	dfs(i + 1, sum); // -7-3 = -10 부터 찾음
	dfs(i + 1, sum - a[i]); // -7 => -3 부터 찾음

}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	dfs(0, 0);
	cout << cnt;
}