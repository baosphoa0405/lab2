/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baotpg.users;

/**
 *
 * @author Admin
 */
public class UsersError {

    private String errorID, errorIDlength, errorIDformat, errorName, errorNameFormat,
            errorNameLength, errorPassword, errorPasswordLength,
            errorEmail, errorEmailFormat, errorEmailLength, errorPhone, errorPhoneFormat, errorPhoneLength,
            errorPhoto, errorLogin, errorConfirm, errorRePassword, errorIDduplicate;

    public UsersError(String errorID, String errorIDlength, String errorIDformat, String errorName, String errorNameFormat, String errorNameLength, String errorPassword, String errorPasswordLength, String errorEmail, String errorEmailFormat, String errorEmailLength, String errorPhone, String errorPhoneFormat, String errorPhoneLength, String errorPhoto, String errorLogin, String errorConfirm, String errorRePassword, String errorIDduplicate) {
        this.errorID = errorID;
        this.errorIDlength = errorIDlength;
        this.errorIDformat = errorIDformat;
        this.errorName = errorName;
        this.errorNameFormat = errorNameFormat;
        this.errorNameLength = errorNameLength;
        this.errorPassword = errorPassword;
        this.errorPasswordLength = errorPasswordLength;
        this.errorEmail = errorEmail;
        this.errorEmailFormat = errorEmailFormat;
        this.errorEmailLength = errorEmailLength;
        this.errorPhone = errorPhone;
        this.errorPhoneFormat = errorPhoneFormat;
        this.errorPhoneLength = errorPhoneLength;
        this.errorPhoto = errorPhoto;
        this.errorLogin = errorLogin;
        this.errorConfirm = errorConfirm;
        this.errorRePassword = errorRePassword;
        this.errorIDduplicate = errorIDduplicate;
    }

    public String getErrorPhoneLength() {
        return errorPhoneLength;
    }

    public void setErrorPhoneLength(String errorPhoneLength) {
        this.errorPhoneLength = errorPhoneLength;
    }

    public String getErrorIDformat() {
        return errorIDformat;
    }

    public void setErrorIDformat(String errorIDformat) {
        this.errorIDformat = errorIDformat;
    }

    public String getErrorEmailLength() {
        return errorEmailLength;
    }

    public void setErrorEmailLength(String errorEmailLength) {
        this.errorEmailLength = errorEmailLength;
    }

    public String getErrorIDlength() {
        return errorIDlength;
    }

    public void setErrorIDlength(String errorIDlength) {
        this.errorIDlength = errorIDlength;
    }

    public String getErrorNameFormat() {
        return errorNameFormat;
    }

    public void setErrorNameFormat(String errorNameFormat) {
        this.errorNameFormat = errorNameFormat;
    }

    public String getErrorNameLength() {
        return errorNameLength;
    }

    public void setErrorNameLength(String errorNameLength) {
        this.errorNameLength = errorNameLength;
    }

    public String getErrorPasswordLength() {
        return errorPasswordLength;
    }

    public void setErrorPasswordLength(String errorPasswordLength) {
        this.errorPasswordLength = errorPasswordLength;
    }

    public String getErrorEmailFormat() {
        return errorEmailFormat;
    }

    public void setErrorEmailFormat(String errorEmailFormat) {
        this.errorEmailFormat = errorEmailFormat;
    }

    public String getErrorPhoneFormat() {
        return errorPhoneFormat;
    }

    public void setErrorPhoneFormat(String errorPhoneFormat) {
        this.errorPhoneFormat = errorPhoneFormat;
    }

    public String getErrorIDduplicate() {
        return errorIDduplicate;
    }

    public void setErrorIDduplicate(String errorIDduplicate) {
        this.errorIDduplicate = errorIDduplicate;
    }

    public String getErrorRePassword() {
        return errorRePassword;
    }

    public void setErrorRePassword(String errorRePassword) {
        this.errorRePassword = errorRePassword;
    }

    public String getErrorLogin() {
        return errorLogin;
    }

    public String getErrorConfirm() {
        return errorConfirm;
    }

    public void setErrorConfirm(String errorConfirm) {
        this.errorConfirm = errorConfirm;
    }

    public void setErrorLogin(String errorLogin) {
        this.errorLogin = errorLogin;
    }

    @Override
    public String toString() {
        return "UsersError{" + "errorID=" + errorID + ", errorIDlength=" + errorIDlength + ", errorIDformat=" + errorIDformat + ", errorName=" + errorName + ", errorNameFormat=" + errorNameFormat + ", errorNameLength=" + errorNameLength + ", errorPassword=" + errorPassword + ", errorPasswordLength=" + errorPasswordLength + ", errorEmail=" + errorEmail + ", errorEmailFormat=" + errorEmailFormat + ", errorEmailLength=" + errorEmailLength + ", errorPhone=" + errorPhone + ", errorPhoneFormat=" + errorPhoneFormat + ", errorPhoneLength=" + errorPhoneLength + ", errorPhoto=" + errorPhoto + ", errorLogin=" + errorLogin + ", errorConfirm=" + errorConfirm + ", errorRePassword=" + errorRePassword + ", errorIDduplicate=" + errorIDduplicate + '}';
    }

  

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public String getErrorPhone() {
        return errorPhone;
    }

    public void setErrorPhone(String errorPhone) {
        this.errorPhone = errorPhone;
    }

    public String getErrorPhoto() {
        return errorPhoto;
    }

    public void setErrorPhoto(String errorPhoto) {
        this.errorPhoto = errorPhoto;
    }

}
