package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/*
 * Comparator를 사용한 학생 정보 배열 정렬 및 이진 탐색 구현
 * 
 * 다음과 같은 정보를 저장하는 Student 클래스를 정의하고, 
 * 고정된 학생 배열을 Comparator를 사용해 학번(sid) 기준으로 정렬한 뒤,
 * 탐색 대상 학생 객체 배열에 대해 Arrays.binarySearch()를 사용하여 
 * 해당 학번을 가진 학생이 존재하는지 판단하는 프로그램을 작성하시오.
 * 
 * 구현 조건
Student 클래스는 다음 멤버를 포함해야 한다:

String sid; (학번)

String sname; (이름)

String dept; (학과)

생성자: Student(String sid, String sname, String dept)

toString() 메서드: "S002, 철수, Physics" 형식 반환

Student 클래스는 Comparable을 구현하지 않음

정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식 또는 익명 클래스로 구현할 것

기준: sid 오름차순

메인 메서드에서는 다음 학생 배열을 선언한다:

Student[] students = {
    new Student("S001", "영희", "Math"),
    new Student("S003", "민수", "Computer"),
    new Student("S002", "철수", "Physics"),
    new Student("S005", "지영", "Biology"),
    new Student("S004", "준호", "Chemistry")
};

show(Student[] arr) 메서드를 작성하여 확장형 for문으로 배열 내용을 출력한다.
출력 시 "=== 정렬 전 학생 목록 ==="을 먼저 출력한다.

위 배열을 Arrays.sort(배열, comparator)로 정렬한다.

다음 탐색 대상 배열을 정의하고, 확장형 for문으로 각 항목에 대해 Arrays.binarySearch(배열, key, comparator)로 탐색한다.

Student[] targets = {
    new Student("S002", "철수", "Physics"),
    new Student("S006", "홍길동", "Law"),
    new Student("S004", "준호", "Chemistry")
};

탐색 결과는 다음과 같이 출력한다:

"찾은 학생: S002, 철수, Physics"

"학번 S006인 학생은 존재하지 않습니다."

=== 정렬 전 학생 목록 ===
S001, 영희, Math
S003, 민수, Computer
S002, 철수, Physics
S005, 지영, Biology
S004, 준호, Chemistry

=== 이진 탐색 결과 ===
찾은 학생: S002, 철수, Physics
학번 S006인 학생은 존재하지 않습니다.
찾은 학생: S004, 준호, Chemistry

 * 
 */

class Student2 {
    private String sid;  // 학번
    private String sname; // 이름
    private String dept;  // 학과

    public Student2(String sid, String sname, String dept) { //생성자
        this.sid = sid;
        this.sname = sname;
        this.dept = dept;
    }
    
    public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

    public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
    public String toString() {
        return sid + ", " + sname + ", " + dept;
    }

	@Override
	public int hashCode() {
		return Objects.hash(sid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2 other = (Student2) obj;
		return Objects.equals(sid, other.sid);
	}
	
}

public class Task03_10_객체comparator_sook {


	public static void main(String[] args) {
		Student2[] students = {
		    new Student2("S001", "영희", "Math"),
		    new Student2("S003", "민수", "Computer"),
		    new Student2("S002", "철수", "Physics"),
		    new Student2("S005", "지영", "Biology"),
		    new Student2("S004", "준호", "Chemistry")
		};
		
		System.out.println("=== 정렬 전 학생 목록 ===");
        show(students);

        // Comparator 람다식으로 sid 기준 정렬
        Comparator<Student2> sidComparator = (a, b) -> a.getSid().compareTo(b.getSid());
        Arrays.sort(students, sidComparator);

        System.out.println("\n=== 정렬 후 학생 목록 ===");
        show(students);	
		
        // 탐색 대상
        Student2[] targets = {
            new Student2("S002", "철수", "Physics"),
            new Student2("S006", "홍길동", "Law"),
            new Student2("S004", "준호", "Chemistry")
        };

        System.out.println("\n=== 이진 탐색 결과 ===");

        for (Student2 key : targets) {
            int idx = Arrays.binarySearch(students, key, sidComparator);
            if (idx >= 0) {
                System.out.println("찾은 학생: " + students[idx]);
            } else {
                System.out.println("학번 " + key.getSid() + "인 학생은 존재하지 않습니다.");
            }
        }
	}

	private static void show(Student2[] arr) {
		for (Student2 s : arr) {
            System.out.println(s);
        }
		
	}

}
