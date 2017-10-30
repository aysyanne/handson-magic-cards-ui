package magiccards.ui.entities;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Expansion {
	private String ExpansionId;
	private String Name;
	private String PtBRName;
	private String LinkName;
	private String Code;
	private Date LaunchDate;
	private Long ExpansionCategoryId;
	private Boolean IsPromo;
	private Boolean IsLegal;
}
