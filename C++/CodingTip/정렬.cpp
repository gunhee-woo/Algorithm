#include <bits/stdc++.h>
using namespace std;

typedef struct people {
	int age;
	string name;
	people(int _age, string _name) : age(_age), name(_name) {};
} P;

bool compare1(P p1, P p2) { // 객체 정렬
	if (p1.age == p2.age) return p1.name > p2.name; // 사전순으로 정렬(내림차순)
	else return p1.age > p2.age; // 나이순으로 정렬(내림차순)
}

bool compare2(int a1, int a2) { // 내림차순 정렬
	return a1 > a2;
}

int main() {
	int n[] = { 21, 15, 66, 66, 100 };

	sort(n, n + 5, compare2);
	cout << "내림차순 정렬 compare 함수 구현" << "\n";
	for (int i : n) {
		cout << i << " ";
	}
	cout << "\n";

	sort(n, n + 5);
	cout << "오름차순 정렬" << "\n";
	for (int i : n) {
		cout << i << " ";
	}
	cout << "\n";

	sort(n, n + 5, greater<int>());
	cout << "내림차순 정렬 greater 사용" << "\n";
	for (int i : n) {
		cout << i << " ";
	}
	cout << "\n";

	string str[] = { "abc", "bca", "cab", "cba", "acb" };
	int a[] = { 10, 20, 30, 30, 40 };
	
	vector<P> v;
	for (int i = 0; i < 5; i++) {
		P p(a[i], str[i]);
		v.push_back(p);
	}
	cout << "객체 정렬 전" << "\n";
	for (P p : v) {
		cout << "age : " << p.age << " name : " << p.name << " , ";
	}
	cout << "\n";
	sort(v.begin(), v.end(), compare1);
	cout << "객체 정렬 후" << "\n";
	for (P p : v) {
		cout << "age : " << p.age << " name : " << p.name << " , ";
	}
	cout << "\n";
}