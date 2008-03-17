package flex.samples.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * プロダクトです。
 * 
 * @author higa
 * 
 */
@Entity
public class Product implements Serializable {

	static final long serialVersionUID = 1L;

	/**
	 * 識別子です。
	 */
	@Id
	@GeneratedValue
	public Integer productId;

	/**
	 * 名前です。
	 */
	public String name;

	/**
	 * 説明です。
	 */
	public String description;

	/**
	 * イメージです。
	 */
	public String image;

	/**
	 * カテゴリです。
	 */
	public String category;

	/**
	 * 値段です。
	 */
	public BigDecimal price;

	/**
	 * 株数です。
	 */
	public Integer qtyInStock;

	/**
	 * コンストラクタです。
	 */
	public Product() {
	}
}