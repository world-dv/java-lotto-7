# 🚀 프리코스 3주차 미션 - 로또

---

로또를 발행하고, 로또 당첨 결과를 반환하는 🎰 **로또 발매기** 🎰입니다.

![woowacourse](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Ff71cbdcd-b763-41af-9bbb-42abdb18bd6a%2F8725996b-9c63-4691-927f-2989a2f47ca8%2Fcover-22x.png&blockId=8705deab-d8f2-476b-9892-98b37b020779&width=2400)

## 주요 기능

- **로또 구입**
  - 사용자로부터 금액을 입력받습니다.
  - 이때 로또는 한 장에 `1,000원`입니다.
- **로또 발행**
  - 사용자가 구매한 금액에 따라 로또를 발행합니다.
  - 로또는 `중복되지 않는 1에서 45사이의 숫자 6개`를 의미합니다. 
- **로또 당첨 번호 입력**
  - 사용자로부터 당첨 번호를 입력받습니다.
  - 이때 당첨 번호는 `중복되지 않는 1에서 45 사이의 숫자 6개`를 의미합니다.
- **로또 보너스 번호 입력**
  - 사용자로부터 보너스 번호를 입력받습니다.
  - 이때 보너스 번호는 `당첨 번호와 중복되지 않는 1에서 45 사이의 숫자 1개`를 의미합니다.
- **로또 당첨 결과 및 통계 출력**
  - 로또와 당첨 번호의 일치 여부를 판단해 일치하는 수의 개수를 기준으로 로또 당첨 내역을 출력합니다.
  - 로또 당첨 내역에 따라 수익률를 계산해 출력합니다.

## 개발 환경

- Java 21
- IntelliJ IDEA 2024.1.4

## 채택한 디자인 패턴

- Factory 패턴 : 객체 생성 로직을 별도의 클래스로 분리하여 캡슐화하는 패턴

## 프로젝트 구조

추가 예정

<br>

## 💡 목차

---

- [시작하기](#-시작하기)
- [Commit convention](#-commit-convention)
- [Flow](#-flow)
    - [실행 결과 예시](#실행-결과-예시)
- [용어 정의](#-용어-정의)
- [구현 리스트](#-구현-리스트)
    - [기능 구현 리스트](#기능-구현-리스트)
    - [입출력 구현 리스트](#입출력-구현-리스트)
    - [예외 처리 구현 리스트](#예외-처리-구현-리스트)
- [프로젝트 구현 후기](#프로젝트-구현-후기)

<br>

## 🚀 시작하기

---

레포지토리를 Clone한 뒤 IDE에서 어플리케이션을 실행합니다.

```
git clone https://github.com/woowacourse-precourse/java-calculator-7.git
```

브런치를 생성한 뒤 구현을 시작합니다.

```
git branch -b {branch name}
```

기능 구현 후 add, commit 명령을 사용해 로컬 저장소에 변경된 부분을 반영합니다.

```
git status // 변경된 파일 확인
git add -A(또는 .) // 변경된 전체 파일을 한번에 반영
git commit -m "message" // 작업한 내용을 메시지에 기록
```

모든 기능 구현을 마친 후, 원격 저장소에 commit을 반영하기 위해 branch를 push합니다.

```
git push origin {branch name}
```

<br>

## 📡 Commit Convention

```
<type> : <subject> 

<body> 

<footer>
```

```
git commit -m "<type> : <subject>" -m "" -m "<body>" -m "" -m "<footer>"
```

- ### Type
    - feat(feature) : 새로운 기능 추가
    - fix(bug fix) : 버그 수정
    - docs(documentation) : 문서 수정
    - style(formatting) : 코드 스타일 변경
    - refactor : 코드 리팩토링(기능 변경 X)
    - test(when adding missing tests) : 테스트 코드 추가, 수정
    - chore(maintain) : 빌드 관련 작업, 설정 수정
- ### Subject : 한 줄 요약
    - 명령형
    - 현재 시제 사용
    - 첫 글자 대문자 금지
    - 문장 끝에 마침표(.) 금지
- ### Message Body(선택 사항) : 변경 사항에 대한 상세 설명
    - 현재 시제 사용
    - 변경 이유 포함
    - 이전 동작과 대조
- ### Message footer(선택 사항)
    - Breaking changes
        - 변경 사항, 주의해야할 부분, 관련 이슈에 대한 설명과 함께 모든 변경 사항을 하단에 언급
    - Referencing issues
        - 이슈가 닫힌 경우(버그 해결) 사용
        - `Closed #keyword`
        - keyword : issue number

### Commit Message Example

```
feat: 사용자 로그인 기능 추가

사용자가 이메일과 비밀번호로 로그인할 수 있는 기능을 추가했습니다.
JWT 토큰을 사용하여 인증 절차를 구현하였으며, 로그인 실패 시의 오류 처리를 강화했습니다.

BREAKING CHANGE: 기존의 인증 방식이 JWT로 변경되었습니다.
Related to: #123
```

More : [Commit Message convention](https://gist.github.com/9941e89d80e2bc58a153.git)

<br>

## ⏳ Flow

---

1. `로또 구입 금액 문구를 출력`합니다. 
2. 사용자로부터 `로또 구입 금액을 입력`받습니다. 
3. 로또 구입 금액을 통해 `구입한 로또 개수를 계산`합니다. 
4. `구입한 로또의 개수를 출력`합니다. 
5. 로또 발행기가 구입한 로또의 개수만큼 `로또를 발행`합니다. 
6. `당첨 번호 입력 문구를 출력`합니다. 
7. 사용자로부터 `로또 당첨 번호를 입력`받습니다. 
8. `보너스 번호 입력 문구를 출력`합니다. 
9. `로또와 당첨 번호의 일치 여부를 판단`합니다. 
10. 사용자로부터 `보너스 번호를 입력`받습니다. 
11. `로또와 보너스 번호의 일치 여부를 판단`합니다. 
12. `당첨 통계 문구와 구분선을 출력`합니다. 
13. `당첨 통계 내역을 출력`합니다. 
14. 당첨 통계 내역을 기준으로 `수익률을 계산`합니다. 
15. `수익률을 출력`합니다. 
16. 로또 발매기를 `종료`합니다.

### 실행 결과 예시

```java
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

<br>

## 🏷️ 용어 정의

---

설명 추가 예정

<br>

## 📃 구현 리스트

---

### 기능 구현 리스트

- 로또 구입
   - [ ] `로또 구입 금액 / 1000`으로 구입할 로또의 개수를 계산한다. 
- 로또 발행
   - [ ] 중복되지 않는 숫자 6개를 생성한다. `Randoms.pickUniqueNumbersInRange(1, 45, 6);`
   - [ ] 발행한 로또를 오름차순 정렬한다.
   - [ ] 로또 구입 개수만큼 로또를 발행한다.
- 로또 당첨 판단
   - [ ] 사용자가 입력한 당첨 번호와 생성된 로또를 비교해 일치하는 번호의 수를 센다.
- 로또 당첨금 계산
   - [ ] 1등 -- 6개가 일치할 경우 `2,000,000,000원`을 당첨금에 더한다.
   - [ ] 2등 -- 5개와 보너스 번호가 일치할 경우 `30,000,000원`을 당첨금에 더한다.
   - [ ] 3등 -- 5개가 일치할 경우 `1,500,000원`을 당첨금에 더한다.
   - [ ] 4등 -- 4개가 일치할 경우 `50,000원`을 당첨금에 더한다.
   - [ ] 5등 -- 3개가 일치할 경우 `5,000원`을 당첨금에 더한다.
- 로또 수익률 계산
   - [ ] `로또 당첨금 / 로또 구입 금액 * 100`으로 로또 수익률을 계산한다.

- 예외 처리
   - [ ] 예외 발생 시 `IllegalArgumentException`을 발생시킨다.
   - [ ] 예외를 발생시킨 후 해당 값을 다시 입력받는다.

### 입출력 구현 리스트

- 입력
   - [ ] 사용자로부터 로또 구입 금액을 입력 받는다.
      - [ ] 입력된 금액이 정수가 아닐 경우 예외 처리 
      - [ ] 1,000원 단위가 아닐 경우 예외 처리
      - [ ] 주어진 자료형을 벗어나는 금액일 경우 예외 처리
   - [ ] 사용자로부터 당첨 번호를 입력 받는다.
      - [ ] 쉼표를 포함하지 않을 경우 예외 처리
      - [ ] 중복된 번호가 있을 경우 예외 처리
      - [x] 번호가 6개가 아닐 경우 예외 처리
          - 당첨 번호
            - [ ] 입력된 수가 정수가 아닐 경우(자료형을 벗어날 경우) 예외 처리 
            - [x] 1에서 45 사이의 수가 아닐 경우 예외 처리
   - [ ] 사용자로부터 보너스 번호를 입력 받는다.
      - [ ] 입력된 수가 정수가 아닐 경우(자료형을 벗어날 경우) 예외 처리
      - [ ] 당첨 번호와 중복될 경우 예외 처리
      - [ ] 번호가 1개가 아닐 경우 예외 처리
      - [ ] 1에서 45 사이의 수가 아닐 경우 예외 처리

- 출력
   - [ ] 로또 구입 금액 문구를 출력한다. `구입금액을 입력해 주세요.`
   - [ ] 구입한 로또 개수를 출력한다. `n개를 구매했습니다.`
   - [ ] 구입한 로또 내역을 출력한다. `[1, 2, 3, 4, 5, 6]`
      - [ ] 오름차순으로 정렬해 출력한다.  
   - [ ] 당첨 번호 입력 문구를 출력한다. `당첨 번호를 입력해 주세요.`
   - [ ] 보너스 번호 입력 문구를 출력한다. `보너스 번호를 입력해 주세요.`
   - [ ] 당첨 통계 안내 문구를 출력한다. 
        ```
        당첨 통계
        ---
        ```
   - [ ] 당첨 통계를 출력한다.
        ```
     3개 일치 (5,000원) - n개
     4개 일치 (50,000원) - n개
     5개 일치 (1,500,000원) - n개
     5개 일치, 보너스 볼 일치 (30,000,000원) - n개
     6개 일치 (2,000,000,000원) - n개
     ```
   - [ ] 총 수익률을 출력한다. `총 수익률은 n.m%입니다.`
      - [ ] 소수점 둘째 자리에서 반올림한다. 
   - [ ] 예외 처리 시 `[ERROR]` 문구로 시작하도록 출력한다.

## 프로젝트 구현 후기

추가 작성 예정