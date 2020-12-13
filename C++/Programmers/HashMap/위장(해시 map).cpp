// map 활용 문제

#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
	int answer = 1;
	map<string, int> mp;
	for (int i = 0; i < clothes.size(); i++) { // 각 key값별로 카운트
		mp[clothes[i][1]]++;
	}
	for (auto i : mp) { // 해당 옷 종류를 안 입는 경우를 추가
		answer *= (i.second + 1);
	}
	return answer - 1; // 모든 옷 종류를 안 입는 경우를 뺌 => 적어도 옷 종류 하나는 입어야 하므로
}
