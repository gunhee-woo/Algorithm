// 소수판별, 재귀문제 

#include <bits/stdc++.h>
using namespace std;

int answer;
int mx;

// *** 소수판별시 해당 수의 제곱근까지만 계산해도 판별 가능
// a, b의 최대 정수 29999 => 제곱근은 약 150이 넘는 수 => 시간단축
bool isPrime(int n) {
	if (n <= 1)
		return false;
	for (int i = 2; i <= sqrt(n); i++) {
		if ((n % i) == 0) {
			return false;
		}
	}
	return true; // n이 소수이다
}

int cal(string str, int n) { // 재귀를 사용하여 탐색
 	int val = atoi(str.c_str());
	if (!isPrime(val) || str == "") {
		return n;
	}
	int count = n + 1;
	for (int i = 0; i < str.size(); i++) {
		string s = str;
		s.erase(s.begin() + i); // erase함수를 사용하는 것과 ""치환하는것의 성능차이는 딱히 없음
		mx = max(mx, cal(s, count));
	}
	return count;
}

int main(int argc, char** argv) {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int T, test_case;
	cin >> T;
	for (test_case = 0; test_case < T; test_case++)
	{
		answer = 0;
		mx = 0;
		string a, b;
		int ac = 0, bc = 0;
 		cin >> a >> b;
		cal(a, 0);
		ac = mx;
		mx = 0;
		cal(b, 0);
		bc = mx;
		if (ac > bc)
			answer = 1;
		else if (ac < bc)
			answer = 2;
		else
			answer = 3;
		cout << "Case #" << test_case + 1 << "\n";
		cout << answer << "\n";
	}
	return 0;
}