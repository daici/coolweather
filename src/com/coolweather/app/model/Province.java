package com.coolweather.app.model;

public class Province {
	private int id;
	private String provinceName;
	private String provinceCode;

	/*
	 * get��set���������������ݷ�װ�ģ�����˵province�࣬ʡ���ֺʹ��ž�������˽�����ԣ�
	 * ���ǲ�����ͨ������;������ɫ�����ָ�ֵ����ȡֵ��
	 * Ҫ�����ͱ�����ʵ��
	 * 
	 * ʵ��������ݶ��ǳ��򵥣����������������ݿ���Ӧ�ֶε� get�� set��
                ���Ϳ�����
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
