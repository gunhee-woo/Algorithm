// 전형적인 DP문제
// 각 경우의 수를 세서 최소 경우의 수를 답으로 구함
// d[n] : 숫자 n을 만드는 경우의 수 
// 답은 d[k]
// 먼저 d[n]을 INF로 초기화한 후 min을 사용하여 경우의 수를 셈
// 각 동전을 사용하여 나오는 경우의 수를 모두 계산

#include <bits/stdc++.h>
#define INF 10001
using namespace std;

int n, k;
int coin[101];
int d[INF];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> k;
	for (int i = 1; i <= k; i++) {
		d[i] = INF;
	}
	for (int i = 0; i < n; i++) {
		cin >> coin[i];
		for (int j = coin[i]; j <= k; j++) {
			d[j] = min(d[j], d[j - coin[i]] + 1);
		}
	}
	if (d[k] == INF)
		cout << -1;
	else
		cout << d[k];
}