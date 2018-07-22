package matheusicaro.com.github.store.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id; 
	private String title;
	private String description;
	private int pages;

	@Override
	public String toString() {
		return "Product [title=" + title + ", descripton=" + description + ", pages=" + pages + "]";
	}	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getDescripton() {
		return description;
	}
	public void setDescripton(String descripton) {
		this.description = descripton;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
