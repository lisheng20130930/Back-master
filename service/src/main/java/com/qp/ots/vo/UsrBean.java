package com.qp.ots.vo;

import java.util.List;

/**
 * @author Listen.Li
 * @date 2020/01/02
 */
public class UsrBean {
	private String name  = null;	
	private String nation = null;
	private String idCard = null;
	private String address = null;
	private String gender = null;
	private int age = 0;
	private String marriage = null;
	private String children = null;
	private String education = null;
	private int overseas = 0;
	private int phoneNumUse = 0;
	private String phoneNumber = null;
	private String house = null;
	private String loanType = null;
	private String houseAddr = null;
	private String houseOwnership = null;
	private int houseValue = 0;
	private String carPlace = null;
	private int resident = 0;
	private String industry = null;
	private String unitType = null;
	private String job = null;
	private String jobLevel = null;
	private int jobPeriod = 0;
	private int curPeriod = 0;
	private int salary = 0;
	private int repayment = 0;
	private int deposit = 0;
	private String unitAddr = null;
	private List<ContractBean> contracts = null;
	private String bankAudit = null;
	private String certification = null;
	private String faceRec = null;
	private List<String> policeHZs = null;
	private List<String> policeHis = null;
	private List<String> courtHis = null;
	private List<String> debit = null;
	private List<String> overdue = null;

	public static class ContractBean {
		private String name;
		private String phoneNumber;
		private String relationShip;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getPhoneNumber() {
			return this.phoneNumber;
		}

		public void setRelationShip(String relationShip) {
			this.relationShip = relationShip;
		}

		public String getRelationShip() {
			return this.relationShip;
		}
		
		@Override
		public String toString() {
			return "{name="+this.name+",phoneNumber="+this.phoneNumber+",relationShip="+this.relationShip+"}";
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getChildren() {
		return children;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation() {
		return education;
	}

	public void setOverseas(int overseas) {
		this.overseas = overseas;
	}

	public int getOverseas() {
		return overseas;
	}

	public void setPhoneNumUse(int phoneNumUse) {
		this.phoneNumUse = phoneNumUse;
	}

	public int getPhoneNumUse() {
		return phoneNumUse;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getHouse() {
		return house;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	public String getHouseAddr() {
		return houseAddr;
	}

	public void setHouseOwnership(String houseOwnership) {
		this.houseOwnership = houseOwnership;
	}

	public String getHouseOwnership() {
		return houseOwnership;
	}

	public void setHouseValue(int houseValue) {
		this.houseValue = houseValue;
	}

	public int getHouseValue() {
		return houseValue;
	}

	public void setCarPlace(String carPlace) {
		this.carPlace = carPlace;
	}

	public String getCarPlace() {
		return carPlace;
	}

	public void setResident(int resident) {
		this.resident = resident;
	}

	public int getResident() {
		return resident;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIndustry() {
		return industry;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobPeriod(int jobPeriod) {
		this.jobPeriod = jobPeriod;
	}

	public int getJobPeriod() {
		return jobPeriod;
	}

	public void setCurPeriod(int curPeriod) {
		this.curPeriod = curPeriod;
	}

	public int getCurPeriod() {
		return curPeriod;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setRepayment(int repayment) {
		this.repayment = repayment;
	}

	public int getRepayment() {
		return repayment;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setUnitAddr(String unitAddr) {
		this.unitAddr = unitAddr;
	}

	public String getUnitAddr() {
		return unitAddr;
	}

	public List<ContractBean> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContractBean> contracts) {
		this.contracts = contracts;
	}

	public String getBankAudit() {
		return bankAudit;
	}

	public void setBankAudit(String bankAudit) {
		this.bankAudit = bankAudit;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getFaceRec() {
		return faceRec;
	}

	public void setFaceRec(String faceRec) {
		this.faceRec = faceRec;
	}

	public List<String> getPoliceHZs() {
		return policeHZs;
	}

	public void setPoliceHZs(List<String> policeHZs) {
		this.policeHZs = policeHZs;
	}

	public List<String> getPoliceHis() {
		return policeHis;
	}

	public void setPoliceHis(List<String> policeHis) {
		this.policeHis = policeHis;
	}

	public List<String> getCourtHis() {
		return courtHis;
	}

	public void setCourtHis(List<String> courtHis) {
		this.courtHis = courtHis;
	}

	public List<String> getDebit() {
		return debit;
	}

	public void setDebit(List<String> debit) {
		this.debit = debit;
	}

	public List<String> getOverdue() {
		return overdue;
	}

	public void setOverdue(List<String> overdue) {
		this.overdue = overdue;
	}
	
	@Override
	public String toString() {
		return "{idCard="+this.getIdCard()
			+",name="+this.getName()
			+",nation="+this.getNation()
			+",address="+this.getAddress()
			+",gender="+this.getGender()
			+",age="+this.getAge()
			+",marriage="+this.getMarriage()
			+",children="+this.getChildren()
			+",education="+this.getEducation()
			+",overseas="+this.getOverseas()
			+",phoneNumUse="+this.getPhoneNumUse()
			+",phoneNumber="+this.getPhoneNumber()
			+",house="+this.getHouse()
			+",loanType="+this.getLoanType()
			+",houseAddr="+this.getHouseAddr()
			+",houseOwnership="+this.getHouseOwnership()
			+",houseValue="+this.getHouseValue()
			+",carPlace="+this.getCarPlace()
			+",resident="+this.getResident()
			+",industry="+this.getIndustry()
			+",unitType="+this.getUnitType()
			+",job="+this.getJob()
			+",jobLevel="+this.getJobLevel()
			+",jobPeriod="+this.getJobPeriod()
			+",curPeriod="+this.getCurPeriod()
			+",salary="+this.getSalary()
			+",repayment="+this.getRepayment()			
			+",unitAddr="+this.getUnitAddr()
			+",deposit="+this.getDeposit()
			+",contracts="+this.getContracts()
			+",bankAudit="+this.getBankAudit()
			+",certification="+this.getCertification()
			+",faceRec="+this.getFaceRec()			
			+"}";
	}
}
