#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> v;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	v.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	int count = 0, start = 0, end = 0, sum = 0;	
	while (1) {
		if (v[start] == m) {
			count++;
			start++;
			end++;
		}
		if (sum < m) {
			end++;
			sum += v[end];
			continue;
		}
		if (sum > m) {
			sum -= v[start];
			start++;
			continue;
		}
		if (sum == m) {

		}
		if (start == end) {
			sum = v[start];
			end++;
			continue;
		}
	}
}