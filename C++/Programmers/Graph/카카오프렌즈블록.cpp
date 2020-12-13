#include <string>
#include <vector>
#include <iostream>
using namespace std;

int x[4] = { 0, 1, 0, 1 };
int y[4] = { 0, 0, 1, 1 };

void changeblock(vector<string> &b) {
	for (int i = 0; i < b.size() - 1; i++) {
		for (int j = 0; j < b[i].size(); j++) {
			if (b[i][j] == 'x') continue;
			if (b[i][j] == '0') {
				b[i][j] = 'x';
				continue;
			}
			if (b[i + 1][j] == '0') {
				int k = i;
				while (k >= 0) {
					b[k + 1][j] = b[k][j];
					if (k != 0)
						k--;
					else
						break;
				}
				b[k][j] = 'x';
			}
		}
	}
}

int findblock(vector<string> board, int c) {
	vector<string> b = board;
	int ans = c;
	bool ck = false;
	for (int i = 0; i < board.size(); i++) {
		for (int j = 0; j < board[i].size(); j++) {
			if (board[i][j] == 'x')
				continue;
			char st = board[i][j];
			int count = 0;
			int check = 0;
			for (int k = 0; k < 4; k++) {
				if (i + x[k] == board.size() || j + y[k] == board[i].size()) break;
				if (st == board[i + x[k]][j + y[k]]) { // 같으면
					count++;
				}
				if (b[i + x[k]][j + y[k]] == '0')
					check++;
			}
			if (count == 4) { // 블록좌표찾음
				ck = true;
				ans = ans + count - check;
				b[i][j] = '0';
				b[i + x[1]][j + y[1]] = '0';
				b[i + x[2]][j + y[2]] = '0';
				b[i + x[3]][j + y[3]] = '0';
			}
		}
	}
	if (!ck)
		return ans;
	else {
		changeblock(b);
		return findblock(b, ans);
	}
}

int solution(int m, int n, vector<string> board) {
	int answer = 0;
	answer = findblock(board, answer);
	return answer;
}

/*int main() {
freopen("Text.txt", "r", stdin);
vector<string> v;
for (int i = 0; i < 4; i++) {
string s;
cin >> s;
v.push_back(s);
}
cout << solution(v.size(), v[0].size(), v) << endl;
return 0;
}*/