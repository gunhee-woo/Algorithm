// 쉬운 그리디 알고리즘 문제

#include <bits/stdc++.h>
#define MAX 101
using namespace std;

int n, m;
int a[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	vector<int> v;
	while (n--) {
		int p, l;
		cin >> p >> l;
		memset(a, 0, sizeof(p));
		for (int i = 0; i < p; i++) {	
			cin >> a[i];
		}
		sort(a, a + p, greater<int>()); // 내림차순 정렬
		if (p >= l)
			v.push_back(a[l - 1]);
		else
			v.push_back(1); // 수강인원보다 신청한사람이 적은 경우 마일리지는 1만 넣는것이 최선의 방법
	}
	sort(v.begin(), v.end());
	int answer = 0;
	for (int i = 0; i < v.size(); i++) {
		if (m - v[i] < 0) {
			break;
		}
		m -= v[i];
		answer++;
	}
	cout << answer;
}