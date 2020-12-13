#include <iostream>
#include <vector>
#include <string>
#include <utility>
using namespace std;

string to_lower(string s) {
	for (int i = 0; i < s.size(); i++)
		s[i] = tolower(s[i]);
	return s;
}

bool find(vector<pair<string, int>> &v, string s) {
	bool b = false;
	for (int i = 0; i < v.size(); i++) {
		if (to_lower(v[i].first) == to_lower(s)) {
			v[i].second = 0;
			b = true;
			return b;
		}
	}
	return b;
}

int solution(int cacheSize, vector<string> cities) {
	int answer = 0;
	vector<pair<string, int>> v;
	for (int i = 0; i < cities.size(); i++) {
		if (v.size() == 0 || cacheSize == 0) {
			v.push_back(make_pair(cities[i], 1));
			answer += 5;
			continue;
		}
		if (v.size() < cacheSize) {
			if (find(v, cities[i])) {
				answer++;
			}
			else {
				v.push_back(make_pair(cities[i], 0));
				answer += 5;
			}
		}
		else {
			if (find(v, cities[i])) {
				answer++;
			}
			else {
				pair<string, int> old = make_pair(v[0].first, v[0].second);
				for (int k = 0; k < v.size(); k++) {
					if (v[k].second > old.second) {
						old = make_pair(v[k].first, v[k].second);
					}
				}
				for (int k = 0; k < v.size(); k++) {
					if (to_lower(old.first) == to_lower(v[k].first)) {
						v[k].first = cities[i];
						v[k].second = 0;
						break;
					}
				}
				answer += 5;
			}
		}
		for (int j = 0; j < v.size(); j++)
			v[j].second++;
	}
	return answer;
}

/*int main() {
freopen("Text.txt", "r", stdin);
int size = 3;
vector<string> c;
for (int i = 0; i < 10; i++) {
string str;
cin >> str;
c.push_back(str);
}
int ans = solution(size, c);
cout << ans << endl;
return 0;
}*/