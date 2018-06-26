package aps.domain.model.customer;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Customer {
    private int id;
    private String apsUserName;
    private String apsPassword;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private List<CustomerBillingAccount> customerBillingAccounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApsPassword() {
        return apsPassword;
    }

    public void setApsPassword(String apsPassword) {
        this.apsPassword = apsPassword;
    }

    public String getApsUserName() {
        return apsUserName;
    }

    public void setApsUserName(String apsUserName) {
        this.apsUserName = apsUserName;
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

    public void setCustomerBillingAccounts(List<CustomerBillingAccount> customerBillingAccounts) {
        this.customerBillingAccounts = customerBillingAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(apsUserName, customer.apsUserName) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, apsUserName, firstName, surname, email, phoneNumber);
    }
}
