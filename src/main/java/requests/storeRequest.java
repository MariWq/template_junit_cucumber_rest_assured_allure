package requests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.order.Order;
import models.pet.Pet;

import static config.ApiConfig.getRequestSpecification;
import static constant.urlConstants.PET_URL;
import static constant.urlConstants.STORE_ORDER_URL;
import static io.restassured.RestAssured.given;

public class storeRequest {

    @Step("Создать заказ")
    public Response postStoreOrder(Order order) {
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(STORE_ORDER_URL)
                .andReturn();

        return response;
    }

    @Step("Получить заказ")
    public Response getStoreOrder(String orderId){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(STORE_ORDER_URL + orderId);
        return response;
    }

    @Step("Удалить заказ")
    public Response deleteStoreOrder(String orderId){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .delete(STORE_ORDER_URL + orderId);
        return response;
    }
}
