package com.zcw.taskdemo;

import com.zcw.taskdemo.Book;
import com.zcw.taskdemo.IOnNewBookArrivedListener;

interface IBookManager {
     List<Book> getBookList();
     void addBook(in Book book);
     void registerListener(IOnNewBookArrivedListener listener);
     void unregisterListener(IOnNewBookArrivedListener listener);
}