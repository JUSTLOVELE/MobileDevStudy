package com.study.service;

import com.study.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {

	/*@Autowired(required=false)
	@Qualifier("bookDao")*/
	/*@Resource(name="bookDao2")*/
	@Inject
	private BookDao bookDao;

	@Override
	public String toString() {
		return "BookService [_bookDao=" + bookDao + "]";
	}
	
	
}
