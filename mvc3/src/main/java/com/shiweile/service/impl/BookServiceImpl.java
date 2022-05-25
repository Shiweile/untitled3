package com.shiweile.service.impl;

import com.shiweile.dao.BookDao;
import com.shiweile.domain.Book;
import com.shiweile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
@Service
@EnableTransactionManagement
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    public List<Book> selectAll() {
        return bookDao.selectAll();
    }
}
