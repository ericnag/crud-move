package com.api.testemove.models;

import com.api.testemove.enums.StatusRoboEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "robo")
@Table(name = "robo")
public class Robo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @Length(max = 100)
    @Column(name = "nome")
    private String nome;

    @Column(name = "status")
    private StatusRoboEnum status;

    @OneToMany(targetEntity = Conector.class,
            mappedBy = "robo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Conector> conectores;

}
