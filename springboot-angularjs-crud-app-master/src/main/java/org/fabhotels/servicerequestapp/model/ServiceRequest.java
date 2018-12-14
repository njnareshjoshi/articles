package org.fabhotels.servicerequestapp.model;

import org.fabhotels.servicerequestapp.constants.ServiceRequestStatus;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.TIMESTAMP;
import static org.fabhotels.servicerequestapp.constants.ServiceRequestStatus.PENDING;

/**
 * @author Naresh Joshi
 */

@Entity
public class ServiceRequest {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    @Enumerated(STRING)
    private ServiceRequestStatus status = PENDING;

    // As of now keeping as a string but needs to be fetched from master data
    @Column
    private String hotel;

    // As of now keeping as a string but needs to be fetched from master data
    @Column
    private String roomNo;

    @Column
    private String customerName;

    @Column
    @Temporal(TIMESTAMP)
    private Date requestTime = new Date();

    public ServiceRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceRequestStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceRequestStatus status) {
        this.status = status;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", hotel='" + hotel + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", requestTime=" + requestTime +
                '}';
    }

}