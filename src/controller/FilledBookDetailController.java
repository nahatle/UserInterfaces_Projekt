//package controller;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import view.BookDetail;
//import domain.Library;
//
//public class FilledBookDetailController extends BookDetailController{
//	
//	private BookDetail bookDetail;
//	private Library lib;
//
//	public FilledBookDetailController(Library library, BookDetail bookDetail) {
//		super(library, bookDetail);
//		initialize();
//	}
//	
//
//	public void initialize(){
//		bookDetail.getBtnDeleteBook().addActionListener((new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
//			}
//
//		})
//				);
//	}
//	
//}
