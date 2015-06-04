package com.eleomanni.nercurio.entities;

import java.util.Date;

public class Person {
	    private int id;
	    private String name;
	    private String surname;
	    private String address;
	    private String cap;
	    private String city;
	    private String region; //provicia/stato
	    private String countryCode;
	    private String sex;
	    private Date birthdate;
	    private String usl;
	    private String document_number;
	    private Date datSubscription;
	    private Date datIns;
	    private Date datLastMod;
	    private Date datDel;
	    
	    public Person() {
	    }
	    
	    public Person(String name, String surname) {
	        this.name = name;
	        this.surname = surname;
	    }
	    public String getAddress() {
	    	return address;
	    }
	    public void setAddress(String address) {
	    	this.address = address;
	    }
	    public String getCap() {
	    	return cap;
	    }
	    public void setCap(String cap) {
	    	this.cap = cap;
	    }
	    public String getCity() {
	    	return city;
	    }
	    public void setCity(String city) {
	    	this.city = city;
	    }
	    public String getRegion() {
	    	return region;
	    }
	    public void setRegion(String region) {
	    	this.region = region;
	    }
	    public String getCountryCode() {
	    	return countryCode;
	    }
	    public void setCountryCode(String countryCode) {
	    	this.countryCode = countryCode;
	    }
	    public String getSex() {
	    	return sex;
	    }
	    public void setSex(String sex) {
	    	this.sex = sex;
	    }
	    public Date getBirthdate() {
	    	return birthdate;
	    }
	    public void setBirthdate(Date birthdate) {
	    	this.birthdate = birthdate;
	    }
	    public String getUsl() {
	    	return usl;
	    }
	    public void setUsl(String usl) {
	    	this.usl = usl;
	    }
	    public String getDocument_number() {
	    	return document_number;
	    }
	    public void setDocument_number(String document_number) {
	    	this.document_number = document_number;
	    }
	    public Date getDatSubscription() {
	    	return datSubscription;
	    }
	    public void setDatSubscription(Date datSubscription) {
	    	this.datSubscription = datSubscription;
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public Date getDatIns() {
			return datIns;
		}
		public void setDatIns(Date datIns) {
			this.datIns = datIns;
		}
		public Date getDatLastMod() {
			return datLastMod;
		}
		public void setDatLastMod(Date datLastMod) {
			this.datLastMod = datLastMod;
		}
		public Date getDatDel() {
			return datDel;
		}
		public void setDatDel(Date datDel) {
			this.datDel = datDel;
		}
		
		public String toString(){
			StringBuffer sb = new StringBuffer();
			sb.append("PATIENT - " + getId() + " - [");
			sb.append(getName());
			sb.append(", " + getSurname());
			sb.append(", " + getBirthdate());
			sb.append(", " + getDocument_number());
			sb.append(", " + getSex());
			sb.append(", " + getAddress());
			sb.append(", " + getCap());
			sb.append(", " + getCity());
			sb.append(", " + getRegion());
			sb.append(", " + getCountryCode());
			sb.append(", " + getUsl());
			sb.append(", " + getDatSubscription());
			sb.append(", " + getDatDel());
			sb.append("]");
						
			return sb.toString();
		}
}
