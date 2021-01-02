#include <iostream>
#include <string>
using namespace std;

int main() {
	// getline 함수는 두 가지가 존재

	// 1. istream 라이브러리에 속한 cin.getline()
	// 문자배열이며 n - 1개의 문자 개수만큼 읽어와 str에 저장
	// 세번째 인자인 delim은 별도의 입력이 없으면 '\n'으로 인식
	// delim을 지정해주면 그 delim 문자 직전까지 읽어서 str에 저장

	// cin.getline(char* str, streamsize n);
	// cin.getline(char* str, streamsize n, char delim);

	char a[10], b[10];
	cin.getline(a, 10);
	cin.getline(b, 10, ',');

	// 2. string 라이브러리의 getline()
	// 최대 문자수를 입력하지 않음
	// 원하는 구분자(delim)을 만날 때 까지 모든 문자열을 입력받아 string 객체에 저장

	//getline(istream& is, string str);
	//getline(istream& is, string str, char delim);

	int n;
	string str;
	cin >> n;
	cin.ignore(); // => n을 입력받은 후 누른 '\n'가 그대로 getline에 들어가는 문제를 해결하기 위함
	getline(cin, str);
}