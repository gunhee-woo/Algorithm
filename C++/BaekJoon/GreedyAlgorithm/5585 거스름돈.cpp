#include <iostream>
using namespace std;
int n;
int main() {
	scanf("%d", &n);
	int answer = 0;
	int k = 1000 - n;
	while (k != 0) {
		if (k == 0)
			break;
		if (k >= 500) {
			answer++;
			k = k - 500;
			continue;
		}
		if (k >= 100) {
			answer++;
			k = k - 100;
			continue;
		}
		if (k >= 50) {
			answer++;
			k = k - 50;
			continue;
		}
		if (k >= 10) {
			answer++;
			k = k - 10;
			continue;
		}
		if (k >= 5) {
			answer++;
			k = k - 5;
			continue;
		}
		if (k >= 1) {
			answer++;
			k = k - 1;
		}
	}
	printf("%d", answer);
}