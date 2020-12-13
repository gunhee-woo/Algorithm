#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

int T, test_case;
int d[MAX]; // 해당 인덱스의 최소 점프 횟수

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> T;
	for (test_case = 0; test_case < T; test_case++) {
		int answer = 0;
		int x, y;
		cin >> x >> y;

		if (d[y] != 0) { // 이전 테스트케이스에 계산한 값이 존재한다면
			answer = *min_element(d + x, d + y);
			cout << "Case #" << test_case + 1 << "\n";
			cout << answer << "\n";
			continue;
		}

		int cur = 0;
		int jump = 1;
		int count = 0;
		if (d[x] == 0) {
			while (cur + jump < x) {
				cur += jump;
				count++;
				jump++;
				d[cur] = count;
			}
		}



		for (int i = x; i <= y; i++) {
			if (d[i] != 0) {
				cur = i;
				count = d[i];
				continue;
			}
			while (cur + jump < i) {
				cur += jump;
				count++;
				jump++;
				d[cur] = count;
			}
			jump = 1;
			cur += jump;
			count++;
			jump++;
			d[cur] = count;

		}

		cout << "Case #" << test_case + 1 << "\n";
		cout << answer << "\n";
	}

}