package flex.samples.service;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import flex.samples.entity.Employee;

/**
 * プロダクトを扱うアクションです。
 * 
 * @author higa
 * 
 */
public class EmployeeService {

	/**
	 * JDBCマネージャです。
	 */
	public JdbcManager jdbcManager;

	/**
	 * 従業員のリストを返します。
	 * 
	 * @return 従業員のリスト
	 */
	public List<Employee> getEmployees() {
		return jdbcManager.from(Employee.class).orderBy("lastName")
				.getResultList();
	}

	/**
	 * 従業員をテーブルに挿入します。
	 * 
	 * @param employee
	 *            従業員
	 * @return 識別子が設定された後の従業員
	 */
	public Employee create(Employee employee) {
		jdbcManager.insert(employee).execute();
		return employee;
	}

	/**
	 * 従業員を更新します。
	 * 
	 * @param employee
	 *            従業員
	 * @return 更新した行数
	 */
	public int update(Employee employee) {
		return jdbcManager.update(employee).execute();
	}

	/**
	 * 従業員をテーブルから削除します。
	 * 
	 * @param employee
	 *            従業員
	 * @return 削除が成功したかどうか
	 */
	public boolean remove(Employee employee) {
		return jdbcManager.delete(employee).execute() == 1;
	}
}