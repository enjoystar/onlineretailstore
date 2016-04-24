package com.onlineretail;

public enum MenuOption {
	ADD_PRODUCT(1), DISPLAY_PRODUCTS(2), TOTAL_BILL(3),EXIT(4);
	private final int value;

	private MenuOption(int value) {
		this.value = value;
	}
	
	public int getValue() {
        return value;
    }
}
