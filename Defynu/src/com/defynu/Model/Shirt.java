package com.defynu.Model;
import java.io.*; 

public class Shirt implements Serializable{                   /*extends AddMeasurement */

	public String body;
	private String button;
	private String buttonplacket;
	private String innercollar;
	public String outercollar;
	private String innercuff;
	private String outercuff;
	private String outsidefastening;
	private int price;
	private int qty=0;
	private int no=0;
	boolean a;
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getButtonplacket() {
		return buttonplacket;
	}

	public void setButtonplacket(String buttonplacket) {
		this.buttonplacket = buttonplacket;
	}

	public String getInnercollar() {
		return innercollar;
	}

	public void setInnercollar(String innercollar) {
		this.innercollar = innercollar;
	}

	public String getOutercollar() {
		return outercollar;
	}

	public void setOutercollar(String outercollar) {
		this.outercollar = outercollar;
	}

	public String getInnercuff() {
		return innercuff;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setInnercuff(String innercuff) {
		this.innercuff = innercuff;
	}

	public String getOutercuff() {
		return outercuff;
	}

	public void setOutercuff(String outercuff) {
		this.outercuff = outercuff;
	}

	public String getOutsidefastening() {
		return outsidefastening;
	}

	public void setOutsidefastening(String outsidefastening) {
		this.outsidefastening = outsidefastening;
	}
	
	

	//Constructor//
	public Shirt(){
		
		
	}
	
	public  Shirt(String body, String button, String buttonplacket,
			String innercollar, String outercollar, String innercuff,
			String outercuff, String outsidefastening , int price,int qty,int no) {
		this.body = body;
		this.button = button;
		this.buttonplacket = buttonplacket;
		this.innercollar = innercollar;
		this.outercollar = outercollar;
		this.innercuff = innercuff;
		this.outercuff = outercuff;
		this.outsidefastening = outsidefastening;
		this.price = price;

	}

	public boolean Display(Shirt shirt1) {

		System.out.println("the body id" + body);
		System.out.println("the outercollar id " + outercollar);
		System.out.println("the innercollor id " + innercollar);
		System.out.println("the outercuff id " + outercuff);
		System.out.println("the innercuff id " + innercuff);
		System.out.println("the button id " + button);
		System.out.println("the buttonplacket id " + buttonplacket);
		System.out.println("the outsidefastening id " + outsidefastening);
		// sht.add(shirt);

		return true;
	}

}
