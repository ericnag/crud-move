package com.api.testemove.models;

import com.api.testemove.enums.StatusConectorEnum;
import com.api.testemove.enums.StatusRoboEnum;
import com.api.testemove.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "conector")
@Table(name = "conector")
public class Conector {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_robo", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Robo robo;

    @Column(name = "tipo")
    private TipoEnum tipo;

    @Column(name = "status")
    private StatusConectorEnum status;

}
