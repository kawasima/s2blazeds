package flex.samples.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 従業員です。
 * 
 * @author higa
 * 
 */
@Entity
public class Employee implements Serializable {

	static final long serialVersionUID = 1L;

	/**
	 * 識別子です。
	 */
	@Id
	@GeneratedValue
	public Integer employeeId;

	/**
	 * 最初の名前です。
	 */
	public String firstName;

	/**
	 * 最後の名前です。
	 */
	public String lastName;

	/**
	 * タイトルです。
	 */
	public String title;

	/**
	 * メールアドレスです。
	 */
	public String email;

	/**
	 * 電話番号です。
	 */
	public String phone;

	/**
	 * 会社の識別子です。
	 */
	public Integer companyId;

	/**
	 * 会社です。
	 */
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne
	public Company company;
}
