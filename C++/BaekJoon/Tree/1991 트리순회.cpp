// 재귀로 구현

#include <bits/stdc++.h>
using namespace std;

int n;
char a[27][3];
map<char, int> m;
string answer;

void postorder(int x) { // 후위순회
	if (answer.size() == n) {
		return;
	}
	if (a[x][1] != '.') {
		postorder(m.at(a[x][1]));
	}

	if (a[x][2] != '.') {
		postorder(m.at(a[x][2]));
	}

	answer += a[x][0];
}

void inorder(int x) { // 중위 순회
	if (answer.size() == n) {
		return;
	}
	if (a[x][1] != '.') {
		inorder(m.at(a[x][1]));	
	}

	answer += a[x][0];

	if (a[x][2] != '.') {
		inorder(m.at(a[x][2]));
	}
}
 
void preorder(int x) { // 전위순회
	if (answer.size() == n) {
		return;
	}
	answer += a[x][0];
	if (a[x][1] != '.') {
		preorder(m.at(a[x][1]));	
	}
	if (a[x][2] != '.') {
		preorder(m.at(a[x][2]));
	}
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> a[i][j];
		}
		m[a[i][0]] = i;
	}
	preorder(0);
	cout << answer << "\n";
	answer.clear();
	inorder(0);
	cout << answer << "\n";
	answer.clear();
	postorder(0);
	cout << answer << "\n";
}