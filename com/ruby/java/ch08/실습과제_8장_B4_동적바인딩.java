package com.ruby.java.ch08;

//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item {
//제품테이블--| 네모 | -------------------------
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량
	
	//생성자 정의
	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public void reduceStock(int quantity) {
		//주문이 들어온것을 재고에서 빼는 실행문
		stockQuantity -= quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}

	public void show() {
		// 출력	
		System.out.println("제품명: "+name+", 제품가격: "+price+", 재고량: "+stockQuantity);
	}

	
}// class Item

//Electronics 클래스: Item 클래스 상속 | 추상클래스
//제품테이블 상속1--| 네모 | -------------------------
class Electronics extends Item {
	private int madeYear;
	
	//생성자 정의한것을 쓴다.
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}

	@Override
	public void show() {
		super.show(); // 부모 클래스 show() 먼저 호출
		System.out.println("제조연도: "+madeYear);
	}
	
	
}

//Clothing 클래스: Item 클래스 상속 
//ys. 추상클래스 private String name; // 제품명 같은 데이터 멤버가 있다.
//제품테이블 상속2--| 네모 | -------------------------
class Clothing extends Item {
	private int size; //속성
	
	public Clothing (String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

	@Override //재정의하기. super.show() 실행 후 추가코드 작성
	public void show() {
		super.show();
		System.out.println("사이즈 : "+size);
	}
}

//Discountable 인터페이스 정의 
//ys. interface implements ---------|네모 |--------------------
interface Discountable {
	double getDiscountedPrice(double price); // 추상 메소드 : 함수바디없고, 데이터 멤버 없고 
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;
	//시즌별 할인율 계산하기
	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public double getDiscountedPrice(double price) {
		return price * (discountRate);
	}

}

//ys. 주문테이블
//Order 클래스
class Order extends SeasonalDiscount {
	private final int N = 20; //주문은 20개까지만 한다.
	private Customer customer; // 고객명
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count = 0; //주문한 카운트 static 선언으로 객체가 없어도 값은 유지됨.
	
	public Order(Customer custom) {
		super(0.02); //super 는 상위클래스 , 계절 할인율 2%
		customer = custom;
		
		this.items = new Item[N];
		this.quantities = new int[N];
		this.orderDates = new String[N];
	}

	public void addItem(Item item, int quantity, String orderDate) {
		if(count < N) {
			items[count] = item;
			quantities[count] = quantity;
			orderDates[count] = orderDate;
			
			count++;
		}else {
			System.out.println("더이상 주문 불가.");
		}
	}

	public double calculateTotal() {
		//할인없이 수량 단가로 비용 계산
		double total = 0;
		for (int i=0;i<count;i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	
	}

	public void printOrderSummary() {
		System.out.println("=======주문 요약==========");
		for (int i=0; i<count; i++) {
			System.out.println("주문일:"+orderDates[i]+"| 상품명:"+items[i].getName()+"| 수량:"+quantities[i]+"| 단가:"+String.format("%.2f", items[i].getPrice()) +"| 합계:"+String.format("%.2f", items[i].getPrice() * quantities[i]));
		}
		
	}

//할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */
		double total = calculateTotal();
		System.out.println("총금액' " + total);
		double afSeasonalDiscount = getDiscountedPrice(total);
		double afCustomerDiscount = customer.applyDiscount(afSeasonalDiscount);
		
		System.out.println("시즌 할인 후 금액: "+afSeasonalDiscount);
		System.out.println("고객 할인 후 최종 결제 금액: "+afCustomerDiscount);
		System.out.println("총 할인 금액"+(total-afCustomerDiscount-afSeasonalDiscount));

	}
}

//Customer 추상 클래스 정의 
//고객테이블--| 네모 | -------------------------
abstract class Customer {
	private String name;
	//생성자 정의
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스 구현: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	
	public RegularCustomer(String name) {
		super(name); //부모 클래스 생성자 호출
	}

	static final double REGULARDISCOUNT_RATE = 0.03;
	//일반고객은 3%할인

	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * (REGULARDISCOUNT_RATE);
	}

}

//PremiumCustomer 클래스 구현: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	
	public PremiumCustomer(String name) {
		super(name);
	}
	
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	//프리미엄은 10%할인

	@Override
	double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * (PREMIUMDISCOUNT_RATE);
	}


}

//주문테이블--| 네모 | -------------------------
//시즌할인과 고객할인 적용해서 
public class 실습과제_8장_B4_동적바인딩 {
	static void showItemsStock(Item[] items) {
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}

	//제품 | 주문 | 고객
	public static void main(String[] args) {
		// Item 타입의 배열 생성
		Item[] items = new Item[4]; //아이템을 4개를 만들고 

		// 배열에 전자제품과 의류패션 객체 추가
		//아이템에 대한 생성자 배열
		items[0] = new Electronics("노트북", 1500, 100, 23);
		items[1] = new Clothing("티셔츠", 50, 100, 95);
		items[2] = new Electronics("휴대폰", 800, 100, 24);
		items[3] = new Clothing("청바지", 80, 100, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		showItemsStock(items);
		//----------------------제품item 에대한 end-------------------------------------------
		
		
		// 고객 생성
		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출


	}
}
