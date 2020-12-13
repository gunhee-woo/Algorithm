#include <bits/stdc++.h>
#define MAX 51
using namespace std;

string str;
vector<int> v;
int a[MAX];
int _max;

void dfs(int ix) {
	if (ix >= str.size()) {
		for (int i = 0; i < v.size(); i++) {
			cout << v[i] << " ";
		}
		exit(0);
	}
	int val = atoi(str.substr(ix, 1).c_str());
	if (a[val] == 0 && val != 0) {
		a[val] = 1;
		v.push_back(val);
		dfs(ix + 1);
		v.pop_back();
		a[val] = 0;
	}
	val = atoi(str.substr(ix, 2).c_str());
	if (a[val] == 0 && val <= _max) {
		a[val] = 1;
		v.push_back(val);
		dfs(ix + 2);
		v.pop_back();
		a[val] = 0;
	}
	return;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> str;
	_max = (str.size() - 9) / 2 + 9;
	dfs(0);
}