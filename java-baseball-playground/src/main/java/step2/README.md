# 문자열 계산기 - 찾은 개선 방안

### 1. 파일 마지막은 항상 new Line으로 끝나야 한다.

    → POSIX 표준으로 그렇게 정했기 때문에. 만약 설정이 되어있지 않다면 변경하지 않은 파일도 변경된 파일로 git에 올라갈 수 있다. (IntelliJ에서 newLine을 자동으로 추가하는 설정이 가능하다)

### 2.  BiFunction 인터페이스 사용 권장.

    → Java 1.8에 추가된 FunctionalInterface 사용해서 인터페이스 생략

### 3. add, minus, multiply, divide 연산 (Operation)을 StringCalculator에서 객체화 시켜보기.

    → Enum 클래스 활용해서 연산자 별 다른 연산 결과 나타내기

### 4. 유틸리티 클래스에 대해서 알아보기

### 5. 입력하는 함수 내에서 인수 하나가 null 인경우를 고려해야 한다.
    -> 2 + + 1 OR + 1 - 2

### 6. HashMap을 통해 Enum 조회 성능 개선시켜 보기.

-> [Enum 조회 성능 높여보기 - HashMap을 이용해서 빠르게 조회해보자](https://pjh3749.tistory.com/279)

### 7. Arrays.deepEquals 알아보기

### 8. 정규식은 상수화 하기 (컴파일된 정규식 패턴을 상수로 사용)
    → 정규식을 매번 컴파일 하는데 리소스가 많이 필요하다.

    private static final Pattern pattern = Pattern.compile(”^[0-9*$”);

### 9. 객체 특성상 반드시 필요한 메서드는 생성자에서 바로 호출하도록 설계

### 10. “ “ 상수화해서 사용해보기

### 11. 배열 이름은 복수로 지정

### 12. int는 0으로 나눈 시점에는 별도로 예외를 던지는 코드를 추가하지 않아도 `ArithmeticException` 이 발생.
    -> double의 경우 Infinity가 반환된다.
