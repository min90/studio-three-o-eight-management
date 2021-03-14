package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import org.joda.time.LocalDate;
import studie.three.o.eight.management.domain.persistence.formatter.LocalDateFormatter;

@DynamoDBDocument
public class Planning {

    @DynamoDBAttribute(attributeName = "PortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate portraitDate;
    @DynamoDBAttribute(attributeName = "NaturePortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate naturePortraitDate;
    @DynamoDBAttribute(attributeName = "GroupPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate groupPhotoDate;
    @DynamoDBAttribute(attributeName = "StaffPortraitDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate staffPortraitDate;
    @DynamoDBAttribute(attributeName = "StaffGroupDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate staffGroupDate;
    @DynamoDBAttribute(attributeName = "TotalPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate totalPhotoDate;
    @DynamoDBAttribute(attributeName = "AirPhotoDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate airPhotoDate;
    @DynamoDBAttribute(attributeName = "IntroVideoDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate introVideoDate;
    @DynamoDBAttribute(attributeName = "ConfirmDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate confirmDate;
    @DynamoDBAttribute(attributeName = "SignupMaterialDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate signupMaterialDate;
    @DynamoDBAttribute(attributeName = "UpdateEmailDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate updateEmailDate;
    @DynamoDBAttribute(attributeName = "DueDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate dueDate;
    @DynamoDBAttribute(attributeName = "SendPackageDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate sendPackageDate;
    @DynamoDBAttribute(attributeName = "ExpirationDate")
    @DynamoDBTypeConverted(converter = LocalDateFormatter.class)
    private LocalDate expirationDate;
    @DynamoDBAttribute(attributeName = "PosterCount")
    private int posterCount;
    @DynamoDBAttribute(attributeName = "FlyerCount")
    private int flyerCount;
    @DynamoDBAttribute(attributeName = "Year")
    private int year;

    public LocalDate getPortraitDate() {
        return portraitDate;
    }

    public void setPortraitDate(LocalDate portraitDate) {
        this.portraitDate = portraitDate;
    }

    public LocalDate getNaturePortraitDate() {
        return naturePortraitDate;
    }

    public void setNaturePortraitDate(LocalDate naturePortraitDate) {
        this.naturePortraitDate = naturePortraitDate;
    }

    public LocalDate getGroupPhotoDate() {
        return groupPhotoDate;
    }

    public void setGroupPhotoDate(LocalDate groupPhotoDate) {
        this.groupPhotoDate = groupPhotoDate;
    }

    public LocalDate getStaffPortraitDate() {
        return staffPortraitDate;
    }

    public void setStaffPortraitDate(LocalDate staffPortraitDate) {
        this.staffPortraitDate = staffPortraitDate;
    }

    public LocalDate getStaffGroupDate() {
        return staffGroupDate;
    }

    public void setStaffGroupDate(LocalDate staffGroupDate) {
        this.staffGroupDate = staffGroupDate;
    }

    public LocalDate getTotalPhotoDate() {
        return totalPhotoDate;
    }

    public void setTotalPhotoDate(LocalDate totalPhotoDate) {
        this.totalPhotoDate = totalPhotoDate;
    }

    public LocalDate getAirPhotoDate() {
        return airPhotoDate;
    }

    public void setAirPhotoDate(LocalDate airPhotoDate) {
        this.airPhotoDate = airPhotoDate;
    }

    public LocalDate getIntroVideoDate() {
        return introVideoDate;
    }

    public void setIntroVideoDate(LocalDate introVideoDate) {
        this.introVideoDate = introVideoDate;
    }

    public LocalDate getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(LocalDate confirmDate) {
        this.confirmDate = confirmDate;
    }

    public LocalDate getSignupMaterialDate() {
        return signupMaterialDate;
    }

    public void setSignupMaterialDate(LocalDate signupMaterialDate) {
        this.signupMaterialDate = signupMaterialDate;
    }

    public LocalDate getUpdateEmailDate() {
        return updateEmailDate;
    }

    public void setUpdateEmailDate(LocalDate updateEmailDate) {
        this.updateEmailDate = updateEmailDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getSendPackageDate() {
        return sendPackageDate;
    }

    public void setSendPackageDate(LocalDate sendPackageDate) {
        this.sendPackageDate = sendPackageDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
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
