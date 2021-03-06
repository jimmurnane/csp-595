package iit.csp595.service;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.bean.Message;
import iit.csp595.bean.product.ProductIndividualBean;
import iit.csp595.bean.product.ProductListingBean;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.object.Product;

import java.util.List;

public class ProductService implements Service<Product> {

  private int nextPage;
  private long[] categoryTypeId;
  private int sortTypeId;
  private ProductDao dao;
  private long productId = -1L;

  public ProductService(long productId, int nextPage, long[] categoryTypeId, int sortTypeId) {
    super();
    this.dao = new ProductDao();
    this.productId = productId;
    this.nextPage = nextPage;
    this.categoryTypeId = categoryTypeId;
    this.sortTypeId = sortTypeId;
  }

  @Override
  public GenericPageBean<Product> createBean() {
    if (productId == -1) {

      int offset = nextPage - 1;
      int totalProductsCount = dao.getCount(categoryTypeId, sortTypeId);
      List<Product> products = dao.getAll(offset * 2, 2, categoryTypeId, sortTypeId);
      ProductListingBean bean = new ProductListingBean(products, null, totalProductsCount);

      bean.setCurrentPage(nextPage);
      bean.setCurrentCategories(categoryTypeId);

      return bean;
    } else {

      Product p = dao.get(productId);
      ProductIndividualBean bean = new ProductIndividualBean(p);
      if (p == null) {
        bean.setMessage(new Message("error", "Could not find that thing"));
      }
      return bean;
    }
  }

}
