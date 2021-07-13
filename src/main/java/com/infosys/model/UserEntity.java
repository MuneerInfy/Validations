package com.infosys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="USER_TABLE")
@Entity
public class UserEntity {

		@Column(name="user_id")
		@Id
		@GeneratedValue
		private long id;
		@Column(name="user_name")
		private String name;
		@Column(name="user_email")
		private String email;
}
