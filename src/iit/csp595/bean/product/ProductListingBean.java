package iit.csp595.bean.product;

import java.io.Serializable;
import java.util.List;

import iit.csp595.bean.GenericListingPageBean;
import iit.csp595.domain.object.Product;
import iit.csp595.domain.object.type.CategoryType;

public class ProductListingBean extends GenericListingPageBean<Product> implements Serializable {

  public ProductListingBean(List<Product> products, List<CategoryType> categorieTypes, int totalProducts) {
    super(products, categorieTypes, totalProducts, "pages/product-listing.jsp");
    super.setBrowserPageTitle("Product Listing");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Products", null);
  }

}
