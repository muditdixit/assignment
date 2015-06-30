package com.talentica.processFlow;

public enum Service {
	
	ONES(1),TWOS(2),THREES(3),FOURS(4),FIVES(5),SIXS(6),SEVENS(7),EIGHTS(8),NINES(9);
	
	Service(int no){
		this.no=no;
	}
	
	private int no;
	
	public int getNo() {
		return no;
	}
}
