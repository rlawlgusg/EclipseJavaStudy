package com.sist.vo;

import java.util.Date;

public class CustomerInfoVO {
	private String cinemaName;
	private int cinemaNumber;
	private String title;
	private Date reservation;
	private int seatNumber;
	private int price;
	
	public CustomerInfoVO(String cinemaName, int cinemaNumber, String title, Date reservation, int seatNumber,
			int price) {
		super();
		this.cinemaName = cinemaName;
		this.cinemaNumber = cinemaNumber;
		this.title = title;
		this.reservation = reservation;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	public CustomerInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getCinemaNumber() {
		return cinemaNumber;
	}
	public void setCinemaNumber(int cinemaNumber) {
		this.cinemaNumber = cinemaNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReservation() {
		return reservation;
	}
	public void setReservation(Date reservation) {
		this.reservation = reservation;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
