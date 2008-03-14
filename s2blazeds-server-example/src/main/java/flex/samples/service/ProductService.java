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
	 * 名前で検索してプロダクトのリストを返します。
	 * 
	 * @param name
	 *            名前
	 * @return プロダクトのリスト
	 */
	public List<Product> getProductsByName(String name) {
		return jdbcManager.from(Product.class).where(
				"upper(name) like upper(?)", "%" + name + "%").orderBy("name")
				.getResultList();
	}

	/**
	 * プロダクトをテーブルに挿入します。
	 * 
	 * @param product
	 *            プロダクト
	 * @return 識別子が設定された後のプロダクト
	 */
	public Product create(Product product) {
		jdbcManager.insert(product).execute();
		return product;
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

	/**
	 * プロダクトをテーブルから削除します。
	 * 
	 * @param product
	 *            プロダクト
	 * @return 削除が成功したかどうか
	 */
	public boolean remove(Product product) {
		return jdbcManager.delete(product).execute() == 1;
	}
}