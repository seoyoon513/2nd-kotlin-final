### 기능 요구사항

---
- [x]  `+ - / *` 사칙연산 버튼 기능 구현
- [ ]  `+/-` 버튼 기능 구현
- [x]  `C` 버튼 기능 구현
    - 현재 입력내용만 지움
- [x]  `AC` 버튼 기능 구현
    - 계산 중인 내용 & GT 내용 지움
- [x]  `√` ****루트 버튼 ****기능 구현
- [x]  `▶` 지우기 버튼 기능
- [ ]  `K` 기능 구현
- [x]  `GT` 기능 구현
- [ ]  `MC`, `MR`, `M-`, `M+`  기능 구현
- [x]  `.` 소수점 입력 기능 구현
- [ ]  1,000단위 기준 , 표시
- [ ]  라운딩 셀렉터 구현
    - [x] F → 소수점 이하 수를 있는 그대로 표시, 14자리에 맞추어서 출력
    - CUT → 버림
    - 5/4 → 반올림
- [ ]  자리수 셀렉터 구현
    - 소수점 자리수 4, 3, 2, 1, 0 표시
    - [x]ADD2 → 모든 수를 기본적으로 소수점 2자리 수로 변환
- [x]  기능구현 제외 버튼 `H/M/S`, `%`
    - 클릭시 ‘기능 구현 예정입니다’ 메세지 표시



### 예외처리 고려사항
---
- 소수점 중복 입력 방지 처리
- 계산 결과가 ```.0```으로 끝날 경우 ```.0```생략
- 0일 때 0, 00 입력 방지
