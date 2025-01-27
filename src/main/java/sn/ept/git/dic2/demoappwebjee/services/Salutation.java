package sn.ept.git.dic2.demoappwebjee.services;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "salut")
public class Salutation {
    String langue;
    String msg;
}
