package com.rj.wordpad.entity;

/**
 * Created by Auser on 2016/3/7.
 */
public class ButtonItem {
    private String buttonName;
    private String checkName;
    private Boolean isCheck;
    private int visibly;
    private int buttonSize;
    private int buttonColor;
    private int id;
    private int buttonWidth;
    private int buttonHeight;

    public ButtonItem(int buttonWidth, int buttonHeight) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
    }

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    @Override
    public String toString() {
        return "ButtonItem{" +
                "buttonName='" + buttonName + '\'' +
                ", checkName='" + checkName + '\'' +
                ", isCheck=" + isCheck +
                ", visibly=" + visibly +
                ", buttonSize=" + buttonSize +
                ", buttonColor=" + buttonColor +
                ", id=" + id +
                ", buttonWidth=" + buttonWidth +
                ", buttonHeight=" + buttonHeight +
                '}';
    }

    public ButtonItem(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getCheckName() {

        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public ButtonItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ButtonItem() {
    }

    public ButtonItem(String buttonName, Boolean isCheck) {
        this.buttonName = buttonName;
        this.isCheck = isCheck;
    }

    public ButtonItem(String buttonName, Boolean isCheck, int visibly, int buttonSize, int buttonColor) {
        this.buttonName = buttonName;
        this.isCheck = isCheck;
        this.visibly = visibly;
        this.buttonSize = buttonSize;
        this.buttonColor = buttonColor;
    }

    public String getButtonName() {

        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public int getVisibly() {
        return visibly;
    }

    public void setVisibly(int visibly) {
        this.visibly = visibly;
    }

    public int getButtonSize() {
        return buttonSize;
    }

    public void setButtonSize(int buttonSize) {
        this.buttonSize = buttonSize;
    }

    public int getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }
}
