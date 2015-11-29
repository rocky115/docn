/**
 * 
 */
package hello;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author rm
 *
 */

public class Book {

	@Id
	private String id;
	private String name;
	private String isbn;
	private String author;
	/**
	 * @return the remarkList
	 */
	public List<Remark> getRemarkList() {
		return remarkList;
	}

	/**
	 * @param remarkList the remarkList to set
	 */
	public void setRemarkList(List<Remark> remarkList) {
		this.remarkList = remarkList;
	}


	private int pages;
	private List<Remark> remarkList;
	
	public Book(String name,String isbn,String author,int pages){
	
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.pages = pages;
	
	}
	
	public Book(String name,String isbn,String author,int pages,List<Remark> remarkList){
		
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.pages = pages;
		this.remarkList = remarkList;
	
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}





	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}





	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}





	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}





	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}



	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}


	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}


	public Book(){
		
	}
}
