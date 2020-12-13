// 비트연산을 통해 2의제곱수(1, 2, 4, 8 ...)를 구해냄

#include <bits/stdc++.h>
using namespace std;

int k;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> k;

	int size = 1;
	while (size < k) { // 반복문을 통해 k보다 큰 가장 작은 2의제곱수를 구해냄, k가 6이면 8을 얻어냄
		size <<= 1;
	}

	int count = 0;
	//int val = 0;
	int temp = size;
	while (k > 0) {
		if (k >= temp) {
			k -= temp;
		}
		else {
			temp /= 2;
			count++;
		}
	}
	cout << size << " " << count;
}