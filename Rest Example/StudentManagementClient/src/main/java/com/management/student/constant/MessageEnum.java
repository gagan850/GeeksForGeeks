package com.management.student.constant;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageEnum, contains the validation messages,
 * which is to be shown on UI, if any actions performed succesfully or completed with error.
 */
public enum MessageEnum {

    /** The invalid cridential. */
    INVALID_CRIDENTIAL("login.error"),
    
    /** The valid cridential. */
    VALID_CRIDENTIAL("login.success"),
    
    /** The student add success. */
    STUDENT_ADD_SUCCESS("student.add.success"),

    /** The student already exist. */
    STUDENT_ALREADY_EXIST("student.already.exist"),
    
    /** The student update success. */
    STUDENT_UPDATE_SUCCESS("student.update.success"),
    
    /** The student delete success. */
    STUDENT_DELETE_SUCCESS("student.delete.success"),

    /** The properties load successfully. */
    PROPERTIES_LOAD_SUCCESSFULLY("properties.load.success");

    /** The value. */
    String value;

    /**
     * Instantiates a new message enum.
     *
     * @param value the value
     */
    private MessageEnum(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    
    
}
