package com.ruby.java.ch09;

import java.util.Arrays;

/*
도서 관리 시스템은 다양한 책을 관리하고, 고객이 도서를 대여하거나 반납할 수 있게 하는 기능을 제공합니다. 또한, 고객의 대여 기록을 관리하고, 특정 조건에 맞는 책을 검색하거나 필터링하는 기능도 구현합니다.

1단계: 기본 클래스 및 컬렉션 사용
목표: Book 클래스 생성 및 기본 컬렉션 사용
설계:
Book 클래스: 제목, 저자, 출판 연도, ISBN 등을 속성으로 가짐
Library 클래스: 도서 목록을 관리하는 기능 (책 추가, 책 목록 출력)
과제:
Book 클래스를 작성하고 도서 정보를 담는 객체를 생성하세요.
Library 클래스를 작성해 ArrayList를 사용하여 도서를 관리하고, 도서 목록을 출력하세요.
*/
// Book 클래스

class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	
	//생성자
	public Book(String title, String author, int publicationYear, String isbn) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn =isbn;
	}

	//게터
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public String getISBN() {
		// TODO Auto-generated method stub
		return isbn;
	}
	
	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s",
	            title, author, publicationYear, isbn);
	}

}

// Library 클래스 
//책 포함하는 라이브러리
class Library { 
	static final int CAPACITY = 20;
	private Book[] books; 
	private int top;
	
	public Library() {
		this.books = new Book[CAPACITY];
	}
	
	public boolean addBook(Book book) {
		if(top < CAPACITY) {
			books[top++] = book;
			return true;
		}
		System.out.println("도서관책 용량 초과");
		return 	false;

	}
	public void printBooks(String msg) {
		//top변수로 출력
		System.out.println(msg);
		for(int i=0;i<top;i++) {
			System.out.println(books[i]);
		}

	}
	public void sortBooksByTitle(){
		//String의 compareTo() 사용
		//람다식, 그대로 쓰면됨.
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));//9.3.3 Arrays 클래스
	}
	public void sortBooksByISBN(){
		//String의 compareTo() 사용
		Arrays.sort(books, 0, top, (b1, b2) -> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));//9.3.3 Arrays 클래스
	}
	public Book searchBookByTitle(String title) {
		return null;

	}
}

public class chap9_ex{
	public static void main(String[] args) {
		Library library = new Library(); 
		
		// 5개의 Book 객체 초기화 
		// 5개의 책 객체 초기화 
		Book book1 = new Book("자바", "강감찬", 1995, "12"); 
		Book book2 = new Book("파이썬", "이순신", 2008, "9"); 
		Book book3 = new Book("C++", "을지문덕", 2008, "8"); 
		Book book4 = new Book("자료구조", "연개소문", 1994, "45"); 
		Book book5 = new Book("리액트", "김춘추", 1999, "7");
		// 책 추가
		library.addBook(book1); 
		library.addBook(book2); 
		library.addBook(book3); 
		library.addBook(book4);
		library.addBook(book5); 
		
		
		// 도서 목록 출력
		library.printBooks("\n제목정렬전"); 
		// 도서 목록 정렬 
		library.sortBooksByTitle(); 
		// 정렬된 도서 목록 출력 
		library.printBooks("\n제목정렬후");
		// 특정 제목으로 도서 검색 
		library.printBooks("\nISBN정렬전"); 
		// 도서 목록 정렬 
		library.sortBooksByISBN(); 
		// 정렬된 도서 목록 출력 
		library.printBooks("\nISBN정렬후");
		// 특정 제목으로 도서 검색 
		String searchTitle = "자바"; 
		Book foundBook = library.searchBookByTitle(searchTitle); 
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else 
			System.out.println("\n도서명으로 검색한 도서" + foundBook.toString());
	}
}
