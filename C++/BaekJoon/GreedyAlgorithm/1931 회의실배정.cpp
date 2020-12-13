#include <bits/stdc++.h>
using namespace std;
int n;
vector<pair<int, int>> v;

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}

int main() {
	//freopen("Text.txt", "r", stdin);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		int s, e;
		cin >> s >> e;
		v.push_back(make_pair(s, e));
	}
	sort(v.begin(), v.end(), compare);
	int count = 0;
	int end = 0;
	for (int i = 0; i < n; i++) {
		if (end <= v[i].first) {
			end = v[i].second;
			count++;
		}
	}
	printf("%d", count);
	return 0;
}