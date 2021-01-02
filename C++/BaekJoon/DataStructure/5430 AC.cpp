#include <bits/stdc++.h>
#include <sstream>
using namespace std;

int t;

deque<int> split(string arr, char d) {
	deque<int> answer;
	stringstream ss(arr);
	string temp;
	while (getline(ss, temp, d)) {
		answer.push_back(stoi(temp));
	}
	return answer;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	while (t--) {
		string fun, arr;
		int n;
		cin >> fun >> n >> arr;
		arr = arr.substr(1, arr.size() - 2);
		deque<int> v = split(arr, ',');
		bool front = true; // 앞 true 뒤 false
		bool error = false; // 에러 여부 판단
		for (char c : fun) {
			if (c == 'R') front = !front;
			else if (c == 'D') {
				if (v.empty()) {
					error = true;
					break;
				}
				if (front) v.pop_front();
				else v.pop_back();
			}
		}
		if (error) {
			cout << "error" << "\n";
			continue;
		}
		if (!front) reverse(v.begin(), v.end());
		cout << "[";
		for (int i = 0; i < v.size(); i++) {
			if (i == v.size() - 1) cout << v[i];
			else cout << v[i] << ",";
		}
		cout << "]" << "\n";
	}
}