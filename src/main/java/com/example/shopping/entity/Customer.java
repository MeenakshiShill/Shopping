package com.example.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Contact")
	private String contact;
	

}
