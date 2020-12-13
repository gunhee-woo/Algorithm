// l, w, h가 홀수일 경우에 대한 처리가 필요함

#include <bits/stdc++.h>
using namespace std;

int l, w, h, n;
vector<pair<int, int>> v;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> l >> w >> h >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back(make_pair(a, b)); // first 종류 second 개수
	}
	sort(v.begin(), v.end(), greater<pair<int, int>>()); // 종류순 내림차순 정렬
	int count = 0;
	pair<int, int> p(-1, -1); // first 종류 second 남은개수
	for (int i = 0; i < v.size(); i++) {
		if (v[i].second == 0) continue;
		int k = pow(2, v[i].first);
		if (k <= l && k <= w && k <= h) {
			if (p.first == -1) { // 최초의 경우
				int cal = (l / k) * (w / k) * (h / k); // 필요한 큐브개수
				if (cal > v[i].second) { // 남음
					count += v[i].second; // 사용한 큐브개수 더함
					cal -= v[i].second;
					p.first = v[i].first;
					p.second = cal;
				}
				else { // 남은거 다 떨이
					count += cal;
					cout << count;
					return 0;
				}
			}
			else {
				int po = pow(2, p.first);
				int cal = pow(po / k, 3) * p.second; // 필요한 큐브개수
				if (cal > v[i].second) { // 남음
					count += v[i].second; // 사용한 큐브개수 더함
					cal -= v[i].second;
					p.first = v[i].first;
					p.second = cal;
				}
				else { // 남은거 다 떨이
					count += cal;
					cout << count;
					return 0;
				}
			}
		}
	}
	cout << -1;
	return 0;
}