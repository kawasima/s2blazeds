package flex.samples.service;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import flex.samples.entity.Product;

/**
 * プロダクトを扱うアクションです。
 * 
 * @author higa
 * 
 */
public class ProductService {

	/**
	 * JDBCマネージャです。
	 */
	public JdbcManager jdbcManager;

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