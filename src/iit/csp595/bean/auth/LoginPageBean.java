package iit.csp595.bean.auth;

import java.io.Serializable;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.bean.Message;
import iit.csp595.domain.object.User;

public class LoginPageBean extends GenericPageBean<User> implements Serializable {

  public LoginPageBean() {
    super("pages/login.jsp", null);
  }

  public LoginPageBean(Message message) {
    super("pages/login.jsp", message);
  }

}
