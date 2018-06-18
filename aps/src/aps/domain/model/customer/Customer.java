package aps.domain.model.customer;

import java.util.Collection;
import java.util.Objects;

public class Customer {
    private int id;
    private String userName;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private Collection<CustomerBillingAccount> customerBillingAccounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<CustomerBillingAccount> getCustomerBillingAccounts() {
        return customerBillingAccounts;
    }

    public void setCustomerBillingAccounts(Collection<CustomerBillingAccount> customerBillingAccounts) {
        this.customerBillingAccounts = customerBillingAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(userName, customer.userName) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, firstName, surname, email, phoneNumber);
    }
}
