# 섹션3. String 클래스

# String 클래스 - 기본

문자를 다루는 방법
- char[]
- String 클래스
```java
final char[] chars = new char[]{'a', 'b', 'c'};    
final String str = "abc";
```

String 클래스를 생성하는 방법
- 문자열 리터럴을 통한 생성
- new 키워드를 통한 생성
```java
final String str1 = "hello";  
final String str2 = new String("hello");  
  
System.out.println("str1 = " + str1); --> str1 = hello  
System.out.println("str2 = " + str2); --> str2 = hello
```

> Q. 객체 생성은 new 키워드를 통해 생성해야 하는 게 아닌가?
> A. 문자열 리터럴을 사용하더라도 자바 언어는 `new String()`으로 변환한다.
> -> 실제로는 문자열 풀을 이용


### String 클래스의 구조
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc {

	// private final char[] value; // java 9 이전
	private final byte[] value;    // java 9 이후
	-> 해당 필드에 실제 문자열 값이 보관된다.

	...

	public String concat(String str) {...}
	...
}
```
- 직접 다루기 불편한 char[]를 내부에 감추고 값을 다루기 편한 기능을 만들어 제공
- 자바 9 이후 String 클래스 변경 사항
	- 자바 9 부터 String 클래스에서 char[] 대신에 byte[] 을 사용함
	- -> 자바에서 char는 2byte를 차지하지만, 영문/숫자는 1byte로 표현 가능함
	- -> 그래서 단순 영문/숫자는 1byte(encoding: Latin-1)를 사용하고, 그 외에는 2byte(encoding: UTF-8)를 사용
	- -> 따라서 메모리를 더 효율적으로 사용할 수 있게 변경됨

> 오버플로우와 언더플로우
> - 정수
> - 실수


### String 클래스와 참조형
자바에서 참조형 변수는 실제 값이 아닌 참조값을 가진다. 따라서 원칙적으로 더하기 연산을 사용할 수 없다.
원래라면 `concat()`과 같은 메서드로 문자열을 더해야 하지만, 문자열 연산은 자주 일어나서 언어에서 더하기 연산을 제공한다.
```java
final String str1 = "hello";  
final String str2 = " world";  
final String result1 = str1.concat(str2);  
final String result2 = str1 + str2;  
System.out.println("result1 = " + result1); -> result1 = hello world
  
System.out.println("result2 = " + result2); -> result2 = hello world
```


# String 클래스 - 비교
String 클래스를 비교할 때에는 항상 `equals()` 비교를 해야 한다.
```java
final String str1 = new String("hello");  
final String str2 = new String("hello");  
  
System.out.println("str1 == str2: " + (str1 == str2));  
System.out.println("str1.equals(str2): " + str1.equals(str2));

---- 실행 결과 ----
str1 == str2: false
str1.equals(str2): true
```

String#equals
```java
public boolean equals(Object anObject) {  
    if (this == anObject) {  
        return true;  
    }  
    return (anObject instanceof String aString)  
            && (!COMPACT_STRINGS || this.coder == aString.coder)  
            && StringLatin1.equals(value, aString.value);  
}
```

--

그런데 리터럴로 만든 String 인스턴스를 동일성 연산을 한다면?
```java
final String str1 = new String("hello");  
final String str2 = new String("hello");  
System.out.println("str1 == str2: " + (str1 == str2));  
System.out.println("str1.equals(str2): " + str1.equals(str2));  
  
final String str3 = "hello";  
final String str4 = "hello";  
System.out.println("str3 == str4: " + (str3 == str4));  
System.out.println("str3.equals(str4): " + str3.equals(str4));

--- 실행 결과 ---
str1 == str2: false
str1.equals(str2): true
str3 == str4: true
str3.equals(str4): true
```

![](https://i.imgur.com/AGQRkfp.png)
- 문자열 리터럴을 통해 문자열 인스턴스가 생성되면 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다
- 자바가 실행되는 시점에 문자열 리터럴이 존재하면 문자열 풀에 String 인스턴스를 만들게 되는데 만약 다른 곳에서 동일한 문자열 리터럴이 있다면 만들지 않는다
- 만약 문자열 풀에 생성하고자 하는 String 인스턴스가 존재한다면 만들어진 String 인스턴스 사용한다(=재사용)
-> 그 결과, 메모리 사용을 줄이고 문자열 생성 비용을 아낄 수 있으므로 성능을 최적화 가능하다.
-> 따라서 위 예시에서 문자열 리터럴로 만든 두 인스턴스가 동일했던 것임
-> 참고로 문자열 풀은 힙 영역을 사용하고, 문자를 찾을 때에는 해시 알고리즘을 사용하기 때문에 String 인스턴스를 찾을 수 있다.

> new와 리터럴로 생성했을 때 동등 비교는 다르므로 되도록이면 리터럴을 사용하자


# String 클래스 - 불변 객체
String은 불변 객체로 한 번 생성하고나면 값을 변경할 수 없다.
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc {

	private final byte[] value;
	...
```

따라서 concat()과 같은 메서드를 통해 기존 값을 변경하는 경우 새로운 결과를 만들어서 반환한다.
```java
public String concat(String str) {...}
```

 > Q. String은 왜 불변 객체로 설계되었을까
 > A. 하나의 참조값을 여러 참조변수에서 참조한다고 가정해보자. 그때 한 곳에서 값이 변경되면 관련된 모든 참조변수에 영향을 주게 된다. 따라서 이러한 문제를 막고자 불변으로 설계됨


# String 클래스 - 주요 메서드1, 2

isEmpty(), isBlank vs StringUtils.isEmpty()
```java
NPE(NullPointException)

null.isEmpty()
null.isBlank()
```

CharSequence는 String, StringBuilder의 상위 클래스로, 문자열을 처리하는 객체를 파라미터로 받을 수 있음
![](https://i.imgur.com/o0VMGAR.png)

### replace vs replaceAll
-> [블로그](https://yeonyeon.tistory.com/294)


# StringBuilder - 가변 String
String 클래스는 불변이라는 장점도 있는 반면, 문자열을 더하거나 변경할 때마다 새로운 인스턴스가 생성되게 된다.
그에 따라 더 자주 GC가 일어나고, CPU, 메모리를 더 많이 사용한다.

이처럼 문자열의 연산이 잦다면 가변 문자열 클래스인 StringBuilder를 사용하면 효율적임
```java
public final class StringBuilder extends AbstractStringBuilder implements Appendable, java.io.Serializable, Comparable<StringBuilder>, CharSequence {

	byte[] value; // AbstractStringBuilder의 필드를 상속
	
```


# String 최적화
### 자바의 String 최적화

- 문자열 리터럴 최적화
자바 컴파일러는 문자열 리터럴 더하기 연산을 자동으로 합쳐준다. 따라서 런타임에 연산을 수행하지 않아 성능을 최적화 함
```java
String helloWorld = "Hello, " + "World!"; // 컴파일전
String helloWorld = "Hello, World!";      // 컴파일후
```

- String 변수 최적화
문자열 변수의 경우 어떠한 값이 들어있는지 컴파일 시점에 모르는데 컴파일러가 최적화를 함
자바 9부터는 StringConcatFactory를 사용해서 최적화를 수행함
```java
String result = str1 + str2;
String result = new StringBuildert().append(str1).append(str2).toString();
```

### String 최적화가 어려운 경우
다음과 같이 문자열을 루프안에서 문자열을 더하는 경우 문자열 최적화가 어렵다
```java
final long startTime = System.currentTimeMillis();  
String result = "";  
for (int i = 0; i < 100_000; i++) {  
    result += "hello";  
}  
final long endTime = System.currentTimeMillis();
-> execute time = 703ms
```

```java
final long startTime = System.currentTimeMillis();  
final StringBuilder sb = new StringBuilder();  
for (int i = 0; i < 100_000; i++) {  
    sb.append("hello");  
}  
final long endTime = System.currentTimeMillis();
-> execute time = 2ms
```

StringBuilder를 사용하기 적절한 경우
- 반복문에서 문자열 연산을 하는 경우
- 조건문을 통해 동적으로 문자열을 조합하는 경우
- 복잡한 문자열의 특정 부분을 변경하는 경우
- 대용량 문자열을 다루는 경우
```java
StringBuilder query = new StringBuilder();
query.append("SELECT * FROM users");

boolean hasCondition = false;

if (username != null) {
    query.append(hasCondition ? " AND " : " WHERE ");
    query.append("username = '").append(username).append("'");
    hasCondition = true;
}

if (email != null) {
    query.append(hasCondition ? " AND " : " WHERE ");
    query.append("email = '").append(email).append("'");
    hasCondition = true;
}

// something more condition..

System.out.println(query.toString());
```

**StringBuilder vs StringBuffer**
기능 자체는 완벽하게 동일하나 StringBuffer는 내부에 동기화가 되어 있어서 멀티 스레드 환경에 안전하지만 동기화를 유지하기 위한 오버헤드로 인해 성능이 느리다
```java
@Override  
public synchronized StringBuffer append(Object obj) {  
    toStringCache = null;  
    super.append(String.valueOf(obj));  
    return this;  
}
```

# 메서드 체인닝 - Method Chaining
인스턴스 자신의 참조값을 계속해서 반환하여 반환된 참조값을 사용해 메서드 호출을 여러번 나가게 하는 것
```
builder().add(1).add(1).add(1).add(1)...
```

```java
public StringBuilder append(String str) {  
    super.append(str);  
    return this;  
}
```



> todo: 
> call by reference vs call by value
 




