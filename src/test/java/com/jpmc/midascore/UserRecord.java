//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.jpmc.midascore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserRecord extends com.jpmc.midascore.entity.UserRecord {
    public UserRecord(String waldorf, float v) {
    }

    @Entity
    public class UserRecord1 {
        @Id
        @GeneratedValue
        private long id;
        @Column(
                nullable = false
        )
        private String name;
        @Column(
                nullable = false
        )
        private float balance;

        protected UserRecord1() {
        }

        public UserRecord1(String name, float balance) {
            this.name = name;
            this.balance = balance;
        }

        public String toString() {
            return String.format("User[id=%d, name='%s', balance='%f'", this.id, this.name, this.balance);
        }

        public Long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public float getBalance() {
            return this.balance;
        }

        public void setBalance(float balance) {
            this.balance = balance;
        }
    }
}
