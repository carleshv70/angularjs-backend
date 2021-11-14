package org.chuix.training.universidad.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paises")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
	
	private static final long serialVersionUID = -2299393379309112673L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "iso")
	private String iso;
	
	@Column(name = "nombre")
	private String name;
}
