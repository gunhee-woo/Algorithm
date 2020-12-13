// 1. 최대한 많은 숫자를 뽑아내야 함
// 2. 그 숫자들은 최대한 큰 숫자여야 함

// 그리디 알고리즘을 사용
#include <bits/stdc++.h>
using namespace std;

int n, money;
int num[11];
vector<int> v; // 숫자의 비용을 담는 벡터
vector<int> answer; // 숫자를 담는 벡터

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	int ma = 51, mb = 51;
	int ax = 0, bx = 0;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
		if (i >= 1) { // 숫자 0을 제외한 다른 숫자중 가장 싼 값의 숫자를 구하기 위함
			if (ma >= num[i]) { 
				ma = num[i]; // ma는 숫자 0을 제외한 다른 숫자중 가장 싼 값의 숫자
				ax = i; // ma의 인덱스
			}
		}
		if (mb >= num[i]) { // 숫자 0부터 끝까지 중에서 가장 싼 값의 숫자를 구함
			mb = num[i]; // mb는 숫자 0부터 끝까지 중에서 가장 싼 값의 숫자
			bx = i; // mb의 인덱스
		}
	}
	cin >> money;
	int tmp = money;
	if (tmp < ma) { // ma 보다 가지고 있는 돈이 적으면 0밖에 살수가 없음
		cout << 0;
		return 0;
	}
	v.push_back(ma);
	answer.push_back(ax);
	tmp -= ma;
	int rm = 0; // v에 최대한 넣고 남은 돈
	while (1) { // v에 mb를 최대한 넣음
		if ((tmp - mb) < 0) {
			rm = tmp;
			break;
		}
		v.push_back(mb);
		answer.push_back(bx);
		tmp -= mb;
	}
	int ix = 0;
	int nx = n - 1;
	while (rm != 0) {
		if (ix == v.size() || nx < 0) {
			break;
		}
		if (answer[ix] == nx) { // answer와 num이 같으면 인덱스를 넘김
			ix++;
			continue;
		}
		if ((num[nx] - v[ix]) <= rm) { // 나머지보다 
			rm -= (num[nx] - v[ix]);
			answer[ix] = nx;
			v[ix] = num[nx];
			ix++;
			nx = n - 1;
		}
		else {
			nx--;
		}
	}
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}