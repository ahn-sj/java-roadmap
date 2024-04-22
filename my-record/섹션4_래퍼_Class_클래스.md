# 섹션4. 래퍼, Class 클래스

---

# 래퍼 클래스 - 기본형의 한계1, 기본형의 한계2
기본형은 객체가 아니기 때문에 객체 메서드를 제공받지 못하고, null 값을 가질 수 없어진다.
- Object Class Method X
- Generic X
- 등등

# 래퍼 클래스 - 자바 래퍼 클래스
래퍼 클래스 = 기본형의 객체 버전

자바가 제공하는 기본 래퍼 클래스의 특징
- 불변
- 동일한 판단을 동등성으로 판별해야 함
![](https://i.imgur.com/Xi1gjzi.png)

인스턴스의 생성을 Wrapper.valueOf()를 권장
```
javadoc :: 이 메서드는 자주 요청되는 값을 캐시하여 공간 및 시간 성능을 크게 향상시킬 수 있으므로 일반적으로 Integer(int) 생성자보다 이 메서드를 우선적으로 사용해야 합니다. 이 메서드는 항상 -128에서 127 범위의 값을 캐시한다.
```
![](https://i.imgur.com/l8nCj3s.png)
래퍼 클래스의 캐싱
```java
@IntrinsicCandidate  
public static Integer valueOf(int i) {  
    if (i >= IntegerCache.low && i <= IntegerCache.high)  
        return IntegerCache.cache[i + (-IntegerCache.low)];  
    return new Integer(i);  
}

private static final class IntegerCache {  
    static final int low = -128;
    static final int high; // high = 127;
    ...
}
```

캐시 값 검증
```java
public class WrapperExample1 {  
    public static void main(String[] args) {  
  
        final boolean isSameNewIntWrapper = isSameNewIntWrapper();  
        final boolean isSameLiteralIntWrapper = isSameLiteralIntWrapper();  
  
        System.out.println("isSameNewIntWrapper = " + isSameNewIntWrapper);  
        System.out.println("isSameLiteralIntWrapper = " + isSameLiteralIntWrapper);  
    }  
  
    private static boolean isSameLiteralIntWrapper() {  
        final Integer int1 = 10;  
        final Integer int2 = 10;  
  
        return int1 == int2;  
    }  
  
    private static boolean isSameNewIntWrapper() {  
        final Integer int1 = new Integer(10);  
        final Integer int2 = new Integer(10);  
  
        return int1 == int2;  
    }  
}

--- 실행 결과 ---
isSameNewIntWrapper = false
isSameLiteralIntWrapper = true
```


# 래퍼 클래스 - 자바 래퍼 클래스
- 박싱: 기본형을 래퍼 클래스로 변경하는 것
	- Wrapper.valueOf()
- 언박싱: 래퍼 클래스를 기본형으로 변경하는 것
	- Wrapper.intValue()


# 래퍼 클래스 - 오토 박싱
- 박싱, 언박싱을 하기 위한 별도의 변환없이도 기본형 <-> 래퍼 클래스간의 변환에 용이하게 하는 기능


# 래퍼 클래스 - 주요 메서드와 성능
parseInt vs valueOf
- parseInt -> 래퍼 타입을 반환
- valueOf  -> 기본형을 반환
```java
public static Integer valueOf(String s) throws NumberFormatException {  
    return Integer.valueOf(parseInt(s, 10));  
}
```

```java
public static int parseInt(String s) throws NumberFormatException {  
    return parseInt(s,10);  
}
```

**예시**
```java
final Integer i2 = Integer.valueOf(10);  
final int intValue = Integer.parseInt("10");
```


**성능 차이**
```java
final int loop = 1_000_000_000;  
  
// primitive type  
long sumPrimitive = 0;  
long start = System.currentTimeMillis();  
for (int i = 0; i < loop; i++) {  
    sumPrimitive += i;  
}  
long end = System.currentTimeMillis();  
System.out.println("sumPrimitive = " + sumPrimitive + ", time = " + (end - start) + " ms");  
  
// wrapper type  
Long sumWrapper = 0L;  
start = System.currentTimeMillis();  
for (int i = 0; i < loop; i++) {  
    sumWrapper += i;  
}  
end = System.currentTimeMillis();  
System.out.println("sumWrapper = " + sumWrapper + ", time = " + (end - start) + " ms");

--- 실행 시간 ---
sumPrimitive = 499999999500000000, time = 297 ms
sumWrapper = 499999999500000000, time = 1107 ms
```
- 기본형
	- 기본형은 메모리에서 타입의 크기만 공간을 차지하게 된다. 따라서 int는 보통 4바이트의 메모리를 사용한다.
- 참조형
	- 래퍼클래스의 인스턴스는 내부에 기본형의 값뿐만 아니라 객체 자체를 다루기 위한 객체 메타데이터 등을 포함하므로 더 많은 메모리를 사용한다. 자바 버전과 시스템마다 다르지만 대략 8~16바이트의 메모리를 추가로 사용한다.

> 유지보수 VS 최적화
> 유지보수와 최적화를 고려해야 하는 상황이라면 대부분의 경우 유지보수 하기 좋은 코드를 먼저 고민해야 한다.
> 
> **토론 주제**
> 이러한 관점에서 OneToMany VS 쿼리 +1


# Class 클래스
Class 클래스는 클래스의 정보(메타데이터)를 다루는데 사용한다.

Class 클래스의 주요 기능
- 타입 정보 얻기: 클래스의 이름, 인터페이스, 접근 제한자 등과 같은 정보를 조회 가능
- 리플렉션: 클래스에 정의된 메서드, 필드, 생성자 등을 조회하고, 이 값들로 객체 인스턴스를 생성하거나 메서드 호출하는 등의 작업이 가능
- 동적 로딩과 생성: Class.forName()을 사용해서 클래스를 동적으로 로드하고, newInstance() 메서드를 통해 새로운 인스턴스를 생성할 수 있음
- 애너테이션 처리: 클래스에 적용된 애너테이션을 조회하고 처리하는 기능을 제공

**Class 클래스 조회**
```java
(1) final Class<String> clazz1 = String.class;  
(2) final Class<? extends String> clazz2 = new String().getClass();  
(3) final Class<?> clazz3 = Class.forName("java.lang.String");
```

**인스턴스 생성**
```java
public class ClassCreateMain {  
  
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {  
  
        final Class<Hello> helloClazz = Hello.class;  
        final Hello hello = helloClazz.getDeclaredConstructor().newInstance();  
          
        final String result = hello.hello();  
        System.out.println("result = " + result);  
    }  
  
}  
  
class Hello {  
  
    public String hello() {  
        return "Hello";  
    }  
}
```
파라미터를 받아서 인스턴스를 생성하면 동적으로 인스턴스를 생성할 수 있음

**리플렉션 - reflection**
Class를 사용하면 클래스의 메타 정보를 기반으로 클래스에 정의된 메서드, 필드, 생성자등을 조회할 수 있고, 이를 통해 객체 인스턴스를 생성해서 메서드 호출까지도 가능하다. 이러한 작업을 리플렉션이라고 한다.


# System 클래스
```java
System.getenv()        // 환경 변수 읽기
System.getPriperties() // 시스템 속성 읽기
System.exit(0)         // 프로그램 종료
System.in / System.out // 표준 입력, 표준 출력
```




# Math, Random 클래스
소수점 정밀하게 다루어야 한다면 -> BigDecimal
- 부동소수점
- 고정소수점

### 씨드 - Seed
Random 클래스는 씨드(Seed)값을 사용해서 랜덤 값을 구한다. 
만약 씨드 값이 동일하다면 항상 같은 결과를 출력한다.
```java
final Random random = new Random();

--------------------------------

public Random() {  
    this(seedUniquifier() ^ System.nanoTime());  
}
```
- new Random(): 생성자 파라미터에 아무런 값이 전달되지 않으면 여러 알고리즘을 섞어서 씨드값을 생성
- new Random(int seed): 생성자 파라미터에 값을 전달하면 씨드 값이 고정되어 동일한 결과를 전달
	- 테스트 코드에서 같은 결과를 검증할 수 있다


-> Random 클래스는 항상 랜덤이 아니다 ???

-> 정수 오버플로우/언더풀로우
-> 실수 오버플로우/언더풀로우


# 문제와 풀이1, 문제와 풀이 2

### 우아한테크코스 - 로또 미션
https://github.com/woowacourse/java-lotto-precourse


### NullPointException
**예시 1**
```java
Map<String, Integer> map = Map.of("key", 10);  
  
Integer integer1 = map.get("key");  
System.out.println("integer1 = " + integer1);  
  
int i1 = map.get("keyy");  
System.out.println("i1 = " + i1);
```

```
integer1 = 10
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.get(Object)" is null
	at lang.wrapper.WrapperNullPointException.main(WrapperNullPointException.java:13)

```

예시 2
```java
final String str1 = "str";  
final String str2 = null;  
  
System.out.println(str1.equals(str2));  
System.out.println(str2.equals(str1));
```

```
false
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str2" is null
	at lang.wrapper.WrapperNullPointExceptionExample2.main(WrapperNullPointExceptionExample2.java:13)
```


### Optional<\T>
- [\[Java\]\[Optional\] Optional의 위험 및 사용 가이드](https://yonghwankim-dev.tistory.com/567)
- [Item 55. 옵셔널 반환은 신중히 하라](https://jaehun2841.github.io/2019/02/24/effective-java-item55/#Optional-%EB%A9%94%EC%84%9C%EB%93%9C)