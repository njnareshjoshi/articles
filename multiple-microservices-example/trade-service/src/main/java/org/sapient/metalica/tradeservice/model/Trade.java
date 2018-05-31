package org.sapient.metalica.tradeservice.model;

import org.sapient.metalica.tradeservice.constant.TradeSide;
import org.sapient.metalica.tradeservice.dto.RefDataDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class Trade {

    @Id private String id;
    @Field private Date date;
    @Field private double price;
    @Field private long quantity;
    @Field private TradeSide side;
    @Field private RefDataDTO commodity;
    @Field private RefDataDTO counterParty;
    @Field private RefDataDTO location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public TradeSide getSide() {
        return side;
    }

    public void setSide(TradeSide side) {
        this.side = side;
    }

    public RefDataDTO getCommodity() {
        return commodity;
    }

    public void setCommodity(RefDataDTO commodity) {
        this.commodity = commodity;
    }

    public RefDataDTO getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(RefDataDTO counterParty) {
        this.counterParty = counterParty;
    }

    public RefDataDTO getLocation() {
        return location;
    }

    public void setLocation(RefDataDTO location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (Double.compare(trade.price, price) != 0) return false;
        if (quantity != trade.quantity) return false;
        if (id != null ? !id.equals(trade.id) : trade.id != null) return false;
        if (date != null ? !date.equals(trade.date) : trade.date != null) return false;
        if (side != trade.side) return false;
        if (commodity != null ? !commodity.equals(trade.commodity) : trade.commodity != null) return false;
        if (counterParty != null ? !counterParty.equals(trade.counterParty) : trade.counterParty != null) return false;
        return location != null ? location.equals(trade.location) : trade.location == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        result = 31 * result + (side != null ? side.hashCode() : 0);
        result = 31 * result + (commodity != null ? commodity.hashCode() : 0);
        result = 31 * result + (counterParty != null ? counterParty.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
