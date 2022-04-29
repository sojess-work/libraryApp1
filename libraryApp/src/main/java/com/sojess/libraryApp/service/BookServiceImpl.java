package com.sojess.libraryApp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sojess.libraryApp.DAO.Book.BookDAO;
import com.sojess.libraryApp.DAO.Book.BookPublisherDAO;
import com.sojess.libraryApp.DAO.Booking.BookingDAO;
import com.sojess.libraryApp.entity.Billing;
import com.sojess.libraryApp.entity.Book;
import com.sojess.libraryApp.entity.Booking;


@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	private BookPublisherDAO bookPublisherDAO;
	private BookingDAO bookingDAO;
	
	
	@Autowired
	public BookServiceImpl(BookDAO bookDAO,BookPublisherDAO bookPublisherDAO,BookingDAO bookingDAO) {
		this.bookDAO=bookDAO;
		this.bookPublisherDAO=bookPublisherDAO;
		this.bookingDAO=bookingDAO;
		
	}
	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookDAO.getBooks();
	}
	@Override
	@Transactional
	public Book getBooksByBookId(int id) {
		
		return bookDAO.getBooksByBookId(id);
	}
	@Override
	@Transactional
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.updateBook(book);
	}
	@Override
	@Transactional
	public void deleteBookById(int bookId) {
		bookDAO.deleteBookById(bookId);
		
	}
	@Override
	@Transactional
	public int saveBook(Book book, int authorId, int publisherId) {
		return bookDAO.saveBook(book, authorId, publisherId);
	}
	@Override
	@Transactional
	public int getNumberOfBooksPublished(int publisherId) {
		return bookPublisherDAO.getNumberOfBooksPublished(publisherId);
		}
	@Override
	@Transactional
	public int getCountofBooksByCustomerId(int customerId) {
		return bookingDAO.getCountofBooksByCustomerId(customerId);
	}
	
	
	

}
