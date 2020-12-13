#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
	vector<string> str;
	int answer = s.size();
	for (int i = 1; i <= s.size(); i++) {
		for (int j = 0; j < s.size(); j += i) {
			if (j + i > s.size()) {
				str.push_back(s.substr(j, s.size()));
				break;
			}
			str.push_back(s.substr(j, i));
		}
		string st = str[0];
		int count = 0;
		string result = "";
		for (int j = 0; j < str.size(); j++) {
			if (st.compare(str[j]) == 0) {
				count++;
			}
			else {
				if (count == 1) {
					result += str[j - 1];
				}
				else {
					result += to_string(count) + str[j - 1];
				}
				st = str[j];
				count = 1;
			}
			if (j == str.size() - 1) {
				if (count == 1)
					result += str[j];
				else {
					result += to_string(count) + str[j];
				}
			}
		}
		cout << result << endl;
		if (answer > result.size())
			answer = result.size();
		str.clear();
	}
	return answer;
}

/*int main() {
string s = "xababcdcdababcdcd";
int ans = solution(s);
cout << ans;
return 0;
}*/