package com.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document 
{
	
	@Lob
	@Column(length = 10000)
private byte[] photo;
	@Lob
	@Column(length = 10000)
private byte[] adharCardpdf;
private String msg;

}
