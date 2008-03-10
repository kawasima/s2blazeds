package flex.samples.action;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.struts.annotation.Execute;

import flex.samples.entity.Product;

public class ProductAction {

	public JdbcManager jdbcManager;

	public List<Product> items;

	@Execute(validator = false)
	public String index() {
		items = getProducts();
		return "products.jsp";
	}

	public List<Product> getProducts() {
		return jdbcManager.from(Product.class).getResultList();
	}
}
