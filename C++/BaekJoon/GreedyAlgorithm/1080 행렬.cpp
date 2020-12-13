#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<string> a;
vector<string> b;
int cnt = 0;

void flip(int x, int y) {
	cnt++;
	for (int i = x; i < 3 + x; i++) {
		for (int j = y; j < 3 + y; j++) {
			if (a[i][j] == '0') {
				a[i][j] = '1';
			}
			else {
				a[i][j] = '0';
			}
				
		}
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		a.push_back(str);
	}
	for (int i = 0; i < m; i++) {
		cin >> str;
		b.push_back(str);
	}
	for (int i = 0; i < n - 2; i++) {
		for (int j = 0; j < m - 2; j++) {
			if (a[i][j] != b[i][j]) {
				flip(i, j);
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] != b[i][j]) {
				cout << "-1";
				return 0;
			}
		}
	}
	cout << cnt;

	return 0;
}