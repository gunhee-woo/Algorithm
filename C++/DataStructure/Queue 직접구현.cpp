#include <iostream>
using namespace std;

int dat[1000005];
int head = 0, tail = 0;

void push(int x) {
	dat[tail++] = x;
}

void pop() {
	head++;
}

int front() {
	return dat[head];
}

int back() {
	return dat[tail - 1];
}

bool empty() {
	return head == tail
}

int size() {
	return tail - head;
}