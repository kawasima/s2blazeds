package flex.samples.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	public Integer productId;
	public String name;
	public String description;
	public String image;
	public String category;
	public BigDecimal price;
	public Integer qtyInStock;

	public Product() {
	}
}