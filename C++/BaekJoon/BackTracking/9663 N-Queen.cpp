#include <bits/stdc++.h>
#define MAX 14
using namespace std;

int n;
bool check[MAX][MAX];
int answer;

bool isRange(int x, int y) {
	bool b = true;
	for (int i = 0; i < n; i++) {
		if (check[x][i] || check[i][y])
			return false;
	}

}

void dfs(int i) {
	for (int j = 0; j < n; j++) {
		if(!check[i][j] && )
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	dfs(0);
}