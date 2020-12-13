// 좀 미친 그리디 알고리즘 문제 아직 미해결

#include <bits/stdc++.h>
#define MAX 101
using namespace std;

int n, k;
int a[MAX];

int main() {
	freopen("Text.txt", "r", stdin);
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> k;
	for (int i = 0; i < k; i++) {
		cin >> a[i];
	}

	int answer = 0;
	set<int> st; // 멀티탭
	st.insert(a[0]);
	for (int i = 1; i < k; i++) {
		if (st.size() < n) { // 자리가 비어있는 경우
			st.insert(a[i]);
		}
		else { // 자리가 꽉 차 있는 경우
			if (st.find(a[i]) != st.end()) { // 이미 꽂혀있는경우
				continue;
			}
			else { // 새로운 걸 꽂아야하는 경우
				multiset<int> ms;
				for (int j = i + 1; j < k; j++) { 
					ms.insert(a[j]);
				}
				int val = 0;	
				int min = 101;
				for (auto it = st.begin(); it != st.end(); it++) { 
					if (min > ms.count(*it)) { // i 보다 뒤에 있는 것들 중에서 앞으로 가장 적게 사용될 것 뽑음
						min = ms.count(*it);
						val = *it;
					}
				}
				st.erase(val);
				st.insert(a[i]);
				answer++;
				unordered_set<int> us;

			}
		}
	}
	cout << answer;
}