#include <bits/stdc++.h>
#define MAX 51
using namespace std;

int r, c;
string s[MAX];

bool compare(pair<char, int> p1, pair<char, int> p2) {
	return p1.second < p2.second;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		cin >> s[i];
	}
	vector<pair<char, int>> v;
	for (int i = 0; i < r; i++) {
		if (v.size() == 9)
			break;
		for (int j = c - 2; j > 0; j--) {
			if (isdigit(s[i][j]) != 0) { // 숫자 찾음
				v.push_back(make_pair(s[i][j], c - 1 - j));
				break;
			}
		}
	}
	sort(v.begin(), v.end(), compare);
	vector<pair<char, int>> p;
	int count = 1;
	int n = v[0].second;
	p.push_back(make_pair(v[0].first, count));
	for (int i = 1; i < v.size(); i++) {
		if (n != v[i].second) {
			p.push_back(make_pair(v[i].first, ++count));
			n = v[i].second;
		}
		else {
			p.push_back(make_pair(v[i].first, count));
		}
	}
	sort(p.begin(), p.end());
	for (int i = 0; i < p.size(); i++) {
		cout << p[i].second << "\n";
	}
}