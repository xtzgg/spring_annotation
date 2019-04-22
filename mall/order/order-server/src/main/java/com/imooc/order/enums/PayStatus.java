package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum  PayStatus {
		WAIT(0,"等待支付"),
		SUCCESS(1,"支付成功"),
		;
		private Integer status;
		private String msg;
		PayStatus(Integer status,String msg){
				this.status=status;
				this.msg=msg;
		}
}
