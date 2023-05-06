package com.portalproblem.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.portalproblem.demo.Model.Book;
import com.portalproblem.demo.Repository.BookRepository;

@Service
public class BookService 
{
    @Autowired
    BookRepository bRep;
	public List<Book> getBook(String bookname) 
	{
		
		return bRep.findAll();	}
	public Optional<Book> getById(int bookId) 
	{
		
		Optional<Book> l = bRep.findById(bookId);
   	     return l;
	}
	public Book saveBook(Book b) 
	{
		
		return bRep.save(b);
	}
	public Book updateBook(Book b, int bookId) 
	{
		
		Optional<Book> optional=bRep.findById(bookId);
   		Book obj=null;
   		if(optional.isPresent())
   		{
   			obj=optional.get();
   			/*obj.setRegno(s.getRegno());
   			obj.setName(s.getName());
   			obj.setDept(s.getDept());
   			obj.setEmail(s.getEmail());*/
   		bRep.save(b);
   		}
   		return obj;
   	
	}

}
