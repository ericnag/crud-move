package com.api.testemove.dtos;

import com.api.testemove.enums.StatusConectorEnum;
import com.api.testemove.enums.TipoEnum;
import com.api.testemove.models.Robo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConectorDto {

    private TipoEnum tipo;

    private StatusConectorEnum status;

}
