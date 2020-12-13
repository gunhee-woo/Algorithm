#include <bits/stdc++.h>
using namespace std;

struct customOrder { // 커스텀 정렬을 하기위한 구조체 선언
	bool operator() (const pair<int, int> &left, const pair<int, int> &right) const {
		if (left.first == right.first) { // first가 같으면 second 오름차순 정렬
			return left.second < right.second;
		}
		return left.first > right.first; // first 내림차순 정렬
	}
};

void set_base() {
	// set은 노드 기반의 균형 이진트리로 구현
	// key라 불리는 원소들의 집합
	// key값은 중복이 허용되지 않음
	// insert에 의해 값이 삽입되면 자동으로 정렬됨(기본적으로 오름차순)

	set<int> st;
	set<int, greater<int>> stt; // 내림차순 정렬
	set<pair<int, int>, customOrder> stc; // 커스텀 정렬

	// insert
	st.insert(1);
	st.insert(2);

	// count
	st.count(1); // 원소 1의 개수를 셀때 사용 => 그냥 set이므로 항상 0 아니면 1이 출력

	// erase
	for (auto it = st.begin(); it != st.end(); it++) {
		st.erase(it);
	}
	
	// find
	set<int>::iterator it = st.find(1);
	if (it != st.end()) { // set안에 1이 들어있다면
	}

	// set 반복문
	// 1. for-each
	for (auto &i : st) {
		cout << i << "\n";
	}
	// 2. iterator 사용
	for (auto it = st.begin(); it != st.end(); it++) {
		cout << *it << "\n";
	}
}

void multiset_base() {
	// set과 비슷하지만 key값 중복이 허용된다는 것이 큰 차이점
	// insert를 사용하여 값을 삽입하면 자동으로 정렬
	multiset<int> mt;
}

void unordered_set_base() {
	// set과 비슷하지만 자동으로 정렬이 되지 않음
	// 해시테이블을 사용
	// 원소의 삽입/삭제는 평균적으로 O(1)의 시간으로 수행하지만
	// 최악의 경우 O(N)으로 수행되는 경우가 있어
	// 데이터가 작을경우 사용하면 성능이 set보다 좋음
	unordered_set<int> us;
}