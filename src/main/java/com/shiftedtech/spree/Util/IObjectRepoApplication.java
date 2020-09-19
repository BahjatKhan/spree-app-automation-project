package com.shiftedtech.spree.Util;

import org.openqa.selenium.By;

public interface IObjectRepoApplication {


    void load(String...files);
    void reset();
    By getLocator(String key);





}
