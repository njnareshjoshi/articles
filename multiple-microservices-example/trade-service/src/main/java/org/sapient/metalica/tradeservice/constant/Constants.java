package org.sapient.metalica.tradeservice.constant;

public interface Constants {

    String TRADE_EXCHANGE = "trade";

    String TRADE_CREATE_QUEUE = "api.trade.cmd.create";
    String TRADE_UPDATE_QUEUE = "api.trade.cmd.update";
    String TRADE_DELETE_QUEUE = "api.trade.cmd.delete";

    String TRADE_CREATED_QUEUE = "api.trade.event.created";
    String TRADE_UPDATED_QUEUE = "api.trade.event.updated";
    String TRADE_DELETED_QUEUE = "api.trade.event.deleted";

    String TRADE_DATA_GET_QUEUE = "trade.data.get";

}
