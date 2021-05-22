package com.chklab.logic;

import com.chklab.lifecycle.StoreLifeCycle;
import org.springframework.stereotype.Service;

@Service
public class TodoListSpringLogic extends TodoListLogic {
    public TodoListSpringLogic(StoreLifeCycle storeLifeCycle) {
        super(storeLifeCycle);
    }
}
