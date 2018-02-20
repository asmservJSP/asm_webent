/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.Models;

/**
 *
 * @author Minh
 */
public class News {
    
    private String id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private String date;

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(String date) {
        this.date = date;
    }

    private String title;

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private String details;

    /**
     * Get the value of details
     *
     * @return the value of details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set the value of details
     *
     * @param details new value of details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    private String category;

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    private String pathimage;

    /**
     * Get the value of pathimage
     *
     * @return the value of pathimage
     */
    public String getPathimage() {
        return pathimage;
    }

    /**
     * Set the value of pathimage
     *
     * @param pathimage new value of pathimage
     */
    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }

    public News(String id, String name, String date, String title, String description, String details, String category, String pathimage) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.title = title;
        this.description = description;
        this.details = details;
        this.category = category;
        this.pathimage = pathimage;
    }

    public News(String id, String name, String title, String description, String details, String category, String pathimage) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.details = details;
        this.category = category;
        this.pathimage = pathimage;
    }

   

}
