// dfs + DP¹®Á¦

#include <bits/stdc++.h>
#define MAX 501
using namespace std;

int m, n;
long long int d[MAX][MAX];
int a[MAX][MAX];
int ax[] = { -1,1,0,0 };
int ay[] = { 0,0,-1,1 };

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> m >> n;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}
	d[0][0] = 1;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (d[i][j] == 0) continue;
			for (int k = 0; k < 4; k++) {
				if (i + ax[k] < 0 || i + ax[k] >= m || j + ay[k] < 0 || j + ay[k] >= n) continue;
				if (a[i][j] > a[i + ax[k]][j + ay[k]]) {
					d[i + ax[k]][j + ay[k]] = 1;
				}
				else if (a[i][j] < a[i + ax[k]][j + ay[k]]) {
					d[i][j] += d[i + ax[k]][j + ay[k]];
				}
			}
		}
	}
	cout << d[m - 1][n - 1] - 1;
}