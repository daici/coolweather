package com.coolweather.app.model;

public class Province {
	private int id;
	private String provinceName;
	private String provinceCode;

	/*
	 * get和set就是用来进行数据封装的，比如说province类，省名字和代号就是它的私有属性，
	 * 我们不可以通过其他途径对颜色和名字赋值或者取值，
	 * 要操作就必须先实例
	 * 
	 * 实体类的内容都非常简单，基本就是生成数据库表对应字段的 get和 set方
                法就可以了
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
}
