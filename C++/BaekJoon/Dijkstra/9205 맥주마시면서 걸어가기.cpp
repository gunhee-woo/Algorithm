#include <bits/stdc++.h>
using namespace std;

int t, n;
vector<pair<int, int>> v;
bool check[101];

bool mat(int x, int y, int nx, int ny) {
	int dist = abs(ny - y) + abs(nx - x);

	if (dist <= 1000) {
		return true;
	}
	return false;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> t;
	while (t--) {
		memset(check, false, sizeof(check));
		v.clear();

		cin >> n;

		for (int i = 0; i < n + 2; i++) {
			int x, y;
			cin >> x >> y;
			v.push_back(make_pair(x, y));
		}

		bool isend = false;

		queue<pair<int, int>> q;
		q.push(make_pair(v[0].first, v[0].second));
		check[0] = true;
		while (!q.empty()) {
			int curx = q.front().first;
			int cury = q.front().second;
			q.pop();

			int dx = v[n + 1].first; 
			int dy = v[n + 1].second; // 도착점

			if (mat(curx, cury, dx, dy) == true) {
				isend = true;
			}

			for (int i = 1; i < n + 2; i++) {
				int nx = v[i].first;
				int ny = v[i].second;

				if (mat(curx, cury, nx, ny) == true && check[i] == false) {
					check[i] = true;
					q.push(make_pair(nx, ny)); // 편의점으로 이동
				}
			}

		}

		if (isend == true)
			cout << "happy" << "\n";
		else
			cout << "sad" << "\n";

	}
}