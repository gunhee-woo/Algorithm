// 전형적인 다이나믹프로그래밍 문제
// 다이나믹은 초기화가 정말 중요 => 어디서부터 계산을 시작할 것인지 선택
// 어차피 구하고 싶은 것은 최대값을 구하는 것임!!!!
// 작은 문제로 쪼개서 생각할 것 => 작은 문제의 최대값을 이용하여 최종 최대값을 구하는 것임

#include <bits/stdc++.h>
#define HMAX 501
#define WMAX 999
using namespace std;

int d[HMAX][WMAX];

int solution(vector<vector<int>> t) {
	int answer = 0;
	d[0][0] = t[0][0]; // 초기화
	for (int i = 1; i < t.size(); i++) {
		int c = 0;
		for (int j = 0; j < t[i].size(); j++) {
			if (j == 0) { // 맨 처음 부분의 최대값 계산
				d[i][j] = d[i - 1][j] + t[i][j];
				continue;
			}
			if (j == t[i].size() - 1) { // 맨 마지막 부분의 최대값 계산
				d[i][j] = d[i - 1][j - 1] + t[i][j];
				continue;
			}
			d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + t[i][j]; // 중간 부분 계산

			//if (j - 1 >= 0) {
			//	d[i][c++] = d[i - 1][j - 1] + t[i][j];
			//}
			//if (j < t[i - 1].size()) {
			//	d[i][c++] = d[i - 1][j] + t[i][j];
			//}
		}
	}
	for (int i = 0; i < t[t.size() - 2].size() * 2; i++) {
		answer = max(answer, d[t.size() - 1][i]);
	}
	return answer;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	vector<vector<int>> v(n);
	int c = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < c; j++) {
			int a;
			cin >> a;
			v[i].push_back(a);
		}
		c++;
	}
	cout << solution(v);
}