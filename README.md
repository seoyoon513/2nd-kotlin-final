# STARTERS 취업부트캠프 최종평가(Android)

### 평가 안내 ([노션 링크](https://www.notion.so/flearnerhq/STARTERS-Android-fd43f021f2c94472a53a52edc322a122))

---

- 핸드폰에 기본적으로 설치되어있는 앱 중 하나인 계산기 앱을 구현합니다.
- 평가일정
    - 시험 시작 ~ 오후 6시 (점심시간인 오후 12시 30분 ~ 2시에는 반드시 퇴실)
- 평가방법
    - 평가배점표에 따라 기본점수에서 가감하여 총합된 점수로 평가
- 제출방법
    - 제출은 Github Repository로 제출 시간 내 Pull Request를 진행합니다.
    - [구글폼](https://forms.gle/quAHq1QUvnHubZHw5)을 통해 파일 및 Github 아이디를 제출합니다.
        - AAB(혹은 APK) 파일은 압축 후 제출합니다.
    - 본 README파일을 활용하여 본인이 구현한 사항에 대해 진행 여부를 표기하여 제출합니다.

### 평가 전 주의사항

---

- 스택 별로 권장되는 코딩 표준 스타일을 활용합니다.
    - [Kotlin 코딩 표준](https://www.notion.so/Kotlin-770ade858b7940b5aec1905ad9406938)
- 인터넷 상에서 구현에 필요한 사항을 검색/활용할 수 있습니다.
- 기타 부정행위로 간주될만한 사항이 적발될 경우 강제퇴실 처리

### 평가배점

---

| 구분 | 내용 |
| --- | --- |
| 기본점수 | 200점 |
| 코딩 표준 스타일 | 미준수 시 건당 -1점 |
| 기능 요구사항 | 구현 시 +20점, 미구현 시 -10점 |
| 예외처리 고려사항 | 구현 시 +20점, 미구현 시 -20점 / Readme 작성 및 구현 시 건당 +10점 |
| UI 요구사항 | 구현 시 +20점, 미구현 시 -20점 / Readme 작성 및 구현 시 건당 +10점  |

### 전제사항

---

- 에러 없이 계산기의 온전한 기능을 하게끔 구현합니다.
- 실제 **14자리 계산기**의 기능을 웹(앱)으로 구현합니다.

![image](/image.png)

- UI는 자신의 스마트폰에 계산기 앱 디자인을 참고하여 구현합니다.
    - 고객에게 서비스의 기능에 대한 시각적 단서를 제공하는 것을 우선으로 합니다.

### 기능 요구사항

---

- [ ]  `+ - / *` 사칙연산 버튼 기능 구현
- [ ]  `+/-` 버튼 기능 구현
- [ ]  `C` 버튼 기능 구현
    - 현재 입력내용만 지움
- [ ]  `AC` 버튼 기능 구현
    - 계산 중인 내용 & GT 내용 지움
- [ ]  `√` ****루트 버튼 ****기능 구현
- [ ]  `▶` 지우기 버튼 기능
- [ ]  `K` 기능 구현
- [ ]  `GT` 기능 구현
- [ ]  `MC`, `MR`, `M-`, `M+`  기능 구현
- [ ]  `.` 소수점 입력 기능 구현
- [ ]  1,000단위 기준 , 표시
- [ ]  라운딩 셀렉터 구현
    - F → 소수점 이하 수를 있는 그대로 표시, 14자리에 맞추어서 출력
    - CUT → 버림
    - 5/4 → 반올림
- [ ]  자리수 셀렉터 구현
    - 소수점 자리수 4, 3, 2, 1, 0 표시
    - ADD2 → 모든 수를 기본적으로 소수점 2자리 수로 변환
- [ ]  기능구현 제외 버튼 `H/M/S`, `%`
    - 클릭시 ‘기능 구현 예정입니다’ 메세지 표시
- 참고자료
    
    [계산기 기능(1) : F, CUT, 5/4, 43210, ADD2](https://blog.naver.com/PostView.nhn?blogId=lienor&logNo=221261139102)
    
    [계산기 기능(2) : M+, M-, MR, MC](https://blog.naver.com/PostView.naver?blogId=lienor&logNo=221262660715&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView)
    
    [계산기 기능(3) : GT, K(+ ×), AC, C, TAX-, TAX+](https://blog.naver.com/PostView.naver?blogId=lienor&logNo=221266620136&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView)
    

### 예외처리 고려사항

---

- 실물 계산기를 IT 환경으로 옮기는 만큼 모달, 팝업 등을 통한 에러 메세지 출력은 최소화 합니다.
- [ ]  14자리로 표현할 수 없는 숫자가 나오는 경우, ERROR 메세지를 계산기 화면에 출력합니다.
- [ ]  유저가 입력할 수 있는 다양한 형태의 부절절한 입력형태와 그에 대한 대응을 고려하여 코드를 작성합니다.
    - Readme 파일에 고려한 내용, 그에 대한 대응을 적습니다. (건당 10점, 차감 없음)

### UI/UX 요구사항

---

- 실물 계산기를 고려하여 임의로 구현
    
    ![image](/image.png)
    
- 구현 필요사항
    - [ ]  계산기 화면에 숫자는 총 14자리
    - [ ]  계산기 화면에 현재 사용중인 기능 & 현재 누른 연산버튼 등 표시 (M, GT, K, +, -, ×, ÷)
    - [ ]  라운딩 셀렉터, 자리수 셀렉터는 기능에만 초점을 맞춰서 구현할 것(라디오 버튼, 셀렉트 박스 등 자유롭게 가능)
    - [ ]  버튼 색상 구분 (C, AC / MC, MR, M-, M+ / 그 외)
    - [ ]  버튼 클릭시 색변화, 글자 크기 감소
    - [ ]  미구현된 버튼은 눌렀을시 ‘기능 구현 예정입니다.’ 팝업 표시
- 기타 과제 내용에는 명시 되지 않았지만 유저의 편의를 위해 추가하거나 고려한 기능
    - Readme파일에 고려한 이유와 구현 내용을 적습니다. (건당 10점, 차감 없음)
