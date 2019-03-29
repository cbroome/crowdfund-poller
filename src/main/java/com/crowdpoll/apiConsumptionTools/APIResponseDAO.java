package com.crowdpoll.apiConsumptionTools;

import java.util.ArrayList;

public interface APIResponseDAO<T> {

    ArrayList<T> getItems();
}
