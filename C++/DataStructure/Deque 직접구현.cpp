#include <bits/stdc++.h>
using namespace std;

// 덱은 큐와 달리 양쪽에서 모두 값을 넣을수 있기 때문에
// head와 tail의 초기값을 MX로 두고 배열의 크기를 MX*2 + 1로 둔다
// 따라서 양쪽으로 확장할 수 있게 한다
// *** 덱은 인덱스로 접근이 가능하다 ***

const int MX = 1000005;
int dat[2 * MX + 1];
int head = MX, tail = MX;

void push_front(int x) {
	dat[--head] = x;
}

void push_back(int x) {
	dat[tail++] = x;
}

void pop_front() {
	head++;
}

void pop_back() {
	tail--;
}

int front() {
	return dat[head];
}

int back() {
	return dat[tail - 1];
}