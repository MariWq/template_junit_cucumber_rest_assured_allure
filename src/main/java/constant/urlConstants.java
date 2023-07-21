package constant;

public interface urlConstants {
    // описаны по спецификации swagger все endpoint's
    // константы имеют название endpoint's и постфикс _URL
    // BASE_URL заканчивается на "/", поэтому слеш в методе указывается при необходимости после

    // pet
    public static final String PET_URL = "pet/";
    public static final String UPLOAD_IMAGE_URL = "/uploadImage";
    public static final String FIND_BY_STATUS_URL = "findByStatus";

    //store
    public static final String STORE_ORDER_URL = "store/order/";
    public static final String STORE_INVENTORY_URL = "store/inventory";

    //user
    public static final String USER_URL = "user/";
    public static final String CREATE_WITH_ARRAY_URL = "user/createWithArray";
    public static final String LOGIN_URL = "login";
    public static final String LOGOUT_URL = "logout";
}
