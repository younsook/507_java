package com.ruby.java.ch13.generic;
/*
 * C4 - 도서관리시스템 - generic 적용 실습
 */
import java.util.ArrayList;

//Overflow 예외 클래스
class OverflowException extends RuntimeException { // 교재 553
	public OverflowException(String msg) {
		super(msg);
	}
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {

}

interface MediaBook {
	public String getTitle();
	public String getISBN();
}

//Book 클래스

class Book5 implements MediaBook, Comparable<Book5> {
	
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book5(String title, String author, int publicationYear, String isbn) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book5 [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn="
				+ isbn + "]";
	}
}

class CDBook implements MediaBook, Comparable<CDBook> {
	private String cdStory;
	private String artist;
	private String catalogNumber;

}
class USBBook implements MediaBook, Comparable<USBBook> {
	private String usbName;
	private int capacity;
	private String serialNumber;
	private static String mediaType = "USB";

}

class Library<T extends MediaBook> {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<T> items;



	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(T book) {

	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public T removeBook() {
		return null;

	}

	public void printBooks(String msg) {
		System.out.println(msg);
		
	
		for (T s : items ) { // items는 ArrayList<T> 타입
			System.out.println(s); // Book 클래스의 toString()이 호출됨
		}
	}

	public void sortBooksByTitle() {
		items.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}

	public void sortBooksByISBN() {
	}

	public T searchBookByTitle(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (title.equals(items.get(i).getTitle())) {
				return items.get(i);
			}
		}
		return null;
	}
}
public class C4_generic {
	public static void main(String[] args) {
		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book5 book1 = new Book5("자바", "강감찬", 1995, "12");
		Book5 book2 = new Book5("파이썬", "이순신", 2008, "9");
		Book5 book3 = new Book5("C#", "을지문덕", 2008, "8");
		Book5 book4 = new Book5("자료구조", "연개소문", 1994, "45");
		Book5 book5 = new Book5("리액트", "김춘추", 1999, "7");
		Book5 book6 = new Book5("스프링", "홍길동", 2025, "99");
		// 예외 처리를 적용한 책 추가 및 삭제
		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);
			library.addBook(book6);

			// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			Book5 book7 = new Book5("SQL", "이기자", 2024, "34");
			library.addBook(book7); // 이 부분에서 OverflowException 발생
		} catch (OverflowException e) {
			System.out.println(e.getMessage());// OverflowException 생성시 전달된 메시지 출력
			e.printStackTrace();
		}
		
		// 도서 목록 출력
        library.printBooks("\n현재 도서 목록:");

        // **제목 기준 정렬 및 출력**
        System.out.println("\n=== 제목 기준 정렬 ===");
        library.sortBooksByTitle();
        library.printBooks("제목 정렬 후:");

        // **ISBN 기준 정렬 및 출력**
        System.out.println("\n=== ISBN 기준 정렬 ===");
        library.sortBooksByISBN();
        library.printBooks("ISBN 정렬 후:");

		try {
			// 책 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제
			library.removeBook(); // 정상 삭제

			// 빈 도서관에서 책을 삭제 (예외 발생)
			library.removeBook(); // 이 부분에서 UnderflowException 발생
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("\n최종 도서 목록:");
	}
}