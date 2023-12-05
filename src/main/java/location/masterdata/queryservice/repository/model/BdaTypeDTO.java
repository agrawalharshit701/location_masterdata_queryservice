package location.masterdata.queryservice.repository.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BdaTypeDTO {
    @Id
    @Column("id")
    private String id;
    @Column("city_id")
    private String city_id;
    @Column("name")
    private String name;
    @Column("name")
    private String type;
    @Column("bda_type")
    private String bdaType;
    @Column("alternate_codes")
    private String alternateCodes;



}
