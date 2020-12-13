// 프로그래머스 체육복 문제와 동일한 문제

// 5 2 2
// 2 3
// 1 2
// 이 예제일 경우 2번 팀의 여분 카약이 존재하므로 3번팀은 출발 할 수 가 없게 됨

#include <bits/stdc++.h>
#define MAX 11
using namespace std;

int n, s, r;
vector<int> a; // 카약이 손상된 팀
vector<int> b; // 여분의 카약을 가져온 팀

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> s >> r;
	int answer = s;
	a.resize(s);
	b.resize(r);
	for (int i = 0; i < s; i++) 
		cin >> a[i];
	for (int i = 0; i < r; i++) 
		cin >> b[i];
	sort(a.begin(), a.end());
	sort(b.begin(), b.end());
	for (int i = 0; i < a.size(); i++) { // 카약이 손상된 팀이 여분의 카약을 가지고 왔을 경우
		for (int j = 0; j < b.size(); j++) {
			if (a[i] == b[j]) {
				a[i] = -1;
				b[j] = -1;
				answer--;
				break;
			}
		}
	}
	for (int i = 0; i < a.size(); i++) {
		for (int j = 0; j < b.size(); j++) {
			if (a[i] == b[j] - 1 || a[i] == b[j] + 1) {
				a[i] = -1;
				b[j] = -1;
				answer--;
				break;
			}
		}
	}
	cout << answer;
}
