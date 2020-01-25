package com.han.apple.pojo;

/**
 * Model表对应的实体类
 * 
 * @author ex-machina
 *
 */
public class Model {
	private Integer id;
	private String name;
	private String describe;
	private Integer price;
	private Integer type;
	private String showimg;

	public String getShowimg() {
		return showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
