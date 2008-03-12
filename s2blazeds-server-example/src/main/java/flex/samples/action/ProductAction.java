package flex.samples.action;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.struts.annotation.Execute;

import flex.samples.entity.Product;

/**
 * プロダクトを扱うアクションです。
 * 
 * @author higa
 * 
 */
public class ProductAction {

	/**
	 * JDBCマネージャです。
	 */
	public JdbcManager jdbcManager;

	/**
	 * プロダクトのリストです。
	 */
	public List<Product> items;

	/**
	 * インデックス用の実行メソッドです。
	 * 
	 * @return 遷移先
	 */
	@Execute(validator = false)
	public String index() {
		items = getProducts();
		return "products.jsp";
	}

	/**
	 * プロダクトのリストを返します。
	 * 
	 * @return プロダクトのリスト
	 */
	public List<Product> getProducts() {
		return jdbcManager.from(Product.class).getResultList();
	}

	/**
	 * プロダクトを更新します。
	 * 
	 * @param product
	 *            プロダクト
	 * @return 更新した行数
	 */
	public int update(Product product) {
		return jdbcManager.update(product).execute();
	}
}
