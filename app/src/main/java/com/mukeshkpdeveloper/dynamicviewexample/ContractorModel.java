package com.mukeshkpdeveloper.dynamicviewexample;

import java.util.ArrayList;
import java.util.List;

public class ContractorModel {
    int pid;
    String contractorName;
    String contactNo;
    String type;

    public ContractorModel() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<ContractorModel> fillCustomer(){
        List<ContractorModel> customerList = new ArrayList<>();
        for(int i=0; i<1000; i++){
            ContractorModel customer = new ContractorModel();
            customer.setPid(i);
            customer.setContractorName("Name"+i);
            customerList.add(customer);
        }
        return customerList;

    }
}

