package requests;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.pet.Pet;

import java.io.File;
import java.util.Map;

import static config.ApiConfig.getRequestSpecification;
import static constant.urlConstants.PET_URL;
import static constant.urlConstants.UPLOAD_IMAGE_URL;
import static io.restassured.RestAssured.given;

public class petsRequests {

    @Step("Создать животное")
    public Response postPet(Pet pet) {
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(PET_URL)
                .andReturn();

        return response;
    }

    @Step("Обновить животное")
    public Response putPet(Pet pet){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(PET_URL);
        return response;
    }

    @Step("Получить животного по статусу")
    public Response getPetFindByStatus(String status){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(PET_URL);
        return response;
    }

    @Step("Получить одно животное")
    public Response getPetID(String petID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(PET_URL + petID);
        return response;
    }

    // предположительно есть список без параметров параметрами
    @Step("Получить список животных")
    public Response getPets(){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(PET_URL);
        return response;
    }

    // предположительно есть список с несколькими параметрами
    @Step("Получить список животных")
    public Response getPets(Map<String,?> map){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .params(map)
                .when()
                .get(PET_URL);
        return response;
    }

    @Step("Удалить животное")
    public Response deletePetID(String petID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .delete(PET_URL + petID);
        return response;
    }

    @Step("Загрузить изображение для животного")
    public Response uploadImagePet(File file, String petID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.MULTIPART)
                .multiPart(file)
                .when()
                .post(PET_URL + petID + UPLOAD_IMAGE_URL);
        return response;
    }
}
