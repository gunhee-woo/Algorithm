#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define  MAX 9
int n, m;
bool check[MAX];
vector<int> v;

void dfs(int ix, int c) {
	if (c == m + 1) {
		sort(v.begin(), v.end());
		for (auto i : v) {
			printf("%d ", i);
		}
		printf("\n");
		return;
	}
	for (int i = ix; i <= n; i++) {
		if (check[i] == true) continue;
		check[i] = true;
		v.push_back(i);
		dfs(i, c + 1);
		v.pop_back();
		check[i] = false;
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	scanf("%d%d", &n, &m);
	dfs(1, 1);
	return 0;
}