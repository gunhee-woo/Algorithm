// 그리디 알고리즘 => 시간초과 문제 해결 0.5초
// 테스트케이스마다 초기화할 필요 없음 => 이미 저장된 값을 사용하여 시간 단축
// d[3] = d[4] + 1 => 3을 알기위해서는 4의 1을 만드는 횟수를 알아야 함

#include<bits/stdc++.h>
#define MAX 1000001
using namespace std;

int d[MAX]; // 각 인덱스 숫자의 1을 만드는 횟수
int sum[MAX]; // 인덱스 숫자까지 1을 만드는 횟수의 총 합

int main(int argc, char** argv) {
	freopen("Text.txt", "r", stdin);
	int T, test_case;
	d[1] = 0; 
	sum[1] = 0; 
	int ix = 2; // 각 테스트케이스 종료 인덱스를 저장하는 변수 => 시간단축을 위함
	cin >> T;
	for (test_case = 0; test_case < T; test_case++) {
		int n1, n2;
		cin >> n1 >> n2;
		if (d[n2] != 0) { // 만약 이미 이전에 계산해 놓은 값이 존재하면 바로 출력
			cout << "Case #" << test_case + 1 << "\n";
			cout << sum[n2] - sum[n1 - 1] << "\n";
			continue;
		}
		int end = 0; // for문의 끝을 정함
		int start = 0; // for문의 시작점을 정함
		if (n2 % 2 != 0) { // 만약 n2가 홀수면 짝수로 1을 더해 짝수를 만듬 => 어차피 해당 홀수의 값을 구하려면 1을 더한 짝수값이 필요
			end = n2 + 1;
		}
		else {
			end = n2;
		}
		if (d[n1] != 0) { // 만약 이전에 n1에 대한 값이 존재할 경우
			if (n1 % 2 != 0) { // n1이 홀수이면 시작점을 n1 + 1으로 정함
				start = n1 + 1;
			}
			else { // n1이 짝수이면 시작점을 n1으로 정함
				start = n1;
			}
		}
		else { // 이전에 계산한 값이 존재하지 않으면 이전 테스트케이스에서 계산한 값을 시작점으로 설정
			start = ix;
		}

		for (int i = start; i <= end; i += 2) {
			if (d[i] == 0) { // 만약 계산한값이 존재하지 않으면
				d[i] = d[i / 2] + 1; // 짝수 계산
				if (i != 2) {
					d[i - 1] = d[i] + 1; // 홀수 계산
				}
				sum[i] = sum[i - 2] + d[i] + d[i - 1]; // 짝수에 대한 합 계산
				sum[i - 1] = sum[i - 2] + d[i - 1]; // 홀수에 대한 합 계산
			}
		}
		ix = end; // 테스트케이스가 종료한 인덱스를 저장함 => 시간 단축
		cout << "Case #" << test_case + 1 << "\n";
		cout << sum[n2] - sum[n1 - 1] << "\n";
	}
}


// 시간초과 1초를 넘김
/*#include<bits/stdc++.h>
#define MAX 1000001
using namespace std;

int Answer;
int d[MAX];

int main(int argc, char** argv)
{
	freopen("Text.txt", "r", stdin);
	int T, test_case;
	d[1] = 0;
	cin >> T;
	for (test_case = 0; test_case < T; test_case++)
	{
		Answer = 0;
		int n1, n2;
		cin >> n1 >> n2;
		if (d[n2] != 0) {
			for (int i = n1; i <= n2; i++) {
				Answer += d[i];
			}
			cout << "Case #" << test_case + 1 << "\n";
			cout << Answer << "\n";
			continue;
		}
		int end = 0;
		int start = 0;
		if (n2 % 2 != 0) {
			end = n2 + 1;
		}
		else {
			end = n2;
		}
		if (d[n1] != 0) {
			if (n1 % 2 != 0) {
				start = n1 + 1;
			}
			else {
				start = n1;
			}
		}
		else {
			start = 2;
		}

		for (int i = start; i <= end; i += 2) {
			if (d[i] == 0) {
				d[i] = d[i / 2] + 1;
				if (i != 2) d[i - 1] = d[i] + 1;
			}
		}
		for (int i = n1; i <= n2; i++) {
			Answer += d[i];
		}
		cout << "Case #" << test_case + 1 << "\n";
		cout << Answer << "\n";
	}
	return 0;
}*/
