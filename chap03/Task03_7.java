package chap03;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 교재 123~129 페이지 참조하여 구현(목표) 구현하기.
 * 
 * 3장 과제2 : 객체 배열 정렬/검색 - 람다식사용
 * 
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator(); //myComparator는 Comparable 메소드를 갖고있다.
* 
* Arrays.sort(array, myComparator);
* Collections.sort(list, new MyComparator());
*/

class Fruit4 {	
	

	String name;
	int price;
	String expire;
	
	public Fruit4(String name, int price, String expire) {
		// 생성자
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	public int getPrice() {
		// Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()) 로 가격 정렬을 시도한다.
		return this.price;
	}
	@Override
	public String toString() {
		return "Fruit4 [name=" + name + ", price=" + price + ", expire=" + expire + "]";
	}

}


//교재 123~129 페이지 참조하여 구현(목표)
class FruitName implements Comparator<Fruit4>{
	@Override
	public int compare(Fruit4 f1, Fruit4 f2) {
		return f1.name.compareTo(f2.name); //인터페이스를 구현한 익명클래스 
	}
}
class FruitPrice implements Comparator<Fruit4>{
	@Override
	public int compare(Fruit4 f1, Fruit4 f2) {
		return f1.price-f2.price; //인터페이스를 구현한 익명클래스 
	}
}
//교재 123~129 페이지 참조하여 구현(목표)



public class Task03_7 {

	private static void sortData(Fruit4[] arr, Comparator<Fruit4> cc_price) {}
	
	private static void showData(String str, Fruit4[] arr) {
		System.out.println(str);
		for(Fruit4 x : arr) {
			System.out.println(x+" ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {

		Fruit4[] arr = {new Fruit4("사과", 200, "2023-5-8"), 
				new Fruit4("감", 500, "2023-6-8"),
				new Fruit4("대추", 200, "2023-7-8"), 
				new Fruit4("복숭아", 50, "2023-5-18"), 
				new Fruit4("수박", 880, "2023-5-28"),
				new Fruit4("산딸기", 10, "2023-9-8") };
		
		
		Arrays.sort(arr, new Comparator<Fruit4>(){
			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				return f1.name.compareTo(f2.name); //인터페이스를 구현한 익명클래스 
			}
		});
		Arrays.sort(arr, (f1, f2)-> f1.name.compareTo(f2.name)); //람다식
			
		
		System.out.println("\n정렬전 객체 배열: ");
		showData("정렬전 객체", arr);
		
		FruitName cc = new FruitName();
		System.out.println("\n comparator cc 객체를 사용:: ");
		Arrays.sort(arr, cc);
		showData("Arrays.sort(arr, cc) Name 정렬 후", arr);
		
		sortData(arr, new FruitPrice());
		showData("Arrays.sort(arr, cc)  Price 실행후", arr);
		
		// 람다식은 익명클래스 + 익명 객체이다
		Comparator<Fruit4> cc_expire = (a, b) -> a.expire.compareTo(b.expire);
		Arrays.sort(arr, cc_expire); // 람다식으로 만들어진 객체를 사용
		showData("람다식 변수 cc_expire을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);
		
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); 
		showData("람다식: (a, b) -> a.getPrice() - b.getPrice()을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);

		System.out.println("\n익명클래스 객체로 정렬(가격)후 객체 배열: ");
		Arrays.sort(arr, new Comparator<Fruit4>() {
			@Override
			public int compare(Fruit4 a1, Fruit4 a2) {
				return a1.name.compareTo(a2.name);
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData("name comparator - 익명 객체를 사용한 정렬:", arr);
		
		//익명 클래스를 사용한 comparator 객체
		Comparator<Fruit4> cc_name = new Comparator<Fruit4>() {// 익명클래스 사용

			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				// TODO Auto-generated method stub
				return (f1.name.compareTo(f2.name));
			}

		};
		Comparator<Fruit4> cc_price = new Comparator<Fruit4>() {

			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				return f1.getPrice() - f2.getPrice();
			}// 익명클래스 사용

		};

		Fruit4 newFruit4 = new Fruit4("수박", 880, "2023-5-18");
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		int result3Index = Arrays.binarySearch(arr, newFruit4, cc_name);
		System.out.println("\nArrays.binarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);
		
		result3Index = binarySearch(arr, newFruit4, cc_price);//교재 113 binSearch() 함수를 고쳐서 구현 
		System.out.println("\nbinarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData("comparator를 사용한 정렬후:", arr);	
	}

	private static int binarySearch(Fruit4[] arr, Fruit4 newFruit4, Comparator<Fruit4> cc_price) {
		// 내가 직접 만든 binarySearch()로 찾기
		//객체 배열 탐색
		 int left = 0;
		    int right = arr.length - 1;

		    while (left <= right) {
		        int mid = (left + right) / 2;
		        int cmp = cc_price.compare(arr[mid], newFruit4);

		        if (cmp == 0) {
		            return mid;
		        } else if (cmp < 0) {
		            left = mid + 1;
		        } else {
		            right = mid - 1;
		        }
		    }
		    return -1;
	}

	
}
