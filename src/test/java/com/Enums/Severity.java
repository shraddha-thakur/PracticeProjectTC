package com.Enums;

public enum Severity {
	
	
	CRITICAL(2), MEDIUM(4), HIGH(6), LOW(8);
	
	private int fixingHours;

	private Severity(int hours) {
		fixingHours = hours;
	}

	public int getFixingHours() {
		return fixingHours;
	}

	public void setFixingHours(int fixingHours) {
		this.fixingHours = fixingHours;
	}


//	CRITICAL {
//		@Override
//		public String asLowerCase() {
//			return Severity.CRITICAL.toString().toLowerCase() ;
//		}
//	},
//	HIGH {
//		@Override
//		public String asLowerCase() {
//			return null;
//		}
//	},
//	MEDIUM {
//		@Override
//		public String asLowerCase() {
//			return null;
//		}
//	},
//	LOW {
//		@Override
//		public String asLowerCase() {
//			return null;
//		}
//	};
//
//	public abstract String asLowerCase();

}
