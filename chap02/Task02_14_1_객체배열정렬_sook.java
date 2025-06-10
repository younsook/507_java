package chap02;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
		
	}

	@Override
	public int compareTo(PhyscData2 o) {
		return this.name.compareTo(o.name);
	}
	

}

public class Task02_14_1_객체배열정렬_sook {

	static void showData(String msg, PhyscData2[]arr) {
		System.out.println(msg);
		for (PhyscData2 pd: arr) {
			System.out.printf("%-8s%3d%5.1f\n", pd.name, pd.height, pd.vision);
		}
		System.out.println();
	}
	
	private static void sortData(PhyscData2[] arr) {
		for(int i =1; i<arr.length;i++) {
			PhyscData2 temp = arr[i];
			int j;
			for (j=i; j>0 && temp.compareTo(arr[j-1]) < 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
		
	}
	
	private static int binarySearch(PhyscData2[] arr, String key) {
		int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comp = arr[mid].name.compareTo(key);
            if (comp == 0)
                return mid;
            else if (comp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
	}
	
	private static PhyscData2[] insertObject(PhyscData2[] arr, PhyscData2 newObj) {
		PhyscData2[] newArr = new PhyscData2[arr.length + 1];
        int i = 0, j = 0;
        boolean inserted = false;

        while (i < arr.length) {
            if (!inserted && newObj.compareTo(arr[i]) < 0) {
                newArr[j++] = newObj;
                inserted = true;
            } else {
                newArr[j++] = arr[i++];
            }
        }
        if (!inserted) {
            newArr[j] = newObj;
        }
        return newArr;
    }
	
	

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);

		//Arrays.sort(data);  // Comparable 구현했으므로 바로 정렬 가능 
		Arrays.sort(data, (a, b) -> a.name.compareTo(b.name));
		showData("Arrays.sort() 실행후", data);
		
		int resultIndex = binarySearch(data, "이길동");
		if (resultIndex >= 0)
			System.out.println("이길동 존재하면 인덱스 = "+resultIndex);
		else
			System.out.println("이길동 존재하지 않는다");
		
		PhyscData2[] newData= insertObject(data, new PhyscData2("소주다", 179, 1.5));
		//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
	}

	

	
	
	

}