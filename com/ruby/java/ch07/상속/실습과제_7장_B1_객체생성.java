package com.ruby.java.ch07.상속;

class Item{
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량
	
	public Item(String name, double price, int stockQuantity) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	// 재고 감소 메소드
    public void reduceStock(int quantity) {
    	if (quantity <= stockQuantity){
    		stockQuantity -= quantity;
    		//System.out.println(quantity +"개 출고.남은재고:"+stockQuantity);
    	}else {
    		System.out.println("재고 부족!현재 재고: "+stockQuantity);
    	}

    }

    // 재고 증가 메소드
    public void increaseStock(int quantity) {
    	stockQuantity += quantity;
        //System.out.println(quantity + "개 입고됨. 현재 재고: " + stockQuantity);
    }

    // 정보 출력 메소드
    public void show() {
        System.out.println("이름 : "+name);
        System.out.println("가격 : "+price);
        System.out.println("재고수량 : "+stockQuantity);
    }

    @Override
    public String toString() {
        return name+":"+price+":"+stockQuantity;
    }

    // 접근자 메소드
    public String getName() {
		return name;

    }
    
    

    public double getPrice() {
		return price;

    }
	
}

class Customer{
	private String cname;
	private String city;
	private int age;
	
	public Customer(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	// 정보 출력 메소드
    public void show() {
        System.out.println("--"+cname+city+age);
    }

    @Override
    public String toString() {
        return cname+city+age;
    }
	
}

class Order{
	private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private String []orderDates;
    private int count; // 아이템 개수
    
 
	public Order(Customer customer, int size) {
		this.customer = customer;
		this.items = new Item[size];
		this.quantities = new int[size];
		this.orderDates = new String[size];
		this.count = 0;
	}

	// 아이템 추가 메소드
    public void addItem(Item item, int orderQuantity) {
    	if (count >= items.length) {
            System.out.println("더 이상 아이템을 추가할 수 없습니다.");
            return;
        }

        items[count] = item;
        quantities[count] = orderQuantity;
        orderDates[count] = "2025-05-16"; // 날짜 하드코딩 또는 LocalDate.now().toString()
        item.reduceStock(orderQuantity); // 재고 감소
        count++;
    }

    // 총액 계산 메소드
    public double calculateTotal() {
    	double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice() * quantities[i];
        }
        return total;
    }

    // 주문 요약 출력 메소드
    public void printOrderSummary() {
    	 System.out.println("=== 주문 요약 ===");
    	    System.out.println("이름: " + customer.toString());

    	    for (int i = 0; i < count; i++) {
    	        System.out.println(orderDates[i] + " - " + items[i].getName() + " , 개수:" + quantities[i]);
    	    }

    	    System.out.printf("총액: %.2f\n", calculateTotal());
    	    System.out.println();
    }
}


public class 실습과제_7장_B1_객체생성 {
	public static void main(String[] args) {
        // 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        
        
        Customer girl = new Customer("계백", "양산", 22);
        
        boy.show();
        girl.show();

        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
        order1.addItem(laptop, 1);
        order1.addItem(tshirt, 2);
        order1.addItem(phone, 1);
        order1.addItem(headphones, 1);
        order1.addItem(mouse, 1);
        
        laptop.show();
        

        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1);
        order2.addItem(tshirt, 1);
        order2.addItem(phone, 1);
        order2.addItem(headphones, 1);
        order2.addItem(mouse, 1);

        // 주문 요약 출력
        order1.printOrderSummary();
        order2.printOrderSummary();
        
    }
}
