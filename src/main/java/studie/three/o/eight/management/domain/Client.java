package studie.three.o.eight.management.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.joda.time.LocalDateTime;
import studie.three.o.eight.management.domain.persistence.formatter.LocalDateTimeFormatter;

import java.util.ArrayList;

@DynamoDBTable(tableName = "three-o-eight-management-clients")
public class Client {

    @DynamoDBHashKey(attributeName = "Id")
    private String id;
    @DynamoDBAttribute(attributeName = "Name")
    private String name;
    @DynamoDBAttribute(attributeName = "Interval")
    private int interval;
    @DynamoDBAttribute(attributeName = "Open")
    private boolean open;
    @DynamoDBAttribute(attributeName = "WithoutTimeslot")
    private boolean withoutTimeslot;
    @DynamoDBAttribute(attributeName = "Password")
    private String password;
    @DynamoDBAttribute(attributeName = "Info")
    private String info;
    @DynamoDBAttribute(attributeName = "NatureSession")
    private boolean natureSession;
    @DynamoDBAttribute(attributeName = "SiblingSession")
    private boolean siblingSession;
    @DynamoDBAttribute(attributeName = "AvailableFrom")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime availableFrom;
    @DynamoDBAttribute(attributeName = "AvailableTo")
    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    private LocalDateTime availableTo;
    @DynamoDBAttribute(attributeName = "ChildrenCount")
    private int childrenCount;
    @DynamoDBAttribute(attributeName = "StaffCount")
    private int staffCount;
    @DynamoDBAttribute(attributeName = "GroupCount")
    private int groupCount;
    @DynamoDBAttribute(attributeName = "Groups")
    private String groups;
    @DynamoDBAttribute(attributeName = "OrganizationForm")
    private String organizationForm;
    @DynamoDBAttribute(attributeName = "Planning")
    private String planning;
    @DynamoDBAttribute(attributeName = "Note")
    private String note;
    @DynamoDBAttribute(attributeName = "Rebooked")
    private boolean rebooked;
    @DynamoDBAttribute(attributeName = "RoadName")
    private String roadName;
    @DynamoDBAttribute(attributeName = "ZipCode")
    private int zipCode;
    @DynamoDBAttribute(attributeName = "City")
    private String city;
    @DynamoDBAttribute(attributeName = "Revenues")
    private ArrayList<Revenue> revenues;
    @DynamoDBIgnore
    private ArrayList<Planning> plannings;
    @DynamoDBIgnore
    private ArrayList<Caretaker> caretakers;
    @DynamoDBIgnore
    private ArrayList<Staff> staffs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isWithoutTimeslot() {
        return withoutTimeslot;
    }

    public void setWithoutTimeslot(boolean withoutTimeslot) {
        this.withoutTimeslot = withoutTimeslot;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isNatureSession() {
        return natureSession;
    }

    public void setNatureSession(boolean natureSession) {
        this.natureSession = natureSession;
    }

    public boolean isSiblingSession() {
        return siblingSession;
    }

    public void setSiblingSession(boolean siblingSession) {
        this.siblingSession = siblingSession;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    public LocalDateTime getAvailableFrom() {
        return availableFrom;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    public void setAvailableFrom(LocalDateTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    public LocalDateTime getAvailableTo() {
        return availableTo;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeFormatter.class)
    public void setAvailableTo(LocalDateTime availableTo) {
        this.availableTo = availableTo;
    }

    public ArrayList<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(ArrayList<Revenue> revenues) {
        this.revenues = revenues;
    }

    public ArrayList<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(ArrayList<Planning> plannings) {
        this.plannings = plannings;
    }

    public ArrayList<Caretaker> getCaretakers() {
        return caretakers;
    }

    public void setCaretakers(ArrayList<Caretaker> caretakers) {
        this.caretakers = caretakers;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRebooked() {
        return rebooked;
    }

    public void setRebooked(boolean rebooked) {
        this.rebooked = rebooked;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", interval=" + interval +
                ", open=" + open +
                ", withoutTimeslot=" + withoutTimeslot +
                ", password='" + password + '\'' +
                ", info='" + info + '\'' +
                ", natureSession=" + natureSession +
                ", siblingSession=" + siblingSession +
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", childrenCount=" + childrenCount +
                ", staffCount=" + staffCount +
                ", groupCount=" + groupCount +
                ", groups='" + groups + '\'' +
                ", organizationForm='" + organizationForm + '\'' +
                ", planning='" + planning + '\'' +
                ", note='" + note + '\'' +
                ", rebooked=" + rebooked +
                ", roadName='" + roadName + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                ", revenues=" + revenues +
                ", plannings=" + plannings +
                ", caretakers=" + caretakers +
                ", staffs=" + staffs +
                '}';
    }
}
