package com.krishna.dto;

public class Customer
{
	    private String cusName;
		private String cusAddress;
		private String panCard;
		private String accountNo;
		private String mobileNo;
		
		public String getCusName() {
			return cusName;
		}
		public void setCusName(String cusName) {
			this.cusName = cusName;
		}
		public String getCusAddress() {
			return cusAddress;
		}
		public void setCusAddress(String cusAddress) {
			this.cusAddress = cusAddress;
		}
		public String getPanCard() {
			return panCard;
		}
		public void setPanCard(String panCard) {
			this.panCard = panCard;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		@Override
		public String toString() {
			return "Customer [cusName=" + cusName + ", cusAddress=" + cusAddress + ", panCard=" + panCard
					+ ", accountNo=" + accountNo + ", mobileNo=" + mobileNo + "]";
		}
		
		
}


