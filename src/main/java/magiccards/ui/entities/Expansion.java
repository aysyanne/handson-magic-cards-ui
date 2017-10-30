package magiccards.ui.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Expansion {
	private String expansionId;
	private String name;
	private String ptBRName;
	private String linkName;
	private String code;
	private Date launchDate;
	private Long expansionCategoryId;
	private Boolean isPromo;
	private Boolean isLegal;
}
