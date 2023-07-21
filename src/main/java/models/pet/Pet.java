package models.pet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

//@Data // генерирует весь шаблонный код, вовлеченный в работу с объектами POJO
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet{
	private List<String> photoUrls;
	private String name;
	private Integer id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}