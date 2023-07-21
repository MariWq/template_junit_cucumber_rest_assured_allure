package ru.sberbank.stepdefinitions;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import models.order.Order;
import models.pet.Category;
import models.pet.Pet;
import models.pet.TagsItem;
import requests.petsRequests;
import requests.storeRequest;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static utils.helpUtills.getFile;


public class stepDefinitions {

    /*
    *
    *   Environments
    *
    * */

    private String petID, orderID;
    public static Response response;


    /*
     *
     *   Общие шаги
     *
     * */

    @Тогда("статус ответа {int}")
    public void checkStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @И("тело ответа содержит поле {string} со значением {string}")
    public void checkBodyParam(String arg0, String arg1) {
        assertEquals(arg1, response.jsonPath().get(arg0).toString());
    }

    @И("время ответа меньше {int} ms")
    public void checkTimeOut(int arg0) {
        assertTrue("Время ответа больше " +  arg0, arg0 > response.getTime());

    }

    /*
     *
     *   Методы pets
     *
     * */

    @Когда("создать животное с параметрами, статус {int}:")
    public void createPet(int statusCode, List<List<String>> dataTable) {

        //отправляем запрос, сохраняем ответ
        response = new petsRequests().postPet(
                                        Pet.builder()
                                                .id(Integer.valueOf(dataTable.get(0).get(1)))
                                                .name(dataTable.get(1).get(1))
                                                .category(Category.builder()
                                                        .id(Integer.valueOf(dataTable.get(2).get(1)))
                                                        .name(dataTable.get(3).get(1))
                                                        .build())
                                                .photoUrls(Collections.singletonList(dataTable.get(4).get(1)))
                                                .tags(Collections.singletonList(
                                                        TagsItem.builder()
                                                                .id(Integer.valueOf(dataTable.get(5).get(1)))
                                                                .name(dataTable.get(6).get(1))
                                                                .build()
                                                ))
                                                .status(dataTable.get(7).get(1))
                                                .build());

        petID = response.jsonPath().get("id").toString();

        assertEquals(statusCode, response.getStatusCode());


    }


    @Тогда("получить животное, статус {int}")
    public void getPet(int statusCode) {
        response = new petsRequests().getPetID(petID);
        assertEquals(statusCode, response.getStatusCode());
    }


    @Тогда("удалить животное, статус {int}")
    public void deletePetId(int statusCode) {
        response = new petsRequests().deletePetID(petID);
        assertEquals(statusCode, response.getStatusCode());
    }


    @Тогда("загрузить изображение {string}, статус {int}")
    public void uploadImage(String file, int statusCode) {
        response = new petsRequests().uploadImagePet(getFile(file), petID);
        assertEquals(statusCode, response.getStatusCode());
    }

    /*
     *
     *   методы orders
     *
     * */

    @Когда("создать заказ, статус {int}:")
    public void createStoreOrder(int statusCode, List<List<String>> dataTable) {
        response = new storeRequest().postStoreOrder(
                                                Order.builder()
                                                        .id(Integer.valueOf(dataTable.get(0).get(1)))
                                                        .petId(Integer.valueOf(dataTable.get(1).get(1)))
                                                        .build());
        orderID = response.jsonPath().getString("id");
        assertEquals(statusCode, response.getStatusCode());
    }


    @Тогда("получить заказ, статус {int}")
    public void  getOrder(int statusCode) {
        response = new storeRequest().getStoreOrder(orderID);
        assertEquals(statusCode, response.getStatusCode());
    }
}
