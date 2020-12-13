#include <bits/stdc++.h>
using namespace std;

int x, y, w, s;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> x >> y >> w >> s;
	if (x > y) {
		if ((x + y) % 2 == 0) {
			cout << min((x + y) * w, min(x * s, y * s + (x - y) * w));
		}
		else {
			cout << min((x + y) * w, (x - 1) * s + w);
		}
	}
	else {
		if ((x + y) % 2 == 0) {
			cout << min((x + y) * w, y * s);
		}
		else {
			cout << min((x + y) * w, (y - 1) * s + w);
		}
	}


	if (x + y >= 2) {
		if (w * 2 > s) { // 최대한 대각선 선택
			if ((x + y) % 2 == 0) { // 대각선만 사용하는 경우
				if (x > y) {
					cout << x * s;
				}
				else {
					cout << y * s;
				}
			}
			else { // 대각선과 평행선을 같이 사용하는 경우
				if (x > y) {
					cout << (x - 1) * s + w;
				}
				else {
					cout << (y - 1) * s + w;
				}
			}
		}
		else { // 평행선만 사용하는 경우
			cout << (x + y) * w;
		}
	}
	else {
		cout << abs(x - y) * w;
	}
	return 0;
}