package chap06;
/*
 * 6장 구현과제3
 */

// 선형다항식 -> 순서가 있음(계수, 지수)
class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  
        this.exp = exp; 
    }
    
    @Override
    public int compareTo(Polynomial3 o) {
    	//자바에서 사용가능한것을 활용하기.
    	return Integer.compare(o.exp, this.exp);
    }

}
public class Task06_3_MergeSort다항식정렬_sook {

	//두 배열을 정렬할때 작은것부터 꺼내는것이 낫다.
	//MergeSort는 while 반복해야 빠르다.
		
		//for는 반복횟수를 알때 사용
		//while 횟수는 모르고 반복할꺼야. 끝나면 brake할꺼야. 
		// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
		static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
			 //body를 지우고 작성 훈련 연습이 도움이 된다 
			Polynomial3 temp[] = new Polynomial3[30];
			//구현코드
			int i = lefta;
			int j = leftb;
			int k=0;
			
			//1. 두 배열을 비교할것 
			while(i <= righta && j <= rightb) { //비교연산자
				if(a[i].compareTo(a[j]) <= 0) { //o a[j] , this a[i]
					temp[k++] = a[i++];
				} else {
					temp[k++] = a[j++];
				}			
			}
			
			//2. 남은 배열을 처리할것
			while (i <= righta) {
				temp[k++] = a[i++];
			}
			while (j <= rightb) {
				temp[k++] = a[j++];
			}
			
			//3. 복사
			for (i=0;i<k;i++) {
				a[lefta +i] = temp[i];
			}
		}

		// --- 퀵 정렬(비재귀 버전)---//
		static void MergeSort(Polynomial3[] a, int left, int right) {
			int mid = (left+right)/2;
			if (left == right) return;
			MergeSort(a, left, mid);
			MergeSort(a, mid+1, right);
			merge(a, left, mid, mid+1, right);
		}
		static void ShowPolynomial(String str, Polynomial3[] x, int count) {
			//str 변수는 다항식 이름으로 스트링이다
			//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
			//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
			int n = 0;
			if (count < 0)
				n = x.length;
			else
				n = count;
			//구현코드
			System.out.print(str);
			for(int i=0;i<n;i++) {
				if(i>0) {
					System.out.print(" + ");
				}
				if (x[i].exp ==0) {
					System.out.printf("%.1f ", x[i].coef);
				} else if (x[i].exp ==1) {
					System.out.printf("%.1f x ", x[i].coef);
				} else {
					System.out.printf("%.1f x ** %d ", x[i].coef, x[i].exp);
				}		
			}
			System.out.println();
		}
		
		static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
			//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다 
			int p=0,q=0,r=0;
			int terms = 0;
			//구현코드
			//for? while ? 횟수가 정해진것이 아님
			while (p <x.length && q < y.length) {
				if (x[p].exp > y[q].exp) {
					//항을 계산
					terms = addTerm(z,x[p], terms);
					p++;
				}else if (x[p].exp < y[q].exp) {
					//항을 계산
					terms = addTerm(z,y[q], terms);
					q++;
				}else {
					// 덧셈
					Polynomial3 sum = new Polynomial3(x[p].coef + y[q].coef, x[p].exp);
					terms = addTerm(z,sum, terms);
					p++;
					q++;
				}
			}
			//남은 항 추가
			while (p < x.length) {
				terms = addTerm(z, x[p], terms);
				p++;
			}
			while (q < y.length) {
				terms = addTerm(z, y[q], terms);
				q++;
			}
			return terms;
//			남은 항 추가는 “엣지 케이스에서 틀리지 않기 위한 안전장치”이자, 알고리즘 완전성을 보장하는 핵심 단계
			
		}
		
		static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
			//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
			//추가된 항의 수를 count하여 terms으로 리턴한다.
			//구현코드
			if(terms >= z.length) {
				System.out.println(("addTerm: z 배열 공간 부족!"));
				return terms;
			}
			
			for(int i=0; i<terms;i++) {
				if(z[i].exp == term.exp) {
					z[i].coef += term.coef;
					return terms;
					
				}
			}
			
			z[terms] = new Polynomial3(term.coef, term.exp);	
			return ++terms;
				
		}
		static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
			//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 
			//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
			int p=0,q=0,r=0;
			int terms = 0;
			//구현코드
			
			for(p=0; p < x.length; p++) {
				for(q=0; q < y.length; q++) {
					//x[p].coef : 다항식 x의 p번째 항의 계수
					//y[q].exp : y의 q번째 항의 지수
					Polynomial3 term = new Polynomial3(x[p].coef * y[q].coef, x[p].exp + y[q].exp); //계수 곱, 지수 합
					
					//z에 누적
					r = addTerm(z, term, terms);
					
					//r값을  terms 갱신
					terms = r;				
					
				}
			}
			
			return terms; //terms에 저장된 최종 항 개수
		}
		static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
			//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
			//다항식 계산 결과를 double로 리턴한다 
			double result = 0.0;
			//구현 코드
			for(int i=0; i< zTerms; i++) {
				result += z[i].coef * Math.pow(value, z[i].exp);
			}
			
			return result;
		}
		public static void main(String[] args) {
			Polynomial3[] x = {
			         new Polynomial3(1.5, 3), //new Polynomial3(계수, 지수);
			         new Polynomial3(2.5, 7),
			         new Polynomial3(3.3, 2),
			         new Polynomial3(4.0, 1),
			         new Polynomial3(2.2, 0),
			         new Polynomial3(3.1, 4),
			         new Polynomial3(3.8, 5),
			     };
			Polynomial3[] y = {
			         new Polynomial3(1.5, 1),
			         new Polynomial3(2.5, 2),
			         new Polynomial3(3.3, 3),
			         new Polynomial3(4.0, 0),
			         new Polynomial3(2.2, 4),
			         new Polynomial3(3.1, 5),
			         new Polynomial3(3.8, 6),
			     };
			int nx = x.length;


			ShowPolynomial("다항식 x = ", x, -1);
			ShowPolynomial("다항식 y = ", y, -1);
			MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
			MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
			ShowPolynomial("정렬후 다항식 x = ", x, -1);
			ShowPolynomial("정렬후 다항식 y = ", y, -1);
			
			Polynomial3[] z = new Polynomial3[20];
			
			for (int i =0; i < z.length; i++)
				z[i] = new Polynomial3();
		
			System.out.println();
			System.out.println();
			int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
			ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

			
			zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
			MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
			ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
			double result = EvaluatePolynomial(z, zTerms, 1);//다항식 값 계산 함수 z(10) 값 계산한다 
			System.out.printf("result = %.2f\n", result );
		}
	}

