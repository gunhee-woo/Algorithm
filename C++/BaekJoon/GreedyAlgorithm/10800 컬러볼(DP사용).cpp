// 그리디 알고리즘 문제 n제곱으로 풀었을 경우 시간초과 발생
// 다이나믹 프로그래밍기법을 사용해야만 풀 수 있음
// ***

#include <bits/stdc++.h>
#define MAX 200001
using namespace std;
int n;

typedef struct ball{
	int num; // 처음 공의 위치
	int color;
	int size;
};

ball b[MAX];
int d[MAX]; // 같은 색깔을 가진 공들의 크기 합을 저장

bool compare(ball b1, ball b2) {
	if (b1.size == b2.size)
		return b1.color < b2.color;
	return b1.size < b2.size;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> b[i].color >> b[i].size;
		b[i].num = i;
	}

	sort(b, b + n, compare); // 공 크기 순으로 오름차순 정렬, 크기가 같으면 컬러 순으로 오름차순 정렬
	
	vector<int> a(n); // 원래 공 위치에서의 크기 합을 저장
	int sum = 0; // 공 크기의 총 합
	int j = 0; // 다른 색이지만 같은 크기를 가진 공이 여러개 있을 경우 처리를 위함
	for (int i = 0; i < n; i++) {
		while (b[j].size < b[i].size) { // 반복문을 돌면서 현재 공 크기보다 작은 값들을 계산
			sum += b[j].size;
			d[b[j].color] += b[j].size;
			j++;
		}
		a[b[i].num] = sum - d[b[i].color];
	}

	for (int i = 0; i < n; i++) {
		cout << a[i] << "\n";
	}
}

/*typedef struct ball {
	int color;
	int size;
	int num;
	int sum;
};

ball b[MAX];
int n;

bool compare1(ball b1, ball b2) {
	return b1.size > b2.size;
}

bool compare2(ball b1, ball b2) {
	return b1.num < b2.num;
}

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> b[i].color >> b[i].size;
		b[i].num = i + 1;
	}
	sort(b, b + n, compare1);
	for (int i = 0; i < n; i++) {
		int count = 0;
		for (int j = i + 1; j < n; j++) {
			if (b[i].color == b[j].color) {
				continue;
			}
			count += b[j].size;
		}
		b[i].sum = count;
	}
	sort(b, b + n, compare2);
	for (int i = 0; i < n; i++) {
		cout << b[i].sum << "\n";
	}
}*/

/*pair<int, int> p[MAX];

bool compare(pair<int, int> p1, pair<int, int> p2) {
	return p1.second > p2.second;
}

int main() { // n제곱으로 풀었을 경우 시간초과
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		p[i] = make_pair(a, b);
	}
	for (int i = 0; i < n; i++) {
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (p[i].first == p[j].first) {
				continue;
			}
			if (p[i].second > p[j].second) {
				count += p[j].second;
			}
		}
		cout << count << "\n";
	}
}*/