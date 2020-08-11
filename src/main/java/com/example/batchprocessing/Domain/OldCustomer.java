package com.example.batchprocessing.Domain;

public class OldCustomer {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthdate;

    public static OldCustomer.OldCustomerBuilder builder() {
        return new OldCustomer.OldCustomerBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(final String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OldCustomer)) {
            return false;
        } else {
            OldCustomer other = (OldCustomer)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label59;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label59;
                    }

                    return false;
                }

                Object this$firstName = this.getFirstName();
                Object other$firstName = other.getFirstName();
                if (this$firstName == null) {
                    if (other$firstName != null) {
                        return false;
                    }
                } else if (!this$firstName.equals(other$firstName)) {
                    return false;
                }

                Object this$lastName = this.getLastName();
                Object other$lastName = other.getLastName();
                if (this$lastName == null) {
                    if (other$lastName != null) {
                        return false;
                    }
                } else if (!this$lastName.equals(other$lastName)) {
                    return false;
                }

                Object this$birthdate = this.getBirthdate();
                Object other$birthdate = other.getBirthdate();
                if (this$birthdate == null) {
                    if (other$birthdate != null) {
                        return false;
                    }
                } else if (!this$birthdate.equals(other$birthdate)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OldCustomer;
    }

    public int hashCode() {
        //int PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $firstName = this.getFirstName();
        result = result * 59 + ($firstName == null ? 43 : $firstName.hashCode());
        Object $lastName = this.getLastName();
        result = result * 59 + ($lastName == null ? 43 : $lastName.hashCode());
        Object $birthdate = this.getBirthdate();
        result = result * 59 + ($birthdate == null ? 43 : $birthdate.hashCode());
        return result;
    }

    public String toString() {
        return "OldCustomer(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", birthdate=" + this.getBirthdate() + ")";
    }

    public OldCustomer(final Long id, final String firstName, final String lastName, final String birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public OldCustomer() {
    }

    public static class OldCustomerBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String birthdate;

        OldCustomerBuilder() {
        }

        public OldCustomer.OldCustomerBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public OldCustomer.OldCustomerBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public OldCustomer.OldCustomerBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public OldCustomer.OldCustomerBuilder birthdate(final String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public OldCustomer build() {
            return new OldCustomer(this.id, this.firstName, this.lastName, this.birthdate);
        }

        public String toString() {
            return "OldCustomer.OldCustomerBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthdate=" + this.birthdate + ")";
        }
    }
}