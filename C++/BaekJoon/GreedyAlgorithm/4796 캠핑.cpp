#include <bits/stdc++.h>
using namespace std;

int main() {
	int ix = 1;
	while (1) {
		int l, p, v;
		cin >> l >> p >> v;
		if (l == 0 && p == 0 && v == 0)
			break;
		int answer = 0;
		answer += (v / p) * l;
		if (v % p >= l)
			answer += l;
		else
			answer += v % p;
		cout << "Case " << ix++ << ": " << answer << '\n';
	}
	return 0;
}