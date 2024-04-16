# 섹션1. Object 클래스

---

# java.lang 패키지 소개
- 자바가 기본적으로 제공하는 라이브러리
- 모든 자바 애플리케이션에 자동으로 임포트됨

대표적인 클래스들
- Object: 모든 자바 객체의 부모 클래스
- String: 문자열
- Integer, Long: 래퍼 타입
- Class: 클래스 메타 정보
- System: 시스템과 관련된 기능

# Object 클래스
- 자바에서 모든 최상위 클래스는 항상 Object 클래스
    - `extends Object`를 한 것과 동일
- Object 클래스를 상속받는 이유는 무엇일까 (= 최상위 클래스인 이유)
    - -> 공통 기능 제공 ![](https://i.imgur.com/dXCLPfA.png)
    - -> 다형성의 기본 구현
        - 타입이 다른 객체들을 어딘가에 보관해야 한다면 `Object`에 담으면 됨
        - 즉, Object는 어떤 타입이든 저장 가능함

```java
public class Parent {  
    public void parentMethod() {  
        System.out.println("Parent.parentMethod");  
    }  
}  
  
class Child extends Parent {  
    public void childMethod() {  
        System.out.println("Child.childMethod");  
    }  
}
```
![](https://i.imgur.com/lMAnuKH.png)

**상속과 생성**
- 상속을 받은 클래스들은 메모리상에 올라간다
  ![](https://i.imgur.com/YQwyo5k.png)

**증명**
```java
public class Parent {  
    public Parent() {  
        System.out.println("Parent.Parent()");  
    }  
  
    public void parentMethod() {  
        System.out.println("Parent.parentMethod");  
    }  
}  
  
class Child extends Parent {  
    public Child() {  
        System.out.println("Child.Child()");  
    }  
  
    public void childMethod() {  
        System.out.println("Child.childMethod");  
    }  
}
```

```java
public static void main(String[] args) {  
    System.out.println("### Before new Instance ###");  
    final Child child = new Child();  
    System.out.println("### After new Instance ###");  
    child.childMethod();  
    child.parentMethod();  
  
    final String string = child.toString(); // 객체에 대한 정보  
    System.out.println("string = " + string);  
}

------- 실행 결과 -------
### Before new Instance ###
Parent.Parent()
Child.Child()
### After new Instance ###
Child.childMethod
Parent.parentMethod
string = lang.Child@452b3a41
```


# Object 다형성
![](https://i.imgur.com/QtSYImd.png)

**다형성의 한계**
- 다운캐스팅 필요
```java
public class ObjectPolyExample1 {  
  
    public static void main(String[] args) {  
        final Dog dog = new Dog();  
        final Car car = new Car();  
  
        action(dog);  
        action(car);  
    }  
  
    private static void action(final Object obj) {  
  
        // obj.sound(); -> Object는 해당 메서드가 없음  
        // obj.move();  -> Object는 해당 메서드가 없음  
  
        if (obj instanceof Dog) {  
            final Dog dog = (Dog) obj;  
            dog.sound();  
        } else if (obj instanceof Car car) {  
		    car.move();  
		}
    }  
}
```

- 또는 리플렉션을 활용한 동적으로 메서드 호출
```java
private static void actionV2(final Object obj) {  
  
    final Class<?> clazz = obj.getClass();  
  
    try {  
        if(clazz == Dog.class) {  
            clazz.getMethod("sound").invoke(obj);  
        } else if (clazz == Car.class) {  
            clazz.getMethod("move").invoke(obj);  
        }  
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {  
        e.printStackTrace();  
    }  
}
```


# Object 배열


# toString()
- 객체의 정보를 문자열 형태로 제공하는 기능
- 모든 클래스는 Object 클래스에 정의된 기능을 상속받으므로 어떤 인스턴스이든 사용 가능함
- System.out.println은 내부적으로 toString을 호출한다
    - [println보다 logger를 사용해야 하는 이유](https://liltdevs.tistory.com/180)
- 형태
    - 패키지를 포함한 클래스명 + '@' + 16진수(객체의 참조값(해시코드))
```java
public String toString() {  
    return getClass().getName() + "@" + Integer.toHexString(hashCode());  
}
```

```java
public class ToStringMain1 {  
  
    public static void main(String[] args) {  
        final Object obj = new Object();  
  
        final String name = obj.getClass().getName();  
        final int hashCode = obj.hashCode();  
        final String hex = Integer.toHexString(hashCode);  
  
        System.out.println("name = " + name);  
        System.out.println("hashCode = " + hashCode);  
        System.out.println("hex = " + hex);  
  
        System.out.println("===== toString =====");  
        System.out.println(name + "@" + hex);  
        System.out.println(obj.toString());  
    }  
}

----- 실행 결과 -----
name = java.lang.Object
hashCode = 168423058
hex = a09ee92
===== toString =====
java.lang.Object@a09ee92
java.lang.Object@a09ee92
```

만약 타입 계층을 이룬다면 오버라이딩된 toString이 실행된다.
```java
// Object.class
public String toString() {  
    return getClass().getName() + "@" + Integer.toHexString(hashCode());  
}

// Dog.class (extends Object)
@Override  
public String toString() {  
    return "dogName = " + dogName + ", age = " + age;  
}
```


## Object와 OCP

만약 Object가 없었더라면?
-> 다시 말해, 구체적인 것에 의존
```java
PrintStream#println * 1,2,3,4,5,...
public void println(Red car) { ... }
public void println(Orange orange) { ... }
public void println(Yellow yellow) { ... }
public void println(Green car) { ... }
public void println(Blue car) { ... }
...
```

우리는 Object 덕분에
-> 추상적인 것에 의존
-> 즉, 다형적 참조가 가능해짐
```java
PrintStream#println
public void println(Object x) { ... }
public void println(boolean x) { ... }
```

![](https://i.imgur.com/nlFtyCg.png)
따라서, 모든 객체는 Object 클래스를 상속받아 기능을 물려받기 때문에 모든 객체 정보를 Object.toString()을 통해 출력할 수 있게 된다.

### 정적 의존 관계와 동적 의존 관계
- 정적 의존 관계: 컴파일 타임에 결정 -> 오버라이딩
- 동적 의존 관계: 런타임에 결정        -> 오버로딩

> 관련 키워드
> - 전략 패턴, 템플릿 패턴
> - 정적 바인딩, 동적 바인딩(컴포지션)


## equals() - 1. 동일성과 동등성
- 동일성(\==): 객체의 참조(메모리 주소)가 동일한지 확인
    - 원시형 타입간의 비교는 값을 비교
    - 참조 타입간의 비교는 주소값을 비교
- 동등성(equals): 객체의 값이 동일한지 확인

**equals 메서드의 규칙**
- 반사성
- 대칭성
- 추이성
- 일관성
- null에 대한 비교


**Object#equals**
```java
public boolean equals(Object obj) {  
    return (this == obj);  
}
```

- Hash 값을 사용하는 Collection
    - HashSet
    - HashMap
    - HashTable


--

#### 예제편 - Hash Collection
#### 실전편 - Object Equality


**예제편**
- 객체가 논리적으로 동일한지에 대한 비교를 다음의 프로세스를 통한다.
  ![](https://i.imgur.com/87BPHDH.png)

**예시 1) equals 오버라이딩 X**
```java
// given
class Box {  
    private final String value;  
  
    public Box(final String value) {  
        this.value = value;  
    }  
}
```
```java
Set<Object> set = new HashSet<>();  
set.add(new Box("A"));  
set.add(new Box("A"));  
System.out.println("set = " + set);

----- 결과 -----
set = [lang.object.equals.Box@30f39991, lang.object.equals.Box@452b3a41]
```

**예시 2) equals 오버라이딩 O**
```java
// given
class Box {  
    private final String value;  
  
    public Box(final String value) {  
        this.value = value;  
    }  
  
    @Override  
    public boolean equals(final Object o) {  
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;  
        final Box box = (Box) o;  
        return Objects.equals(value, box.value);  
    }  
}
```
```java
Set<Object> set = new HashSet<>();  
set.add(new Box("A"));  
set.add(new Box("A"));  
System.out.println("set = " + set);

----- 결과 -----
set = [lang.object.equals.Box@30f39991, lang.object.equals.Box@452b3a41]
```

예시3) equals, hashCode 오버라이딩 O
```java
// given
class Box {  
    private final String value;  
  
    public Box(final String value) {  
        this.value = value;  
    }  
  
    @Override  
    public boolean equals(final Object o) {  
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;  
        final Box box = (Box) o;  
        return Objects.equals(value, box.value);  
    }  
  
    @Override  
    public int hashCode() {  
        return Objects.hash(value);  
    }  
}
```
```java
Set<Object> set = new HashSet<>();  
set.add(new Box("A"));  
set.add(new Box("A"));  
System.out.println("set = " + set);

----- 결과 -----
set = [lang.object.equals.Box@60]
```


**실전편**
- [1:N, N:1 중간 객체](https://github.com/cround-team/cround-server/blob/dev/src/main/java/croundteam/cround/bookmark/domain/BoardBookmark.java)
- [@OneToMany 객체](https://github.com/cround-team/cround-server/blob/dev/src/main/java/croundteam/cround/board/domain/BoardBookmarks.java)
