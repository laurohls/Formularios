package org.camunda.bpm.formulario.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Campo extends AbstractEntity {

	private String nameCamunda, description, typeCamunda, type;
	private Integer sizeLayout, min, max;
}