package com.solvd.internetshop.dao;

import com.solvd.internetshop.model.Shipment;


import java.util.List;

public interface IShipmentDao extends IBaseDao<Shipment> {
    List<Shipment> getAllShipments();
}
