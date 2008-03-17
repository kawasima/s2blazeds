package flex.samples.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 会社です。
 * 
 * @author higa
 * 
 */
@Entity
public class Company implements Serializable {

	static final long serialVersionUID = 1L;

	/**
	 * 識別子です。
	 */
	@Id
	@GeneratedValue
	public int companyId;

	/**
	 * 名前です。
	 */
	public String name;

	/**
	 * 住所です。
	 */
	public String address;

	/**
	 * 町です。
	 */
	public String city;

	/**
	 * 郵便番号です。
	 */
	public String zip;

	/**
	 * 州です。
	 */
	public String state;

	/**
	 * 産業です。
	 */
	public String industry;
}