package com.management.student.constant;

/**
 * The Class Constant, contains the constants, are being used in student management application.
 * Final , should not get extended.
 * Private Constructor, To restrict the instantiation of the class 
 */
public final class Constant {

    /** The Constant DB_PROPERTIES_FILE_PATH. */
    public static final String DB_PROPERTIES_FILE_PATH = "DBProp.properties";

    /** The Constant MESSAGES_FILE_PATH. */
    public static final String MESSAGES_EN_FILE_PATH = "message.properties";
    
    /** The Constant MESSAGES_CN_FILE_PATH. */
    public static final String MESSAGES_CN_FILE_PATH = "message_zh_CN.properties";

    
    /** The Constant STATUS. */
    public static final String STATUS = "status";
    
    /** The Constant SUCCESS. */
    public static final String SUCCESS = "success";
    
    /** The Constant ERROR. */
    public static final String ERROR = "error";
    
    /** The Constant MESSAGE. */
    public static final String MESSAGE = "message";
    
    /** The Constant INVALID_CRIDENTIAL. */
    public static final String INVALID_CRIDENTIAL = "Invalid Cridentials";
    
    /** The Constant STUDENT_UPDATED_SUCCESSFULLY. */
    public static final String STUDENT_UPDATED_SUCCESSFULLY = "Student updated successfully";

    /** The Constant STUDENT_DELETED_SUCCESSFULLY. */
    public static final String STUDENT_DELETED_SUCCESSFULLY = "Student deleted successfully";
    
    /** The Constant STUDENT_ADDED_SUCCESSFULLY. */
    public static final String STUDENT_ADDED_SUCCESSFULLY = "Student added successfully";

    /**
     * Instantiates a new constant.
     */
    private Constant () {
        
    }

}
