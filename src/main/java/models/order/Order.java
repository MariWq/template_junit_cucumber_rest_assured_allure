package models.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order{
	private Integer petId;
	private Integer quantity;
	private Integer id;
	private String shipDate;
	private Boolean complete;
	private String status;
}