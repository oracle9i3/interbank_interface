package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by Svetlana Titova on 9/21/2016.
 */

@Entity
@Table(name ="staff")
public class Staff {

        @Id
        @Column(name="staff_id", columnDefinition = "TINYINT")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer staff_Id;

        @Column(name="first_name",columnDefinition="VARCHAR(45)")
        private String firstName;

        @Column(name="last_name",columnDefinition="VARCHAR(45)")
        private String lastName;

        @Column(name="username",columnDefinition ="VARCHAR(16)")
        private String username;


        public Integer getStaff_Id() {
                return staff_Id;
        }

        public void setStaff_Id(Integer staff_Id) {
                this.staff_Id = staff_Id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        @Override
        public String toString() {
                return "Staff{" +
                        "staff_Id=" + staff_Id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", username='" + username + '\'' +
                        '}';
        }
}
