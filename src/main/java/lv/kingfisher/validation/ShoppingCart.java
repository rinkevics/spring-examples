package lv.kingfisher.validation;

import javax.validation.constraints.Size;

public class ShoppingCart {

    @Size(min= 10)
    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
