package com.jcloisterzone;

/**
 * Various application constants.
 * @author Roman Krejcik
 */
public interface Application {

    public String VERSION = "2.2-devel";
    public String BUILD_DATE = "2013-XX-XX";

    public int PROTCOL_VERSION = 12;

    public static final String ILLEGAL_STATE_MSG = "Method '{}' called in invalid state";
}
