#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> solution(vector<string> strings, int n) {
	for (int i = 0; i < strings.size(); i++) {
		for (int j = 0; j < strings.size() - (i + 1); j++) {
			if (strings[j].at(n) > strings[j + 1].at(n)) {
				string cmp = strings[j];
				strings[j] = strings[j + 1];
				strings[j + 1] = cmp;
			}
			else if (strings[j].at(n) == strings[j + 1].at(n)) {
				if (strings[j].compare(strings[j + 1]) > 0) {
					string cmp = strings[j];
					strings[j] = strings[j + 1];
					strings[j + 1] = cmp;
				}
			}

		}
	}
	return strings;
}

/*int main() {
vector<string> v;
v.push_back("car");
v.push_back("sun");
v.push_back("bed");
vector<string> r;
r = solution(v, 1);
for (int i = 0; i < r.size(); i++)
cout << r[i] << endl;
}*/