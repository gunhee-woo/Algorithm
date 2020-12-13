#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

string intToBinary(int n, int k) {
	stack<int> st;
	string str = "";
	while (k != 1) {
		if (k % 2 == 1) {
			st.push(1);
			k /= 2;
		}
		else if (k % 2 == 0) {
			st.push(0);
			k /= 2;
		}
	}
	st.push(1);
	if (st.size() < n) {
		int size = st.size();
		for (int i = 0; i < n - size; i++)
			st.push(0);
	}
	while (!st.empty()) {
		if (st.top() == 1) {
			str += "#";
		}
		else if (st.top() == 0) {
			str += " ";
		}
		st.pop();
	}
	return str;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
	vector<string> answer;
	string str = "";
	for (int i = 0; i < n; i++) {
		int k = arr1[i] | arr2[i];
		str = intToBinary(n, k);
		cout << str << endl;
		answer.push_back(str);
	}
	return answer;
}

/*int main() {
int n = 5;
vector<int> arr1 = { 0,0,0,0,0 };
vector<int> arr2 = { 30,1,21,17,28};
vector<string> answer = solution(n, arr1, arr2);

}*/