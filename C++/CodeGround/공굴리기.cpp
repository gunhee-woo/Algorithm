#define _USE_MATH_DEFINES
#include <bits/stdc++.h>
using namespace std;

int t;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int test_case = 0; test_case < t; test_case++) {
		int R, S, E, n;
		cin >> R >> S >> E >> n;
		double answer = E - S;
		for (int i = 0; i < n; i++) {
			int l, r, h;
			cin >> l >> r >> h;
			if (R <= h) {
				answer += M_PI * R;
				answer += 2 * (h - R);
				answer -= 2 * R;
			}
			else {
				double dR = R;
				answer += 2 * (2 * M_PI * dR * ((acos((dR - h) / dR) * (180 / M_PI)) / 360));
				answer -= 2 * (sqrt(2 * h * dR - (h * h)));
			}
		}
		cout << fixed;
		cout.precision(7);
		cout << "Case #" << test_case + 1 << "\n";
		cout << answer << "\n";
	}
	return 0;
}