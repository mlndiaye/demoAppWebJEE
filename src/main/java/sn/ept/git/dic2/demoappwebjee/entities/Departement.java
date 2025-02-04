package sn.ept.git.dic2.demoappwebjee.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @Size(max = 15)
    @Column(name = "CODE", nullable = false, length = 15)
    private String code;

    @Size(max = 255)
    @NotNull
    @Column(name = "NOM", nullable = false)
    private String nom;

    private Date dateEnregistrement;

    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;

    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

    @Size(max = 255)
    @Column(name = "FB")
    private String fb;

    @Size(max = 255)
    @Column(name = "INSTAGRAM")
    private String instagram;

    @Size(max = 255)
    @Column(name = "LINKEDIN")
    private String linkedin;

    @Size(max = 255)
    @Column(name = "SITEWEB")
    private String siteweb;

    @Size(max = 255)
    @Column(name = "TELEPHONE")
    private String telephone;

    @Size(max = 255)
    @Column(name = "TWITTER")
    private String twitter;

    @PrePersist
    public void prepersist(){
        dateEnregistrement = new Date();
    }

}