#include <bits/stdc++.h>
using namespace std;

#define MAX 1001

int n, l;
int a[MAX];

int main() {
	//freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> l;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a, a + n);
	int k = 0;
	int answer = 0;
	for (int i = 0; i < n; i++) {
		if (k == 0) {
			answer++;
			k = a[i] + l - 1;
		}
		else {
			if (a[i] == k) {
				k = 0;
			}
			else if (a[i] > k) {
				answer++;
				k = a[i] + l - 1;
			}
		}
	}
	cout << answer;
}