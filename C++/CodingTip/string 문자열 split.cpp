#include <string>
#include <sstream>
#include <iostream>
#include <vector>
using namespace std;

vector<string> split(string input, char delimiter) {
	vector<string> answer;
	stringstream ss(input);
	string temp;
	while (getline(ss, temp, delimiter)) {
		answer.push_back(temp);
	}
	return answer;
}


int main() {
	string str = "java c c++ python";
	string str2 = "java,c,c++,python";
	vector<string> result1 = split(str, ' ');
	cout << "구분자가 공백일 경우" << "\n";
	for (string s : result1) {
		cout << s << "\n";
	}
	vector<string> result2 = split(str2, ',');
	cout << "구분자가 , 일 경우" << "\n";
	for (string s : result2) {
		cout << s << "\n";
	}
}