#include <bits/stdc++.h>
using namespace std;

void map_base() {
	// map
	// key값을 중복허용하지 않음
	// [] 연산자를 사용할 수 있음 => ex) mp[1] = 2


	// map에서 동일한 key값 카운트
	map<string, int> mp;
	mp["a"]++;

	// 반복문
	for (auto i : mp) {
		cout << i.first << " " << i.second << "\n";
	}

	// map value에 vector가 들어가있는 경우
	map<string, vector<pair<int, int>>> mpv;
	mpv["a"].push_back(make_pair(1, 2));
}

void multimap_base() {
	// multimap
	// map에 중복원소를 허용하여 사용 => 여러 key를 중복해서 사용가능
	// [] 연산자를 제공하지 않음 => ex) mm[1] = 2 (X)
	// 항상 정렬이 되면서 삽입
	// pair객체를 사용하여 key, value를 묶음

	// 선언
	multimap<int, int> mm;

	// insert
	mm.insert(pair<int, int>(1, 2));
	mm.insert({ 1,3 });
	mm.insert(make_pair(2, 4));

	// count
	// 각 키에 해당하는 value 값들의 수를 셈
	cout << mm.count(1) << "\n";

	// 오름차순 내림차순 정렬 설정 => 기본적으로 오름차순
	multimap<int, string, greater<int>> mmg; // => 내림차순 정렬

	// 반복문
	for (auto i : mm) { // foreach 사용
		cout << i.first << " " << i.second << "\n";
	}
	for (auto it = mm.begin(); it != mm.end(); ++it) { // 반복자 사용
		cout << (*it).first << " " << (*it).second << "\n";
	}

	// multimap 복사
	multimap<int, int> mm2(mm);

	// multimap 반복자 선언
	multimap<int, int>::iterator iter;

	
	// lower_bound(key) => key 값에 해당하는 맨 첫번째원소를 가리키는 반복자 반환, 개구간 "["
	// upper_bound(key) => key 값에 해당하는 맨 마지막원소의 다음을 가리키는 반복자 반환, 폐구간 ")"
	// 중복 키 값이 존재하는 키1 의 인자 출력
	for (auto it = mm.lower_bound(1); it != mm.upper_bound(1); it++) {
		cout << (*it).first << " " << (*it).second << "\n";
	}

	// equal_range(key)
	// key 값에 해당하는 원소의 범위를 pair 객체로 반환
	// first => lower_bound, second => upper_bound
	for (auto it = mm.equal_range(1).first; it != mm.equal_range(1).second; it++) {
		cout << it -> first << " " << it -> second << "\n";
	}

	// 해당 키값 전체 삭제
	mm.erase(1);

	// 중복된 키값중 특정한  value 값 삭제
	for (auto it = mm.equal_range(1).first; it != mm.equal_range(1).second; it++) {
		if (it->second == 3) { // key 값이 1이면서 value가 3인 값 삭제
			mm.erase(it);
			break;
		}
	}

}

void unordered_map_base() {
	// unordered_map은 정렬을 하지 않고 담는 다는 점이 map과 다른점이다.
	// 데이터가 작다면 unordered_map이 더 성능이 좋고
	// 데이터가 크다면 map이 더 성능이 좋다 => 필요에 따라 선택
	unordered_map<int, int> um;
}