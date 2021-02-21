package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import org.joda.time.LocalDateTime;
import studie.three.o.eight.management.domain.persistence.formatter.LocalDateTimeFormatter;

@DynamoDBDocument
public class Planning {

    @DynamoDBAttribute(attributeName = "PortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime portraitDate;
    @DynamoDBAttribute(attributeName = "NaturePortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime naturePortraitDate;
    @DynamoDBAttribute(attributeName = "GroupPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime groupPhotoDate;
    @DynamoDBAttribute(attributeName = "StaffPortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime staffPortraitDate;
    @DynamoDBAttribute(attributeName = "StaffGroupDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime staffGroupDate;
    @DynamoDBAttribute(attributeName = "TotalPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime totalPhotoDate;
    @DynamoDBAttribute(attributeName = "AirPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime airPhotoDate;
    @DynamoDBAttribute(attributeName = "IntroVideoDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime introVideoDate;
    @DynamoDBAttribute(attributeName = "ConfirmDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime confirmDate;
    @DynamoDBAttribute(attributeName = "SignupMaterialDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime signupMaterialDate;
    @DynamoDBAttribute(attributeName = "UpdateEmailDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime updateEmailDate;
    @DynamoDBAttribute(attributeName = "DueDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime dueDate;
    @DynamoDBAttribute(attributeName = "SendPackageDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime sendPackageDate;
    @DynamoDBAttribute(attributeName = "ExpirationDate")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime expirationDate;
    @DynamoDBAttribute(attributeName = "PosterCount")
    private int posterCount;
    @DynamoDBAttribute(attributeName = "FlyerCount")
    private int flyerCount;
    @DynamoDBAttribute(attributeName = "Year")
    private int year;

    public LocalDateTime getPortraitDate() {
        return portraitDate;
    }

    public void setPortraitDate(LocalDateTime portraitDate) {
        this.portraitDate = portraitDate;
    }

    public LocalDateTime getNaturePortraitDate() {
        return naturePortraitDate;
    }

    public void setNaturePortraitDate(LocalDateTime naturePortraitDate) {
        this.naturePortraitDate = naturePortraitDate;
    }

    public LocalDateTime getGroupPhotoDate() {
        return groupPhotoDate;
    }

    public void setGroupPhotoDate(LocalDateTime groupPhotoDate) {
        this.groupPhotoDate = groupPhotoDate;
    }

    public LocalDateTime getStaffPortraitDate() {
        return staffPortraitDate;
    }

    public void setStaffPortraitDate(LocalDateTime staffPortraitDate) {
        this.staffPortraitDate = staffPortraitDate;
    }

    public LocalDateTime getStaffGroupDate() {
        return staffGroupDate;
    }

    public void setStaffGroupDate(LocalDateTime staffGroupDate) {
        this.staffGroupDate = staffGroupDate;
    }

    public LocalDateTime getTotalPhotoDate() {
        return totalPhotoDate;
    }

    public void setTotalPhotoDate(LocalDateTime totalPhotoDate) {
        this.totalPhotoDate = totalPhotoDate;
    }

    public LocalDateTime getAirPhotoDate() {
        return airPhotoDate;
    }

    public void setAirPhotoDate(LocalDateTime airPhotoDate) {
        this.airPhotoDate = airPhotoDate;
    }

    public LocalDateTime getIntroVideoDate() {
        return introVideoDate;
    }

    public void setIntroVideoDate(LocalDateTime introVideoDate) {
        this.introVideoDate = introVideoDate;
    }

    public LocalDateTime getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(LocalDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }

    public LocalDateTime getSignupMaterialDate() {
        return signupMaterialDate;
    }

    public void setSignupMaterialDate(LocalDateTime signupMaterialDate) {
        this.signupMaterialDate = signupMaterialDate;
    }

    public LocalDateTime getUpdateEmailDate() {
        return updateEmailDate;
    }

    public void setUpdateEmailDate(LocalDateTime updateEmailDate) {
        this.updateEmailDate = updateEmailDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getSendPackageDate() {
        return sendPackageDate;
    }

    public void setSendPackageDate(LocalDateTime sendPackageDate) {
        this.sendPackageDate = sendPackageDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPosterCount() {
        return posterCount;
    }

    public void setPosterCount(int posterCount) {
        this.posterCount = posterCount;
    }

    public int getFlyerCount() {
        return flyerCount;
    }

    public void setFlyerCount(int flyerCount) {
        this.flyerCount = flyerCount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "portraitDate=" + portraitDate +
                ", naturePortraitDate=" + naturePortraitDate +
                ", groupPhotoDate=" + groupPhotoDate +
                ", staffPortraitDate=" + staffPortraitDate +
                ", staffGroupDate=" + staffGroupDate +
                ", totalPhotoDate=" + totalPhotoDate +
                ", airPhotoDate=" + airPhotoDate +
                ", introVideoDate=" + introVideoDate +
                ", confirmDate=" + confirmDate +
                ", signupMaterialDate=" + signupMaterialDate +
                ", updateEmailDate=" + updateEmailDate +
                ", dueDate=" + dueDate +
                ", sendPackageDate=" + sendPackageDate +
                ", expirationDate=" + expirationDate +
                ", posterCount=" + posterCount +
                ", flyerCount=" + flyerCount +
                ", year=" + year +
                '}';
    }
}
