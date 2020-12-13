// string을 cin으로 그냥 입력 받을시 공백문자는 입력 받을 수 없음
// 공백문자를 포함하여 string을 입력받을시 getline(cin, str)을 사용하여 받아야함

#include <bits/stdc++.h>
using namespace std;

string t, f;

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	getline(cin, t); // 공백문자를 포함하여 입력받기 위함
	getline(cin, f);

	string str = "";
	int answer = 0;
	for (int i = 0; i < t.size(); i++) {
		if (str.size() == f.size()) {
			if (str == f) {
				str.clear();
				answer++;
				str += t[i];
			}
			else {
				str = str.substr(1, str.size());
				str += t[i];
			}
		}
		else {
			str += t[i];
		}
	}
	if (str == f)
		answer++;
	cout << answer;
}