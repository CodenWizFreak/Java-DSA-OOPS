# StringBuffer Class in Java
- Mutable Sequence of Characters
- If a string is changed in StringBuffer, a separate new object isn't created in Heap, unlike String. So the memory stays clean and is useful for large string related processes.

### Advantages: 
- Mutable
- Efficient
- Thread Safe (If a thread t1 is working on a process, another thread t2 won't work on the same process simultaneously)

(Thread is an independent path of execution inside a program)

(StringBuilder is not thread safe, hence while working with multiple threads, we use StringBuffer)

Read more from: https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html

### Some Methods:

```java
StringBuffer sb = new StringBuffer();
// → Default capacity is 16
StringBuffer sb3 = new StringBuffer(30);
StringBuffer sb2 = new StringBuffer("Andy");
// → String can also be written inside

sb.append("WeMakeDevs");
// → "WeMakeDevs"

sb.insert(2, " Rahul ");
// → "We Rahul MakeDevs"

sb.append(" is nice!");
// → "We Rahul MakeDevs is nice!"

sb.replace(1, 5, "Andy");
// → "WAndyeMakeDevs is nice!"

sb.delete(1, 5);
// → "WeMakeDevs is nice!"

sb.reverse();
// → "!ecin si sveDekaMeW"

System.out.println("sb: " + sb);

System.out.println("sb.capacity(): " + sb.capacity());   // → 16
System.out.println("sb3.capacity(): " + sb3.capacity()); // → 30

```

```java

String st = " H e l l o H o w d y ";
st = st.replaceAll("\\s", "");
System.out.println(st); // → "HelloHowdy"
```
```java

import java.text.DecimalFormat;

DecimalFormat df = new DecimalFormat("00.0000");
System.out.println(df.format(7.29)); // → "07.2900"


```
