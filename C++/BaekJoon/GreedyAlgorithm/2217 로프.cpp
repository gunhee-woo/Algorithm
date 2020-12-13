#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

int n;
int rope[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> rope[i];
	}
	sort(rope, rope + n); // 로프 중량으로 오름차순 정렬

	// 로프는 임의의 로프만 골라서 사용해도 됨
	// 따라서 앞에서부터 최대중량을 비교하여 가장 큰 값을 출력하면 됨
	int max = 0;
	for (int i = 0; i < n; i++) { 
		if (max < rope[i] * (n - i)) {
			max = rope[i] * (n - i);
		}
	}
	cout << max;
}

// 5
// 10 20 30 40 50
// 답 90