#include <bits/stdc++.h>
#define MAX 1001
using namespace std;

int n, m;
string a[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	int answer = 0;
	string s;
	char dna[4] = { 'A', 'C', 'G', 'T' };
	for (int i = 0; i < m; i++) {
		multiset<char> ms;
		int max = 0;
		char c = 0;
		int sum = 0;
		for (int j = 0; j < n; j++) {
			ms.insert(a[j][i]);
		}
		for (int j = 0; j < 4; j++) {
			if (max < ms.count(dna[j])) {
				max = ms.count(dna[j]);
				c = dna[j];
			}
			sum += ms.count(dna[j]);
		}
		answer += (sum - ms.count(c));
		s += c;
	}
	cout << s << '\n' << answer;
}