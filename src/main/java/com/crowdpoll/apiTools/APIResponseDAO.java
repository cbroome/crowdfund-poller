package com.crowdpoll.apiTools;

import java.util.ArrayList;

public interface APIResponseDAO<T> {

    ArrayList<T> getItems();
}
