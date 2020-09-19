package com.shiftedtech.spree.Util.Locators;

public class DriverFactoryNew extends DriverFactoryComponents{

    public static DriverFactoryNew instance;

    private DriverFactoryNew(){

    }


    public static DriverFactoryNew getInstance(){
        String browser=System.getenv("browser");
        System.out.println("Using Browser :" + browser);
        return getInstance(browser);

    }

    public static DriverFactoryNew getInstance(String browser){
        if(instance == null){
            instance = new DriverFactoryNew();
        }
        if (browser == null) {
            browser = "CHROME";
        }

        if(instance.driverCollection.get() == null) {

            System.out.println("Using browser: " + browser);

            if(browser.toUpperCase().contentEquals("FIREFOX")) {
                getFireFox();
            }
            else if(browser.toUpperCase().contentEquals("CHROME")) {
               getChrome();
            }
            else if(browser.toUpperCase().contentEquals("FIREFOX-HEADLESS")) {

            }
            else if(browser.toUpperCase().contentEquals("CHROME-HEADLESS")) {
              getChromeHeadless();
            }
            else if(browser.toUpperCase().contentEquals("FIREFOX-GRID")) {
              getFireFoxGrid();
            }
            else if(browser.toUpperCase().contentEquals("CHROME-GRID")) {
              getChromeGrid();
            }
            else if(browser.toUpperCase().contentEquals("FIREFOX-CLOUD")){
              getFireFoxCloud();
            }
            else if(browser.toUpperCase().contentEquals("CHROME-CLOUD")){
               getChromeCloud();
            }
            instance.driverCollection.set(driver);
        }
        return instance;
    }



}
