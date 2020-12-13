// 이런 류의 문제들은 대부분 각 부분 문제의 답을 알고 있다면 역으로 그 답들을 끼워맞춰서 풀어낼 수 있습니다.


#include <bits/stdc++.h>
#define MAX 1001
using namespace std;

int n;
int a[MAX][3];
int d[MAX][3];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> a[i][j];
		}
	}
	d[0][0] = a[0][0]; // 초기화
	d[0][1] = a[0][1];
	d[0][2] = a[0][2];
	for (int i = 1; i < n; i++) { // 최솟값 연산
		d[i][0] = min(d[i - 1][1], d[i - 1][2]) + a[i][0];
		d[i][1] = min(d[i - 1][0], d[i - 1][2]) + a[i][1];
		d[i][2] = min(d[i - 1][0], d[i - 1][1]) + a[i][2];
	}
	cout << min(min(d[n - 1][0], d[n - 1][1]), d[n - 1][2]);
}