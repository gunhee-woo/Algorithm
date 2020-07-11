#include <iostream>
#include <vector>
using namespace std;
int n, k;
vector<int> v;
int main() {
	scanf("%d%d", &n, &k);
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		int value;
		scanf("%d", &value);
		v.push_back(value);
		
	}
	for (int i = n - 1; i >= 0; i--) {
		if (v[i] > k)
			continue;
		cnt += k / v[i];
		k = k % v[i];
		if (k == 0)
			break;
	}
	printf("%d", cnt);
	return 0;
}