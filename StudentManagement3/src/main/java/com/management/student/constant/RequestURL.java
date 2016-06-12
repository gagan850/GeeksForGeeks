package com.management.student.constant;

/**
 * The Class RequestURL, contains the requesteds URL.
 * Final , should not get extended.
 * Private Constructor, To restrict the instantiation of the class
 */
public final class RequestURL {

    /** The Constant STUDENTS_LIST. */
    public static final String STUDENTS_LIST = "/students/list";

    /** The Constant STUDENTS_PAGINATION. */
    public static final String STUDENTS_PAGINATION = "/students/pagination";

    /** The Constant LOGIN. */
    public static final String LOGIN = "/login";

    /** The Constant ADD_STUDENT. */
    public static final String ADD_STUDENT = "/students/add";

    /** The Constant SAVE_STUDENT. */
    public static final String SAVE_STUDENT = "/students/save/{rollNumber}";

    /** The Constant LOG_OUT. */
    public static final String LOG_OUT = "/logout";

    /** The Constant UPDATE_LIST. */
    public static final String UPDATE_STUDENT = "/students/update/{rollNumber}";

    /** The Constant DELETE_LIST. */
    public static final String REMOVE_STUDENT = "/students/remove/{rollNumber}";

    /** The Constant RELOAD_PROPERTIES. */
    public static final String RELOAD_PROPERTIES = "/reloadProperties";

    /**
     * Instantiates a new request url.
     */
    private RequestURL() {

    }
}
