/*
 * Copyright 2016, collaboration Factory AG. All rights reserved.
 */

package cf.cplace.workshop.script;

import cf.cplace.platform.util.Gsonable;

/**
 * Created by groov on 03.11.2016.
 */
public class Employee extends Gsonable{

    final String href;
    final String name;

    public Employee(String href, String name) {
        this.href = href;
        this.name = name;
    }
}
