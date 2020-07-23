/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



public class Book {

    
    private int bookID;
    private String title;
    private String authorName;
    private String publisherName;



    public Book(int bookID, String title, String authorName, String publisherName) {
        this.bookID = bookID;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    
    
     public void setBook(int bookID, String title, String authorName, String publisherName){
        setBookID(bookID);
        setTitle(title);
        setAuthorName(authorName);
        setPublisherName(publisherName);
      
    }

}
