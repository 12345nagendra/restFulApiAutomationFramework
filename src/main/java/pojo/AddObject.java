package main.java.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


//@Getter
//@Setter
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddObject {
    String id;
    String name;
    Data data;
    String createdAt;

    @Override
    public String toString() {
        return name + " "
                + data.getYear() + " "
                + data.getHardDiskSize() + " "
                + data.getCpuModel() + " INR "
                + data.getPrice();
    }
}
