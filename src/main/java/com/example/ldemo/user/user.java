package com.example.ldemo.user;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long cid;
    @Column(unique = true)
    private Long lid;
    @Column
    private Integer amount;
    @Column
    private Integer ramount;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    @Column
    private Double interest;
    @Temporal(TemporalType.DATE)
    private Calendar duedate;
    @Column
    private Double penalty;
    @Column
    private String cancel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRamount() {
        return ramount;
    }

    public void setRamount(Integer ramount) {
        this.ramount = ramount;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Calendar getDuedate() {
        return duedate;
    }

    public void setDuedate(Calendar duedate) {
        this.duedate = duedate;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", cid=" + cid +
                ", lid=" + lid +
                ", amount=" + amount +
                ", ramount=" + ramount +
                ", date=" + date +
                ", interest=" + interest +
                ", duedate=" + duedate +
                ", penalty=" + penalty +
                ", cancel='" + cancel + '\'' +
                '}';
    }
}
