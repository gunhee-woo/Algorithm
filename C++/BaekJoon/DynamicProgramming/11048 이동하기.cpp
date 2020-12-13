#include <bits/stdc++.h>
#define MAX 1001
using namespace std;

int n, m;
int d[MAX][MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			int val, mx = 0;
			cin >> val;
			mx = max(mx, d[i - 1][j - 1]);
			mx = max(mx, d[i - 1][j]);
			mx = max(mx, d[i][j - 1]);
			d[i][j] = val + mx;
		}
	}
	cout << d[n][m];
}