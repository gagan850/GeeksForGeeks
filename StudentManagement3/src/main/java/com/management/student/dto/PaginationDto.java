package com.management.student.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginationDto.
 */
public class PaginationDto {

    /** The text to search. */
    String textToSearch;

    /** The column to sort. */
    int columnToSort;

    /** The sorting dir. */
    int sortingDir;

    /** The display start. */
    int displayStart;

    /** The display length. */
    int displayLength;

    /** The first iteration. */
    boolean firstIteration;

    /**
     * Gets the text to search.
     *
     * @return the text to search
     */
    public String getTextToSearch() {
        return this.textToSearch;
    }

    /**
     * Sets the text to search.
     *
     * @param textToSearch the new text to search
     */
    public void setTextToSearch(String textToSearch) {
        this.textToSearch = textToSearch;
    }


    /**
     * Gets the column to sort.
     *
     * @return the column to sort
     */
    public int getColumnToSort() {
        return this.columnToSort;
    }

    /**
     * Sets the column to sort.
     *
     * @param columnToSort the new column to sort
     */
    public void setColumnToSort(int columnToSort) {
        this.columnToSort = columnToSort;
    }

    /**
     * Gets the sorting dir.
     *
     * @return the sorting dir
     */
    public int getSortingDir() {
        return this.sortingDir;
    }

    /**
     * Sets the sorting dir.
     *
     * @param sortingDir the new sorting dir
     */
    public void setSortingDir(int sortingDir) {
        this.sortingDir = sortingDir;
    }

    /**
     * Gets the display start.
     *
     * @return the display start
     */
    public int getDisplayStart() {
        return this.displayStart;
    }

    /**
     * Sets the display start.
     *
     * @param displayStart the new display start
     */
    public void setDisplayStart(int displayStart) {
        this.displayStart = displayStart;
    }

    /**
     * Gets the display length.
     *
     * @return the display length
     */
    public int getDisplayLength() {
        return this.displayLength;
    }

    /**
     * Sets the display length.
     *
     * @param displayLength the new display length
     */
    public void setDisplayLength(int displayLength) {
        this.displayLength = displayLength;
    }


    /**
     * Checks if is first iteration.
     *
     * @return true, if is first iteration
     */
    public boolean isFirstIteration() {
        return this.firstIteration;
    }

    /**
     * Sets the first iteration.
     *
     * @param firstIteration the new first iteration
     */
    public void setFirstIteration(boolean firstIteration) {
        this.firstIteration = firstIteration;
    }

    /**
     * Instantiates a new pagination dto.
     *
     * @param textToSearch the text to search
     * @param columnToSort the column to sort
     * @param sortingDir the sorting dir
     * @param displayStart the display start
     * @param displayLength the display length
     */
    public PaginationDto(String textToSearch, String columnToSort, String sortingDir, String displayStart,
        String displayLength) {
        super();
        if (columnToSort == null) {
            setFirstIteration(true);
        } else {

            if (textToSearch == null || textToSearch.isEmpty()) {
                this.textToSearch = null;

            } else {
                this.textToSearch = textToSearch;

            }
            this.columnToSort = Integer.parseInt(columnToSort);

            if (sortingDir.equals("asc")) {
                this.sortingDir = 0;
            } else {
                this.sortingDir = 1;
            }

            this.displayStart = Integer.parseInt(displayStart);
            this.displayLength = Integer.parseInt(displayLength);
        }

    }


}
