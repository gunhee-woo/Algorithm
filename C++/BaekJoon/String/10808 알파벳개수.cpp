#include <bits/stdc++.h>
using namespace std;

/*int a[26];
int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	string str;
	cin >> str;
	for (char c : str) {
		a[c - 'a']++;
	}
	for (int i = 0; i < 26; i++) {
		cout << a[i] << " ";
	}
} */

int a[101];
bool func2(int arr[], int len) {
	for (int i = 0; i < len; i++) {
		if (a[100 - arr[i]] == 1)
			return true;
		a[arr[i]] = 1;
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int arr[] = { 4, 13, 63, 87 };
	if (func2(arr, 4)) {
		cout << "true";
	}
	else {
		cout << "false";
	}
}