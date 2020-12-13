// 입력값 제한이 있는 문제 => int형으로는 모든 입력을 담을수 없음 따라서 long long 을 사용해야함

#include <bits/stdc++.h>
#define MAX 500001
using namespace std;

int n;
int a[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a, a + n);
	long long answer = 0; // 등수가 500000 이하의 자연수로 이루어져 있어 int형에 모두 담을 수 없음
	for (int i = 0; i < n; i++) {
		answer += abs(a[i] - (i + 1));
	}
	cout << answer;
}